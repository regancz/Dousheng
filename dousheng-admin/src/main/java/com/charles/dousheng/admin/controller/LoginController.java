package com.charles.dousheng.admin.controller;

import com.charles.dousheng.admin.dto.RegisterResult;
import com.charles.dousheng.admin.dto.UserInfoParam;
import com.charles.dousheng.admin.service.LoginService;
import com.charles.dousheng.common.api.CommonResult;
import com.charles.dousheng.admin.dto.RegisterParam;
import com.charles.dousheng.admin.dto.UserInfoResult;
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
 * @date 5/1/2023 10:01 PM
 */
@Controller
@Api(tags = "LoginController")
@RequestMapping("/douyin/user")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @ApiOperation("新用户注册时提供用户名，密码，昵称即可，用户名需要保证唯一。创建成功后返回用户 id 和权限token")
    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<RegisterResult> register(@RequestBody RegisterParam registerParam) {
        RegisterResult registerResult = loginService.register(registerParam);
        return CommonResult.success(registerResult);
    }

    @ApiOperation("新用户注册时提供用户名，密码，昵称即可，用户名需要保证唯一。创建成功后返回用户 id 和权限token")
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<RegisterResult> login(@RequestBody RegisterParam registerParam) {
        RegisterResult registerResult = loginService.login(registerParam);
        return CommonResult.success(registerResult);
    }

    @ApiOperation("获取用户的 id、昵称，如果实现社交部分的功能，还会返回关注数和粉丝数")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<UserInfoResult> userInfo(@RequestBody UserInfoParam userInfoParam) {
        UserInfoResult userInfoResult = loginService.userInfo(userInfoParam);
        return CommonResult.success(userInfoResult);
    }
}
