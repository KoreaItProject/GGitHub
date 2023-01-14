package com.ggit.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ggit.vo.RepoVo;
import com.ggit.vo.RepomemVo;

@Repository
@Mapper
public interface RepomemMapper {
    List<RepomemVo> repomem();

    void join(RepomemVo repomemVo);

    void repoSortUpdate(RepomemVo repoVo);

    List<RepomemVo> selectrepomem(String reponame);

    int deleterepomem(String reponame, String nick);

    List<RepomemVo> updaterepomemauth(String nick, int auth);
}
