package com.charles.dousheng.mbg.mapper;

import com.charles.dousheng.mbg.model.VideoAttribute;
import com.charles.dousheng.mbg.model.VideoAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoAttributeMapper {
    long countByExample(VideoAttributeExample example);

    int deleteByExample(VideoAttributeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VideoAttribute row);

    int insertSelective(VideoAttribute row);

    List<VideoAttribute> selectByExample(VideoAttributeExample example);

    VideoAttribute selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") VideoAttribute row, @Param("example") VideoAttributeExample example);

    int updateByExample(@Param("row") VideoAttribute row, @Param("example") VideoAttributeExample example);

    int updateByPrimaryKeySelective(VideoAttribute row);

    int updateByPrimaryKey(VideoAttribute row);
}