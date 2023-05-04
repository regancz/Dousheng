package com.charles.dousheng.video.service.impl;

import com.charles.dousheng.common.crypto.JwtProcessor;
import com.charles.dousheng.common.id.IdProcessor;
import com.charles.dousheng.mbg.mapper.FollowMapper;
import com.charles.dousheng.mbg.mapper.UserMapper;
import com.charles.dousheng.mbg.model.Follow;
import com.charles.dousheng.mbg.model.FollowExample;
import com.charles.dousheng.mbg.model.User;
import com.charles.dousheng.mbg.model.UserExample;
import com.charles.dousheng.video.dto.RelationFollowListParam;
import com.charles.dousheng.video.service.RelationUserService;
import com.charles.dousheng.video.dto.RelationActionParam;
import com.charles.dousheng.video.dto.RelationFollowerListParam;
import com.charles.dousheng.video.dto.UserResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author charles
 * @date 5/1/2023 10:10 PM
 */
@Service
public class RelationUserUserServiceImpl implements RelationUserService {
    @Autowired
    private FollowMapper followMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserResult> relationFollowList(RelationFollowListParam relationFollowListParam) {
        // 解析jwt
        Object userId = JwtProcessor.parseJwt(relationFollowListParam.getToken());
        if (userId == null) {
            return null;
        }
        List<UserResult> userResults = new ArrayList<>();
        FollowExample followExample = new FollowExample();
        followExample.createCriteria().andUserIdEqualTo((Long) userId);
        List<Follow> follows = followMapper.selectByExample(followExample);
        for (Follow follow : follows) {
            // 查询用户表
            UserExample userExample = new UserExample();
            userExample.createCriteria().andIdEqualTo(follow.getFollowId());
            List<User> users = userMapper.selectByExample(userExample);
            User user = users.get(0);
            UserResult userResult = new UserResult();
            userResult.setName(user.getName());
            userResult.setFollow(true);
            userResult.setFollowerCount(user.getFollowerCount());
            userResult.setFollowCount(user.getFollowCount());
            userResult.setId((Long) userId);
            userResults.add(userResult);
        }
        return userResults;
    }

    @Override
    public List<UserResult> relationFollowerList(RelationFollowerListParam relationFollowerListParam) {
        // 解析jwt
        Object userId = JwtProcessor.parseJwt(relationFollowerListParam.getToken());
        if (userId == null) {
            return null;
        }
        List<UserResult> userResults = new ArrayList<>();
        FollowExample followExample = new FollowExample();
        followExample.createCriteria().andFollowIdEqualTo((Long) userId);
        List<Follow> follows = followMapper.selectByExample(followExample);
        for (Follow follow : follows) {
            // 查询用户表
            UserExample userExample = new UserExample();
            userExample.createCriteria().andIdEqualTo(follow.getUserId());
            List<User> users = userMapper.selectByExample(userExample);
            User user = users.get(0);
            UserResult userResult = new UserResult();
            userResult.setName(user.getName());
            userResult.setFollowerCount(user.getFollowerCount());
            userResult.setFollowCount(user.getFollowCount());
            userResult.setId((Long) userId);
            // 查询关注表
            FollowExample followExample1 = new FollowExample();
            followExample1.createCriteria().andUserIdEqualTo(follow.getFollowId()).andFollowIdEqualTo(follow.getUserId());
            List<Follow> follows1 = followMapper.selectByExample(followExample1);
            Follow follow1 = follows1.get(0);
            userResult.setFollow(follow1 == null);
            userResults.add(userResult);
        }
        return userResults;
    }

    @Override
    public int relationAction(RelationActionParam relationActionParam) {
        // 解析jwt
        Object userId = JwtProcessor.parseJwt(relationActionParam.getToken());
        if (userId == null) {
            return 1;
        }
        // 根据actionType判断插入还是更新
        if (Objects.equals(relationActionParam.getActionType(), "1")) {
            Follow follow = new Follow();
            follow.setId(IdProcessor.getId());
            follow.setUserId((Long) userId);
            follow.setState(true);
            follow.setFollowId(relationActionParam.getToUserid());
            return followMapper.insert(follow) - 1;
        } else if (Objects.equals(relationActionParam.getActionType(), "0")) {
            Follow follow = new Follow();
            follow.setId(IdProcessor.getId());
            follow.setUserId((Long) userId);
            follow.setState(true);
            follow.setFollowId(relationActionParam.getToUserid());
            return followMapper.updateByPrimaryKey(follow) - 1;
        }
        return 1;
    }
}
