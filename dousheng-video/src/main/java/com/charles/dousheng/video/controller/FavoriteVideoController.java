package com.charles.dousheng.video.controller;

import com.charles.dousheng.common.api.CommonResult;
import com.charles.dousheng.common.api.ResultCode;
import com.charles.dousheng.video.dto.FavoriteActionParam;
import com.charles.dousheng.video.dto.UserParam;
import com.charles.dousheng.video.dto.VideoResult;
import com.charles.dousheng.video.service.FavoriteVideoService;
import com.charles.dousheng.video.service.UserReadHistoryService;
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
 * @date 5/1/2023 10:07 PM
 */
@Controller
@Api(tags = "FavoriteVideoController")
@RequestMapping("/douyin/favorite")
public class FavoriteVideoController {
    @Autowired
    private FavoriteVideoService favoriteVideoService;

    @Autowired
    private UserReadHistoryService userReadHistoryService;

    @ApiOperation("用户的视频发布列表，直接列出用户所有投稿过的视频")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<VideoResult>> favoriteList(@RequestBody UserParam userParam) {
        List<VideoResult> videoResults = favoriteVideoService.favoriteList(userParam);
        return CommonResult.success(videoResults);
    }

    @ApiOperation("登录用户对视频的点赞和取消点赞操作")
    @RequestMapping(value = "/action", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult favoriteAction(@RequestBody FavoriteActionParam favoriteActionParam) {
        int action = favoriteVideoService.favoriteAction(favoriteActionParam);

        return new CommonResult(action, ResultCode.SUCCESS.getMessage());
    }

}
