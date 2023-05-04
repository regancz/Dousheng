package com.charles.dousheng.mbg.mapper;

import com.charles.dousheng.mbg.model.UserVideo;
import com.charles.dousheng.mbg.model.UserVideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserVideoMapper {
    long countByExample(UserVideoExample example);

    int deleteByExample(UserVideoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserVideo row);

    int insertSelective(UserVideo row);

    List<UserVideo> selectByExample(UserVideoExample example);

    UserVideo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") UserVideo row, @Param("example") UserVideoExample example);

    int updateByExample(@Param("row") UserVideo row, @Param("example") UserVideoExample example);

    int updateByPrimaryKeySelective(UserVideo row);

    int updateByPrimaryKey(UserVideo row);
}