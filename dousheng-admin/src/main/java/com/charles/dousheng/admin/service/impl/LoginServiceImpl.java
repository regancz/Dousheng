package com.charles.dousheng.admin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.charles.dousheng.common.crypto.JwtProcessor;
import com.charles.dousheng.admin.dto.RegisterParam;
import com.charles.dousheng.admin.dto.RegisterResult;
import com.charles.dousheng.admin.dto.UserInfoParam;
import com.charles.dousheng.admin.dto.UserInfoResult;
import com.charles.dousheng.common.exception.Asserts;
import com.charles.dousheng.common.id.IdProcessor;
import com.charles.dousheng.mbg.mapper.FollowMapper;
import com.charles.dousheng.mbg.mapper.UserMapper;
import com.charles.dousheng.mbg.model.Follow;
import com.charles.dousheng.mbg.model.FollowExample;
import com.charles.dousheng.mbg.model.User;
import com.charles.dousheng.mbg.model.UserExample;
import com.charles.dousheng.admin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * @author charles
 * @date 5/1/2023 10:03 PM
 */
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FollowMapper followMapper;

    @Override
    public RegisterResult register(RegisterParam registerParam) {
        // 查询是否已有该用户
        UserExample userExample = new UserExample();
        userExample.createCriteria().andNameEqualTo(registerParam.getUsername());
        List<User> users = userMapper.selectByExample(userExample);
        if (!CollectionUtils.isEmpty(users)) {
            Asserts.fail("该用户已经存在");
        }
        // 生成jwt
        String jwt = JwtProcessor.createJwt(users.get(0).getId(), registerParam.getUsername(), registerParam.getPassword());
        // 没有该用户进行添加操作
        User user = new User();
        user.setId(IdProcessor.getId());
        user.setName(registerParam.getUsername());
        user.setPassword(DigestUtils.md5DigestAsHex(registerParam.getPassword().getBytes()));
        if (userMapper.insert(user) == 0)
            return null;
        // 生成result
        RegisterResult registerResult = new RegisterResult();
        registerResult.setToken(jwt);
        registerResult.setUserid(user.getId());
        return registerResult;
    }

    @Override
    public RegisterResult login(RegisterParam registerParam) {
        if(StrUtil.isEmpty(registerParam.getUsername())||StrUtil.isEmpty(registerParam.getPassword())){
            Asserts.fail("用户名或密码不能为空！");
        }
        // 查询是否已有该用户
        UserExample userExample = new UserExample();
        userExample.createCriteria().andNameEqualTo(registerParam.getUsername());
        List<User> users = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(users)) {
            Asserts.fail("该用户不存在");
        }
        // 生成jwt
        String jwt = JwtProcessor.createJwt(users.get(0).getId(), registerParam.getUsername(), registerParam.getPassword());
        RegisterResult registerResult = new RegisterResult();
        registerResult.setToken(jwt);
        registerResult.setUserid(users.get(0).getId());
        return registerResult;
    }

    @Override
    public UserInfoResult userInfo(UserInfoParam userInfoParam) {
        Object userId = JwtProcessor.parseJwt(userInfoParam.getToken());
        if (userId == null) {
            return null;
        }
        // 查询是否已有该用户
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo((Long) userId);
        List<User> users = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(users)) {
            Asserts.fail("该用户不存在");
        }
        // 查询用户是否关注
        FollowExample followExample = new FollowExample();
        followExample.createCriteria().andUserIdEqualTo((Long) userId).andFollowIdEqualTo(userInfoParam.getUserid());
        List<Follow> follows = followMapper.selectByExample(followExample);
        UserInfoResult userInfoResult = new UserInfoResult();
        if (CollectionUtils.isEmpty(follows)) {
            userInfoResult.setFollow(false);
        }
        User user = users.get(0);
        userInfoResult.setName(user.getName());
        userInfoResult.setId(user.getId());
        userInfoResult.setPassword(user.getPassword());
        userInfoResult.setFollowCount(user.getFollowCount());
        userInfoResult.setFollowerCount(user.getFollowerCount());
        userInfoResult.setFollow(true);
        return null;
    }
}
