package com.charles.dousheng.mbg.mapper;

import com.charles.dousheng.mbg.model.VideoAttributeValue;
import com.charles.dousheng.mbg.model.VideoAttributeValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoAttributeValueMapper {
    long countByExample(VideoAttributeValueExample example);

    int deleteByExample(VideoAttributeValueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VideoAttributeValue row);

    int insertSelective(VideoAttributeValue row);

    List<VideoAttributeValue> selectByExample(VideoAttributeValueExample example);

    VideoAttributeValue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") VideoAttributeValue row, @Param("example") VideoAttributeValueExample example);

    int updateByExample(@Param("row") VideoAttributeValue row, @Param("example") VideoAttributeValueExample example);

    int updateByPrimaryKeySelective(VideoAttributeValue row);

    int updateByPrimaryKey(VideoAttributeValue row);
}