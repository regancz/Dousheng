package com.charles.dousheng.mbg.mapper;

import com.charles.dousheng.mbg.model.Follow;
import com.charles.dousheng.mbg.model.FollowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FollowMapper {
    long countByExample(FollowExample example);

    int deleteByExample(FollowExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Follow row);

    int insertSelective(Follow row);

    List<Follow> selectByExample(FollowExample example);

    Follow selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") Follow row, @Param("example") FollowExample example);

    int updateByExample(@Param("row") Follow row, @Param("example") FollowExample example);

    int updateByPrimaryKeySelective(Follow row);

    int updateByPrimaryKey(Follow row);
}