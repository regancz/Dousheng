package com.charles.dousheng.video.service.impl;

import com.charles.dousheng.common.crypto.JwtProcessor;
import com.charles.dousheng.mbg.model.*;
import com.charles.dousheng.video.dto.FavoriteActionParam;
import com.charles.dousheng.video.dto.UserParam;
import com.charles.dousheng.video.dto.UserResult;
import com.charles.dousheng.video.dto.VideoResult;
import com.charles.dousheng.common.id.IdProcessor;
import com.charles.dousheng.mbg.mapper.FollowMapper;
import com.charles.dousheng.mbg.mapper.UserMapper;
import com.charles.dousheng.mbg.mapper.UserVideoMapper;
import com.charles.dousheng.mbg.mapper.VideoMapper;
import com.charles.dousheng.video.service.FavoriteVideoService;
import com.charles.dousheng.common.service.RedisService;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author charles
 * @date 5/1/2023 10:09 PM
 */
@Service
public class FavoriteVideoVideoServiceImpl implements FavoriteVideoService {
    @Autowired
    private UserVideoMapper userVideoMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FollowMapper followMapper;

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private RedisService redisService;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public List<VideoResult> favoriteList(UserParam userParam) {
        // 解析jwt
        Object userId = JwtProcessor.parseJwt(userParam.getToken());
        if (userId == null) {
            return null;
        }
        // 查询用户点赞视频
        UserVideoExample userVideoExample = new UserVideoExample();
        userVideoExample.createCriteria().andUserIdEqualTo(userParam.getUser_id());
        List<UserVideo> userVideos = userVideoMapper.selectByExample(userVideoExample);
        List<VideoResult> videoResults = new ArrayList<>();
        for (UserVideo userVideo: userVideos) {
            // 查询用户表信息
            UserExample userExample = new UserExample();
            userExample.createCriteria().andIdEqualTo(userVideo.getUserId());
            List<User> users = userMapper.selectByExample(userExample);
            User user = users.get(0);
            UserResult userResult = new UserResult();
            userResult.setName(user.getName());
            userResult.setId(user.getId());
            userResult.setFollowCount(user.getFollowCount());
            userResult.setFollowerCount(user.getFollowerCount());
            // 查询视频表信息
            VideoExample videoExample = new VideoExample();
            videoExample.createCriteria().andIdEqualTo(userVideo.getVideoId());
            List<Video> videoList = videoMapper.selectByExample(videoExample);
            Video video = videoList.get(0);
            VideoResult videoResult = new VideoResult();
            videoResult.setId(video.getId());
            videoResult.setTitle(video.getTitle());
            videoResult.setCoverUrl(video.getCoverUrl());
            videoResult.setPlayUrl(video.getPlayUrl());
            videoResult.setCommentCount(video.getCommentCount());
            videoResult.setFavoriteCount(video.getFavoriteCount());
            // 查询用户视频表信息
            UserVideoExample example = new UserVideoExample();
            example.createCriteria().andUserIdEqualTo((Long) userId).andVideoIdEqualTo(userVideo.getVideoId());
            List<UserVideo> userVideoList = userVideoMapper.selectByExample(example);
            videoResult.setFavorite(userVideoList != null);
            // 查询用户关注表信息
            FollowExample followExample = new FollowExample();
            followExample.createCriteria().andUserIdEqualTo((Long) userId).andFollowIdEqualTo(userVideo.getUserId());
            List<Follow> follows = followMapper.selectByExample(followExample);
            userResult.setFollow(follows != null);
            videoResult.setAuthor(userResult);
            videoResults.add(videoResult);
        }
        return videoResults;
    }

    @Override
    public int favoriteAction(FavoriteActionParam favoriteActionParam) {
        // 解析jwt
        Object userId = JwtProcessor.parseJwt(favoriteActionParam.getToken());
        if (userId == null) {
            return 1;
        }
        // 根据actionType判断插入还是更新
        if (Objects.equals(favoriteActionParam.getActionType(), "1")) {
            UserVideo userVideo = new UserVideo();
            userVideo.setVideoId(favoriteActionParam.getVideoid());
            userVideo.setUserId((Long) userId);
            userVideo.setId(IdProcessor.getId());
            userVideo.setState(Objects.equals(favoriteActionParam.getActionType(), "1"));
            return userVideoMapper.insert(userVideo) - 1;
        } else if (Objects.equals(favoriteActionParam.getActionType(), "0")) {
            UserVideo userVideo = new UserVideo();
            userVideo.setVideoId(favoriteActionParam.getVideoid());
            userVideo.setUserId((Long) userId);
            userVideo.setId(IdProcessor.getId());
            userVideo.setState(Objects.equals(favoriteActionParam.getActionType(), "0"));
            return userVideoMapper.updateByPrimaryKey(userVideo) - 1;
        }
        return 1;
    }
}
