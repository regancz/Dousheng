package com.charles.dousheng.controller;

import com.charles.dousheng.api.CommonResult;
import com.charles.dousheng.api.ResultCode;
import com.charles.dousheng.dto.*;
import com.charles.dousheng.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author charles
 * @date 4/30/2023 4:47 PM
 */
@Controller
@Api(tags = "VideoController")
@RequestMapping("/douyin")
public class VideoController {
    @Autowired
    VideoService videoService;

    @ApiOperation("按投稿时间倒序的视频列表，视频数由服务端控制，单次最多30个")
    @RequestMapping(value = "/feed", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<FeedResult> feed(@RequestBody FeedParam feedParam) {
        FeedInfo feedInfo = videoService.feed(feedParam);
        FeedResult feedResult = new FeedResult(feedInfo.getNextTime(), feedInfo.getVideoList());
        return CommonResult.success(feedResult);
    }

    @ApiOperation("登录用户选择视频上传")
    @RequestMapping(value = "/publish/action", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult publishVideo(PublishVideoParam publishVideoParam) {
        int count = 0;
        try {
            count = videoService.publishVideo(publishVideoParam);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (count <= 0)
            return CommonResult.failed();
        return CommonResult.success();
    }

    @ApiOperation("用户的视频发布列表，直接列出用户所有投稿过的视频")
    @RequestMapping(value = "/publish/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<VideoResult>> publishedVideoList(@RequestBody UserParam userParam) {
        List<VideoResult> videoResults = videoService.publishedVideoList(userParam);
        return CommonResult.success(videoResults);
    }
}
