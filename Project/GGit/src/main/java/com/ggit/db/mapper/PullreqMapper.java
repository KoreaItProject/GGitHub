package com.ggit.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ggit.vo.PullreqVo;
import com.ggit.vo.RepoVo;
import com.ggit.vo.RepomemVo;

@Repository
@Mapper
public interface PullreqMapper {
    


    List<PullreqVo> pullreq();

    List<PullreqVo> pullreq_select(int idx);

    List<PullreqVo> pullreq_select_mem(int idx);
    
    RepomemVo repoInMem(RepoVo repoVo);

    int pullrequest(RepoVo repoVo);
}
