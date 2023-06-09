package com.charles.dousheng.video.controller;

import com.charles.dousheng.common.api.CommonResult;
import com.charles.dousheng.common.lock.LocalLock;
import com.charles.dousheng.video.dto.CommentActionParam;
import com.charles.dousheng.video.dto.CommentActionResult;
import com.charles.dousheng.video.dto.CommentListParam;
import com.charles.dousheng.video.dto.CommentListResult;
import com.charles.dousheng.video.service.CommentVideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author charles
 * @date 5/1/2023 10:08 PM
 */
@Controller
@Api(tags = "CommentVideoController")
@RequestMapping("/douyin/comment")
public class CommentVideoController {
    @Autowired
    private CommentVideoService commentVideoService;

    @ApiOperation("查看视频的所有评论，按发布时间倒序")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommentListResult> commentList(@RequestBody CommentListParam commentListParam) {
        CommentListResult commentListResult = commentVideoService.commentList(commentListParam);
        return CommonResult.success(commentListResult);
    }

    @ApiOperation("登录用户对视频进行评论")
    @LocalLock
    @RequestMapping(value = "/action", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommentActionResult> commentAction(@RequestBody CommentActionParam commentActionParam) {
        CommentActionResult commentActionResult = commentVideoService.commentAction(commentActionParam);
        return CommonResult.success(commentActionResult);
    }
}
