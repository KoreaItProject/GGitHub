package com.ggit.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

import org.apache.ibatis.binding.BindingException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.ggit.service.FollowService;
import com.ggit.service.PullreqService;
import com.ggit.service.PushService;
import com.ggit.service.RepoService;
import com.ggit.service.RepomemService;
import com.ggit.util.CopyFile;
import com.ggit.util.PushZip;
import com.ggit.util.RandStr;
import com.ggit.util.ReadData;
import com.ggit.util.WriteData;

import com.ggit.vo.PushVo;
import com.ggit.vo.RepoVo;
import com.ggit.vo.RepomemVo;
import com.ggit.vo.RepositoriesVO;
import com.ggit.vo.StorageVo;

@RestController
public class RepositoryController {

    @Autowired
    RepositoriesVO repositoriesVO;
    @Autowired
    RepoService repoService;
    @Autowired
    StorageVo storageVo;
    @Autowired
    RepoVo repoVo;
    @Autowired
    RepomemVo repomemVo;
    @Autowired
    RepomemService repomemService;
    @Autowired
    PushVo pushVo;
    @Autowired
    PushService pushService;
    @Autowired
    FollowService followService;
    @Autowired
    PullreqService pullreqService;

    @Value("${storage_dir}")
    String storage_dir;

    @RequestMapping("/createRepo")
    public int createRepo(@RequestBody String data) {
        // 저장소를 만들면 푸쉬가 한번 돼야한다
        // 저장소 만든 오너도 repomem에 넣어야한다 sort = 0
        //

        try {

            JSONObject jsonObject = (JSONObject) new JSONParser().parse(data);

            String repoName = (String) jsonObject.get("repoName");
            String description = (String) jsonObject.get("description");
            int pub = Integer.parseInt(jsonObject.get("pub") + "");
            int owner = Integer.parseInt(jsonObject.get("owner") + "");
            
            repoVo.setName(repoName);
            repoVo.setDescription(description);
            repoVo.setPubl(pub);
            repoVo.setOwner(owner);
            repoVo.setClone(new RandStr(35).getResult());
            repoService.createRepo(repoVo);// repo insert

            repomemVo.setMember(owner);
            repomemVo.setRepo(repoVo.getIdx());
            repomemService.join(repomemVo);// repomem insert

            String token = new RandStr(15).getResult();

            File file = new File(storage_dir + "repositorys/" + repoVo.getIdx() + "/" + token);
            file.mkdirs();

            new CopyFile().copy(new File(storage_dir + "def/"), file);

            String con = new ReadData(
                    storage_dir + "repositorys/" + repoVo.getIdx() + "/" + token + "/dump/pushData.txt").getCon();

            JSONArray pushData = (JSONArray) new JSONParser().parse(con);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nowTime = sdf.format(new Date()).toString();
            ((JSONObject) (pushData.get(0))).replace("date", nowTime);
            new WriteData(storage_dir + "repositorys/" + repoVo.getIdx() + "/" + token + "/dump/pushData.txt")
                    .write(pushData.toString());

            new PushZip(storage_dir + "repositorys/" + repoVo.getIdx() + "/" + token).run();// 다운로드와 pull을 위한
                                                                                            // zip파일을 미리
                                                                                            // 만들어둔다.
            pushVo.setToken(token);
            pushVo.setMember(owner);
            pushVo.setMessage("저장소 생성");
            pushVo.setRepo(repoVo.getIdx());
            pushService.push(pushVo);

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            return 0;
        }

        return 1;
    }

    @RequestMapping("/getPublic")
    public int getPublic(String nick, String repoName) {
        Map map = new HashMap<>();
        map.put("nick", nick);
        map.put("repoName", repoName);

        return repoService.getPublic(map);
    }

    @RequestMapping("checkRepo")
    public int checkRepo(int owner, String repoName) {

        Map map = new HashMap<>();
        map.put("owner", owner);
        map.put("repoName", repoName);

        return repoService.checkRepo(map);
    }

    @RequestMapping("getMD")
    public String getMD(String nick) {
        String con = null;
        Map<String, String> map = new HashMap<>();
        map.put("nick", nick);
        map.put("reponame", "README");

        int repoIdx = 0;
        try {
            repoIdx = repoService.repoIdxByNickName(map);
        } catch (BindingException e) {
            return con;
        }
        map.put("repoIdx", repoIdx + "");
        map.put("token", "push.token");
        String token = repoService.selectRepositorycode(map).getPush_token();
        con = new ReadData(storage_dir + "repositorys/" + repoIdx + "/" + token + "/data/README.md").getCon();
        return con;
    }

    @RequestMapping("/changeSelected")
    public int changeSelected(String token, String repo, String member, String ownerNick) {

        Map<String, String> map = new HashMap<>();
        map.put("repoName", repo);
        map.put("ownerNick", ownerNick);
        int repoidx = repoService.nameForIdx(map);

        map.put("token", token);
        map.put("repo", repoidx + "");
        map.put("member", member);
        pushService.delsel(map);
        pushService.insel(token);

        return 1;

    }

    @RequestMapping("/pushMainToMy")
    public int pushMainToMy(String token, String repo, String member, String ownerNick) {

        Map<String, String> map = new HashMap<>();
        map.put("repoName", repo);
        map.put("ownerNick", ownerNick);
        int repoidx = repoService.nameForIdx(map);

        String newToken = new RandStr(15).getResult();
        File targFile = new File(storage_dir + "repositorys/" + repoidx + "/" + newToken);
        targFile.mkdir();
        new CopyFile().copy(new File(storage_dir + "repositorys/" + repoidx + "/" + token),
                targFile);

        new File(storage_dir + "repositorys/" + repoidx + "/" + token + "/dump/pushChanged1.txt").delete();
        new File(storage_dir + "repositorys/" + repoidx + "/" + token + "/dump/pushChanged2.txt").delete();
        new WriteData(storage_dir + "repositorys/" + repoidx + "/" + token + "/dump/pushChanged1.txt")
                .write("[]");
        new WriteData(storage_dir + "repositorys/" + repoidx + "/" + token + "/dump/pushChanged2.txt")
                .write("[]");

        new PushZip(targFile.getPath()).run();
        pushVo.setToken(newToken);
        pushVo.setMember(Integer.parseInt(member));
        pushVo.setRepo(repoidx);
        pushVo.setMessage("메인 저장소에서 가져옴");
        pushVo.setBranch(Integer.parseInt(member));
        pushVo.setBefore_token(token);
        pushVo.setMain_token(token);
        pushVo.setFromMain(1);
        pushService.push(pushVo);

        return changeSelected(newToken, repo, member, ownerNick);
    }

    @RequestMapping("/myRepositories")
    public List<RepositoriesVO> myRepositories(String nick) {

        List<RepositoriesVO> repositories = repoService.selectRepositories(nick);
        return repositories;
    }

    @RequestMapping("/repoIdxByNickName")
    public int repoIdxByNickName(String nick, String reponame) {
        int repoIdxByNickName;
        try {
            Map<String, String> map = new HashMap<String, String>();
            map.put("nick", nick);
            map.put("reponame", reponame);
            repoIdxByNickName = repoService.repoIdxByNickName(map);

        } catch (Exception e) {
            return 0;
        }
        return repoIdxByNickName;

    }

    @RequestMapping("/insertFollow")
    public int insertFollow(String nick, int idx) {

        int insertFollow = followService.insertFollow(nick, idx);
        return 1;
    }

    @RequestMapping("/selectfollowcount")
    public int selectfollowcount(int idx, String nick) {
        // System.out.println(idx);
        // System.out.println(nick);
        int followcount = followService.selectfollowcount(idx, nick);
        return followcount;
    }

    @RequestMapping("/selectRepositorycode")
    public RepositoriesVO selectRepositorycode(int repoIdx, String token) {
        Map<String, String> map = new HashMap<>();
        map.put("repoIdx", repoIdx + "");
        if (token != null && !token.equals("")) {
            map.put("token", "\'" + token + "\'");
        } else {

            map.put("token", "push.token");
        }
        RepositoriesVO Repositorycode = repoService.selectRepositorycode(map);
        return Repositorycode;
    }

    @RequestMapping("/selectRepositoryMyCode")
    public RepositoriesVO selectRepositoryMyCode(int repoIdx, int member) {

        RepositoriesVO repositoriesVO = null;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("repoIdx", repoIdx);
        map.put("member", member);
        repositoriesVO = repoService.selectRepositoryMyCode(map);
        if (repositoriesVO == null) {
            HashMap<String, String> map1 = new HashMap<>();
            map1.put("repoIdx", repoIdx + "");
            map1.put("token", "push.token");
            repositoriesVO = repoService.selectRepositorycode(map1);
        }

        return repositoriesVO;
    }

    @RequestMapping("/selectRepositorycontributors")
    public List<RepositoriesVO> selectRepositorycontributors(int repoIdx) {

        List<RepositoriesVO> Repositorycontributors = repoService.selectRepositorycontributors(repoIdx);
        return Repositorycontributors;
    }

    @RequestMapping("/selectRepositorystar")
    public List<RepositoriesVO> selectRepositorystar(int repoIdx) {

        List<RepositoriesVO> Repositorystar = repoService.selectRepositorystar(repoIdx);
        return Repositorystar;
    }

    @RequestMapping("/getFile")
    public List<StorageVo> getFile(int repoIdx, String token, String path) {

        if (path == null) {
            path = "";
        }
        String filePath = storage_dir + "repositorys/" + repoIdx + "/" + token + "/data/" + path;

        List<StorageVo> list = new ArrayList<StorageVo>();
        File folder = new File(filePath);
        if (!folder.isDirectory() && !folder.isFile()) {// 틀린path라면
            storageVo.setState("notPath");
            list.add(storageVo);
            return list;
        }
        File files[] = folder.listFiles();

        String con = new ReadData(storage_dir + "repositorys/" + repoIdx + "/" + token + "/dump/pushData.txt")
                .getCon();

        JSONParser parser = new JSONParser();
        try {
            JSONArray data = (JSONArray) parser.parse(con);

            String searchStr = "/README.md";

            if (folder.isFile()) {
                StorageVo file = new StorageVo();
                String content = "";
                content = fileLeader(filePath, file);
                file.setState("file");
                file.setContent(content);
                file.setName(folder.getName());
                list.add(file);

                return list;
            }
            if (files.length == 0) {// 폴더에파일없음
                storageVo.setState("empty");
                list.add(storageVo);
                return list;
            }
            try {
                for (int i = 0; i < files.length; i++) {
                    StorageVo file = new StorageVo();
                    if (files[i].getName().equals("README.md")) {
                        file.setState("readme");
                        String content = "";
                        content = fileLeader(filePath + "/README.md", file);
                        file.setContent(content);
                    }
                    file.setName(files[i].getName());
                    file.setDirectory(files[i].isDirectory());

                    if (path.equals("")) {
                        searchStr = "/" + files[i].getName();
                    } else {
                        searchStr = "/" + path + "/" + files[i].getName();
                    }

                    for (int j = 0; j < data.size(); j++) {

                        if (((JSONObject) data.get(j)).get("path").equals(searchStr)) {
                            file.setPush_message(((JSONObject) data.get(j)).get("message") + "");
                            file.setPush_date(((JSONObject) data.get(j)).get("date") + "");

                        }
                    }

                    list.add(file);

                }
                list = (ArrayList<StorageVo>) (list.stream()
                        .sorted(Comparator.comparing(StorageVo::getDirectory).reversed())
                        .collect(Collectors.toList()));

            } catch (NullPointerException e) {
                System.out.println("파일없음");
            }
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return list;
    }

    public String fileLeader(String filePath, StorageVo file) {
        String content = "";
        BufferedReader reader;
        int count = 0;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(
                            filePath), "UTF-8"));
            String str;

            while ((str = reader.readLine()) != null) {
                content += str + "\n";
                count++;
            }
            reader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        file.setTotalLine(count);

        return content;
    }

    @RequestMapping("selectRepositorycount")
    public int selectRepositorycount(String nick, boolean isMy) {

        Map<String, String> map = new HashMap<>();
        map.put("nick", nick);
        String publ = "1";
        if (isMy) {
            publ = "repo.public";
        }
        map.put("publ", publ);
        int Repositorycount = repoService.selectRepositorycount(map);
        return Repositorycount;

    }

    @RequestMapping("selectRepositorystarcount")
    public int selectRepositorystarcount(String nick) {
        int Repositorystarcount = repoService.selectRepositorystarcount(nick);
        return Repositorystarcount;
    }

    @RequestMapping("selectRepoClone")
    public List<RepositoriesVO> selectRepoClone(int repoIdx) {
        // System.out.println(repoIdx);
        List<RepositoriesVO> RepoClone = repoService.selectRepoClone(repoIdx);
        return RepoClone;
    }

    // 저장소 이름 변경
    @RequestMapping("repo_rename")
    public int repo_rename(@RequestBody RepoVo repovo) {
        return repoService.repo_rename(repovo);
    }

    // 저장소 소개글 가져오기
    @RequestMapping("getrepomessage")
    public RepoVo getrepomessage(@RequestBody RepoVo repovo) {
        // System.out.println("-=-=>" + repovo.getIdx());
        return repoService.getrepomessage(repovo);
    }

    // 저장소 소개글 업데이트
    @RequestMapping("repo_remessage_func")
    public int repo_remessage_func(@RequestBody RepoVo repovo) {
        return repoService.repo_remessage_func(repovo);
    }

    @RequestMapping("/selectHistory")
    public List<RepositoriesVO> selectHistory(String mode, String repo, int member, String ownerNick) {
        List<RepositoriesVO> list = null;
        Map<String, String> map = new HashMap<String, String>();
        map.put("repo", repo);
        map.put("ownerNick", ownerNick);

        if (mode.equals("main")) {
            map.put("branch", 0 + "");
        } else {
            map.put("branch", member + "");
        }
        list = repoService.selectHistory(map);

        return list;

    }

    @RequestMapping("/getHistoryChanged")
    public JSONArray getHistoryChanged(int repo, String token) {
        JSONArray changed = null;
        try {
            String con = new ReadData(storage_dir + "repositorys/" + repo + "/" + token + "/dump/pushChanged1.txt")
                    .getCon();
            changed = (JSONArray) (new JSONParser()).parse(con);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(123);
        return changed;
    }

    // 존재하는 저장소인지 확인(저장소 이름으로 select)
    @RequestMapping("find_repo")
    public int find_repo(@RequestBody RepoVo repo) {
        return repoService.find_repo(repo.getName());
    }

    // 저장소에 속해있는지 확인
    @RequestMapping("repoMemCheck")
    public RepoVo repoMemCheck(@RequestBody RepoVo repoVo) {
        return repoService.repoMemCheck(repoVo);
    }

    @RequestMapping("selectrepomem")
    public List<RepomemVo> selectrepomem(String reponame) {
        List<RepomemVo> selectrepomem = repomemService.selectrepomem(reponame);
        return selectrepomem;
    }

    @RequestMapping("deleterepomem")
    public int deleterepomem(String reponame, String nick) {

        int deleterepomem = repomemService.deleterepomem(reponame, nick);
        return deleterepomem;
    }

    @RequestMapping("setPublic")
    public void setPublic(RepoVo repoVo) {

        repoService.setPublic(repoVo);
    }

    @RequestMapping("deleterepo")
    public int deleterepo(int repoidx) {
        if (repoidx == 0) {
            return 0;
        }

        repoService.deleteRepo(repoidx, storage_dir);

        return 1;
    }

}
