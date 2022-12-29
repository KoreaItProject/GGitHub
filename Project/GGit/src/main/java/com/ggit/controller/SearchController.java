package com.ggit.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.ibatis.binding.BindingException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.core.JsonParser;
import com.ggit.service.FollowService;
import com.ggit.service.PullreqService;
import com.ggit.service.PushService;
import com.ggit.service.RepoService;
import com.ggit.service.RepomemService;
import com.ggit.util.CopyFile;
import com.ggit.util.RandStr;
import com.ggit.util.ReadData;
import com.ggit.util.WriteData;
import com.ggit.vo.FollowVo;
import com.ggit.vo.PullreqVo;
import com.ggit.vo.PushVo;
import com.ggit.vo.RepoVo;
import com.ggit.vo.RepomemVo;
import com.ggit.vo.RepositoriesVO;
import com.ggit.vo.StorageVo;

@RestController
public class SearchController {

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

    @RequestMapping("/searchSimple")
    public List<RepositoriesVO> searchSimple(String member, String search) {

        List<RepositoriesVO> list = null;
        if (member != null) {

            Map<String, String> map = new HashMap<String, String>();
            map.put("member", member);
            map.put("search", search);
            list = repoService.searchSimple(map);

        }

        return list;
    }

    @RequestMapping("/searchPageCount")
    public int searchPageCount(String member, String search) {

        List<RepositoriesVO> list = null;
        String publ = "repo.public";
        if (member != null) {

            Map<String, String> map = new HashMap<String, String>();
            if (member.equals("member")) {
                publ = "1";
            }
            map.put("member", member);
            map.put("search", search);
            map.put("publ", publ);
            return repoService.searchPageCount(map);

        }

        return 0;
    }

    @RequestMapping("/search")
    public List<RepositoriesVO> search(String member, String search, int page, String sort) {

        int count = 10;
        int start = (page - 1) * count;

        List<RepositoriesVO> list = null;
        Map<String, String> map = new HashMap<String, String>();
        String publ = "repo.public";

        if (member != null) {
            if (member.equals("member")) {
                publ = "1";
            }
            map.put("member", member);
            map.put("search", search);
            map.put("start", start + "");
            map.put("count", count + "");
            map.put("publ", publ);
            list = repoService.search(map);

        }
        for (int i = 0; i < list.size(); i++) {
            RepositoriesVO rv = list.get(i);
            rv.setS_nick(
                    rv.getMember_nick().replaceAll("(?i)" + search, "<span class='pink_back'>" + search + "</span>"));
            rv.setS_name(
                    rv.getRepo_name().replaceAll("(?i)" + search, "<span class='pink_back'>" + search + "</span>"));
            rv.setS_description(
                    rv.getDescription().replaceAll("(?i)" + search, "<span class='pink_back'>" + search + "</span>"));
        }

        return list;
    }
}
