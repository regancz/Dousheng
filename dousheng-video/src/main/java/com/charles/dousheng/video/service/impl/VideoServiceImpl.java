package com.charles.dousheng.video.service.impl;

import com.charles.dousheng.common.crypto.JwtProcessor;
import com.charles.dousheng.common.id.IdProcessor;
import com.charles.dousheng.mbg.mapper.FollowMapper;
import com.charles.dousheng.mbg.mapper.UserMapper;
import com.charles.dousheng.mbg.mapper.UserVideoMapper;
import com.charles.dousheng.mbg.mapper.VideoMapper;
import com.charles.dousheng.mbg.model.*;
import com.charles.dousheng.video.dto.*;
import com.charles.dousheng.video.service.MinioService;
import com.charles.dousheng.video.service.VideoService;
import org.apache.commons.compress.utils.IOUtils;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author charles
 * @date 4/30/2023 5:41 PM
 */
@Service
public class VideoServiceImpl implements VideoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(VideoServiceImpl.class);
    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private UserVideoMapper userVideoMapper;

    @Autowired
    private FollowMapper followMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MinioService minioService;

    @Override
    public FeedInfo feed(FeedParam feedParam) {
        // 解析jwt
        Object userId = JwtProcessor.parseJwt(feedParam.getToken());
        if (userId == null) {
            return null;
        }
        FeedInfo feedInfo = new FeedInfo();
        // 查询是否点赞视频
        VideoExample videoExample = new VideoExample();
        videoExample.setOrderByClause("create_time DESC");
        List<Video> videoList = videoMapper.selectByExample(videoExample);
        List<VideoResult> videoResults = new ArrayList<>();
        for (Video video : videoList) {
            // 查询用户表信息
            UserExample userExample = new UserExample();
            userExample.createCriteria().andIdEqualTo(video.getAuthorId());
            List<User> users = userMapper.selectByExample(userExample);
            User user = users.get(0);
            UserResult userResult = new UserResult();
            userResult.setName(user.getName());
            userResult.setId(user.getId());
            userResult.setFollowCount(user.getFollowCount());
            userResult.setFollowerCount(user.getFollowerCount());
            // 查询视频表信息
            VideoResult videoResult = new VideoResult();
            videoResult.setId(video.getId());
            videoResult.setTitle(video.getTitle());
            videoResult.setCoverUrl(video.getCoverUrl());
            videoResult.setPlayUrl(video.getPlayUrl());
            videoResult.setCommentCount(video.getCommentCount());
            videoResult.setFavoriteCount(video.getFavoriteCount());
            // 查询用户视频表信息
            UserVideoExample example = new UserVideoExample();
            example.createCriteria().andUserIdEqualTo((Long) userId).andVideoIdEqualTo(video.getAuthorId());
            List<UserVideo> userVideos = userVideoMapper.selectByExample(example);
            videoResult.setFavorite(userVideos != null);
            // 查询用户关注表信息
            FollowExample followExample = new FollowExample();
            followExample.createCriteria().andUserIdEqualTo((Long) userId).andFollowIdEqualTo(video.getAuthorId());
            List<Follow> follows = followMapper.selectByExample(followExample);
            userResult.setFollow(follows != null);
            videoResult.setAuthor(userResult);
            videoResults.add(videoResult);
        }
        feedInfo.setVideoList(videoResults);
        return null;
    }

    @Override
    public int publishVideo(PublishVideoParam publishVideoParam) {
        // 解析jwt
        Object userId = JwtProcessor.parseJwt(publishVideoParam.getToken());
        if (userId == null) {
            return 0;
        }
        try {
            File file = publishVideoParam.getData();
            FileInputStream input = new FileInputStream(file);
            MultipartFile multipartFile = new MockMultipartFile(
                    publishVideoParam.getToken() + "-" + publishVideoParam.getTitle() + "-video.mp4", file.getName(),
                    "text/plain", IOUtils.toByteArray(input));
            MinioUploadDto minioUploadVideoDto = minioService.upload(multipartFile);
            BufferedImage bufferedImage = ExecuteFrame(file);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            assert bufferedImage != null;
            ImageIO.write(bufferedImage, "jpg", out);
            MultipartFile mockMultipartFile = new MockMultipartFile(
                    publishVideoParam.getToken() + "-" + publishVideoParam.getTitle() + "-cover.jpg", out.toByteArray());
            MinioUploadDto minioUploadCoverDto = minioService.upload(mockMultipartFile);
            Video video = new Video(IdProcessor.getId(), publishVideoParam.getTitle(), (Long) userId, new Date(),
                    minioUploadVideoDto.getUrl(), minioUploadCoverDto.getUrl(), 0L, 0L);
            return videoMapper.insert(video);
        } catch (Exception e) {
            LOGGER.info("{}, {} publishVideo ERROR", publishVideoParam.getToken(), publishVideoParam.getTitle());
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<VideoResult> publishedVideoList(UserParam userParam) {
        // 解析jwt
        Object userId = JwtProcessor.parseJwt(userParam.getToken());
        if (userId == null) {
            return null;
        }
        // 查询userId的视频
        List<VideoResult> videoResults = new ArrayList<>();
        VideoExample videoExample = new VideoExample();
        videoExample.createCriteria().andAuthorIdEqualTo(Long.valueOf(userParam.getUser_id()));
        List<Video> videoList = videoMapper.selectByExample(videoExample);
        // 查询用户表信息
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(Long.valueOf(userParam.getUser_id()));
        List<User> users = userMapper.selectByExample(userExample);
        User user = users.get(0);
        for (Video video : videoList) {
            UserResult userResult = new UserResult();
            userResult.setName(user.getName());
            userResult.setId(user.getId());
            userResult.setFollowCount(user.getFollowCount());
            userResult.setFollowerCount(user.getFollowerCount());
            // 查询视频表信息
            VideoResult videoResult = new VideoResult();
            videoResult.setId(video.getId());
            videoResult.setAuthor(userResult);
            videoResult.setTitle(video.getTitle());
            videoResult.setCoverUrl(video.getCoverUrl());
            videoResult.setPlayUrl(video.getPlayUrl());
            videoResult.setCommentCount(video.getCommentCount());
            videoResult.setFavoriteCount(video.getFavoriteCount());
            // 查询用户视频表信息
            UserVideoExample example = new UserVideoExample();
            example.createCriteria().andUserIdEqualTo((Long) userId).andVideoIdEqualTo(video.getAuthorId());
            List<UserVideo> userVideos = userVideoMapper.selectByExample(example);
            videoResult.setFavorite(userVideos != null);
            // 查询用户关注表信息
            FollowExample followExample = new FollowExample();
            followExample.createCriteria().andUserIdEqualTo((Long) userId).andFollowIdEqualTo(video.getAuthorId());
            List<Follow> follows = followMapper.selectByExample(followExample);
            videoResult.setFavorite(follows != null);
            videoResults.add(videoResult);
        }
        return null;
    }

    private BufferedImage ExecuteFrame(File videoFile) {
        try {
            FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(videoFile);
            grabber.start();
            grabber.setFrameNumber(1);
            Java2DFrameConverter converter = new Java2DFrameConverter();
            BufferedImage image = converter.convert(grabber.grab());
            converter.close();
            grabber.stop();
            return image;
        } catch (Exception e) {
            LOGGER.info("{}, ExecuteFrame ERROR", videoFile.getName());
            e.printStackTrace();
            return null;
        }
    }
}
