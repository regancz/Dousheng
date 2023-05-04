package com.charles.dousheng.mbg.mapper;

import com.charles.dousheng.mbg.model.Video;
import com.charles.dousheng.mbg.model.VideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoMapper {
    long countByExample(VideoExample example);

    int deleteByExample(VideoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Video row);

    int insertSelective(Video row);

    List<Video> selectByExample(VideoExample example);

    Video selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") Video row, @Param("example") VideoExample example);

    int updateByExample(@Param("row") Video row, @Param("example") VideoExample example);

    int updateByPrimaryKeySelective(Video row);

    int updateByPrimaryKey(Video row);
}