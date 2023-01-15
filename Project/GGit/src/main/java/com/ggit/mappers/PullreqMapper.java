package com.ggit.mappers;

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

    RepomemVo repoInMem(PullreqVo pullreqVo);

    int pullrequest(PullreqVo pullreqVo);

    String getLastMainToken(int repo_idx);

    int merge_main_push_count(int repo_idx);

    void savePullreq(int marged, String token);
}
