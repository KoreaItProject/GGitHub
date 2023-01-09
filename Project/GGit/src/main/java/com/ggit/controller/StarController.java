package com.ggit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggit.service.RepoService;
import com.ggit.service.StarService;
import com.ggit.vo.RepositoriesVO;
import com.ggit.vo.StarVo;

@RestController
public class StarController {

    @Autowired
    StarVo starVo;

    @Autowired
    StarService starService;

    @Autowired
    RepoService repoService;

    @RequestMapping("selectStarlist")
    public List<RepositoriesVO> selectStarlist(String member, String search, int page, String sort) {

        int count = 10;
        int start = (page - 1) * count;

        List<RepositoriesVO> list = null;
        Map<String, String> map = new HashMap<String, String>();

        if (member != null) {

            map.put("member", member);
            map.put("search", search);
            map.put("start", start + "");
            map.put("count", count + "");
            map.put("publ", "repo.public");
            list = starService.selectStarlist(map);

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

    @RequestMapping("starTotal")
    public int starTotal(String member, String search) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("member", member);
        map.put("search", search);
        map.put("publ", "repo.public");
        return starService.starTotal(map);
    }

    @RequestMapping("selectstarcount")
    public int selectstarcount(String repoidx, int idx) {

        int selectstarcount = starService.selectstarcount(repoidx, idx);
        return selectstarcount;
    }

    @RequestMapping("insertStar")
    public int insertStar(String repoidx, int idx) {

        int insertStar = starService.insertStar(repoidx, idx);
        return 1;
    }

    @RequestMapping("deleteStar")
    public int deleteStar(String repoidx, int idx) {

        int deleteStar = starService.deleteStar(repoidx, idx);
        return 1;
    }

}
