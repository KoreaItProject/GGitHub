package com.ggit.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ggit.vo.RepositoriesVO;
import com.ggit.vo.StarVo;

@Repository
@Mapper
public interface StarMapper {
    public List<StarVo> star();

    public List<RepositoriesVO> selectStarlist(Map<String, String> map);

    public int starTotal(Map<String, String> map);

    public int selectstarcount(String repoidx, int idx);

    public int insertStar(String repoidx, int idx);

    public int deleteStar(String repoidx, int idx);

}
