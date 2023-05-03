package com.charles.dousheng.service.impl;

import com.charles.dousheng.crypto.JwtProcessor;
import com.charles.dousheng.dto.*;
import com.charles.dousheng.id.IdProcessor;
import com.charles.dousheng.mapper.CommentMapper;
import com.charles.dousheng.mapper.FollowMapper;
import com.charles.dousheng.mapper.UserMapper;
import com.charles.dousheng.model.*;
import com.charles.dousheng.service.CommentVideoService;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author charles
 * @date 5/1/2023 10:09 PM
 */
@Service
public class CommentVideoServiceImpl implements CommentVideoService {
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private FollowMapper followMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public CommentListResult commentList(CommentListParam commentListParam) {
        // 解析jwt
        Object userId = JwtProcessor.parseJwt(commentListParam.getToken());
        if (userId == null) {
            return null;
        }
        //
        CommentListResult commentListResult = new CommentListResult();
        List<CommentActionResult> commentActionResultList = new ArrayList<>();
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andVideoIdEqualTo(commentListParam.getVideoid());
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        for (Comment comment : comments) {
            CommentActionResult commentActionResult = new CommentActionResult();
            commentActionResult.setId(IdProcessor.getId());
            commentActionResult.setContent(comment.getContent());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
            commentActionResult.setCreateDate(simpleDateFormat.format(comment.getCreateTime()));
            // 查询用户表信息
            UserExample userExample = new UserExample();
            userExample.createCriteria().andIdEqualTo(comment.getUserId());
            List<User> users = userMapper.selectByExample(userExample);
            User user = users.get(0);
            UserResult userResult = new UserResult();
            userResult.setName(user.getName());
            userResult.setId(user.getId());
            userResult.setFollowCount(user.getFollowCount());
            userResult.setFollowerCount(user.getFollowerCount());
            // 查询用户关注表信息
            FollowExample followExample = new FollowExample();
            followExample.createCriteria().andUserIdEqualTo((Long) userId).andFollowIdEqualTo(comment.getUserId());
            List<Follow> follows = followMapper.selectByExample(followExample);
            userResult.setFollow(follows != null);
            commentActionResult.setUserResult(userResult);
            commentActionResultList.add(commentActionResult);
        }
        commentListResult.setCommentActionResultList(commentActionResultList);
        return null;
    }

    @Override
    public CommentActionResult commentAction(CommentActionParam commentActionParam) {
        // 解析jwt
        Object userId = JwtProcessor.parseJwt(commentActionParam.getToken());
        if (userId == null) {
            return null;
        }
        if (commentActionParam.getActionType().equals("1")) {
            Comment comment = new Comment();
            comment.setContent(commentActionParam.getCommentText());
            comment.setState(true);
            comment.setVideoId(commentActionParam.getVideoid());
            comment.setUserId((Long) userId);
            commentMapper.insert(comment);
        } else if (commentActionParam.getActionType().equals("0")) {
            Comment comment = new Comment();
            comment.setContent(commentActionParam.getCommentText());
            comment.setState(false);
            comment.setVideoId(commentActionParam.getVideoid());
            comment.setUserId((Long) userId);
            commentMapper.updateByPrimaryKey(comment);
        }
        // 查询用户表信息
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo((Long) userId);
        List<User> users = userMapper.selectByExample(userExample);
        User user = users.get(0);
        UserResult userResult = new UserResult();
        userResult.setName(user.getName());
        userResult.setId(user.getId());
        userResult.setFollowCount(user.getFollowCount());
        userResult.setFollowerCount(user.getFollowerCount());
        userResult.setFollow(false);
        // 生成Result
        CommentActionResult commentActionResult = new CommentActionResult();
        commentActionResult.setUserResult(userResult);
        commentActionResult.setContent(commentActionParam.getCommentText());
        Long id = IdProcessor.getId();
        Date currentDate = new Date();
        commentActionResult.setId(id);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
        commentActionResult.setCreateDate(simpleDateFormat.format(currentDate));
        return commentActionResult;
    }
}
