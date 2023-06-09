package com.charles.dousheng.video.controller;

import com.charles.dousheng.common.api.CommonResult;
import com.charles.dousheng.common.api.ResultCode;
import com.charles.dousheng.common.lock.LocalLock;
import com.charles.dousheng.video.dto.RelationFollowListParam;
import com.charles.dousheng.video.service.RelationUserService;
import com.charles.dousheng.video.dto.RelationActionParam;
import com.charles.dousheng.video.dto.RelationFollowerListParam;
import com.charles.dousheng.video.dto.UserResult;
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
 * @date 5/1/2023 10:08 PM
 */
@Controller
@Api(tags = "RelationUserController")
@RequestMapping("/douyin/relation")
public class RelationUserController {
    @Autowired
    private RelationUserService relationUserService;

    @ApiOperation("关注列表")
    @RequestMapping(value = "/follow/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UserResult>> relationFollowList(@RequestBody RelationFollowListParam relationFollowListParam) {
        List<UserResult> userResults = relationUserService.relationFollowList(relationFollowListParam);
        return CommonResult.success(userResults);
    }

    @ApiOperation("粉丝列表")
    @RequestMapping(value = "/follower/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UserResult>> relationFollowerList(@RequestBody RelationFollowerListParam relationFollowerListParam) {
        List<UserResult> userResults = relationUserService.relationFollowerList(relationFollowerListParam);
        return CommonResult.success(userResults);
    }

    @ApiOperation("登录用户对视频的点赞和取消点赞操作")
    @LocalLock
    @RequestMapping(value = "/action", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult relationAction(@RequestBody RelationActionParam relationActionParam) {
        int action = relationUserService.relationAction(relationActionParam);
        return new CommonResult(action, ResultCode.SUCCESS.getMessage());
    }
}
