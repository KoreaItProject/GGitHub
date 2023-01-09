package com.ggit.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggit.db.mapper.StarMapper;
import com.ggit.vo.RepositoriesVO;
import com.ggit.vo.StarVo;

@Service
public class StarService {
    @Autowired
    public StarMapper mapper;

    public List<StarVo> star() {
        return mapper.star();
    }

    public List<RepositoriesVO> selectStarlist(Map<String, String> map) {
        return mapper.selectStarlist(map);
    }

    public int starTotal(Map<String, String> map) {
        return mapper.starTotal(map);
    }

    public int selectstarcount(String repoidx, int idx) {
        return mapper.selectstarcount(repoidx, idx);
    }

    public int insertStar(String repoidx, int idx) {
        return mapper.insertStar(repoidx, idx);
    }

    public int deleteStar(String repoidx, int idx) {
        return mapper.deleteStar(repoidx, idx);
    }

}
