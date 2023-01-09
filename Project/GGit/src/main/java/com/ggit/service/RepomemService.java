package com.ggit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ggit.mappers.RepomemMapper;
import com.ggit.vo.RepomemVo;

@Service
public class RepomemService {

    @Autowired
    public RepomemMapper mapper;

    public List<RepomemVo> repomem() {
        return mapper.repomem();
    }

    public void join(RepomemVo repomemVo) {
        mapper.join(repomemVo);
    }

    public void repoSortUpdate(RepomemVo repoVo) {
        mapper.repoSortUpdate(repoVo);
    }

    public List<RepomemVo> selectrepomem(String reponame) {
        return mapper.selectrepomem(reponame);
    }

    public int deleterepomem(String reponame, String nick) {
        return mapper.deleterepomem(reponame, nick);
    }
}
