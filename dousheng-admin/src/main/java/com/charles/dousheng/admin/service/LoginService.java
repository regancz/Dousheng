package com.charles.dousheng.admin.service;

import com.charles.dousheng.admin.dto.RegisterParam;
import com.charles.dousheng.admin.dto.RegisterResult;
import com.charles.dousheng.admin.dto.UserInfoParam;
import com.charles.dousheng.admin.dto.UserInfoResult;

/**
 * @author charles
 * @date 5/1/2023 10:03 PM
 */
public interface LoginService {
    RegisterResult register(RegisterParam registerParam);

    RegisterResult login(RegisterParam registerParam);

    UserInfoResult userInfo(UserInfoParam userInfoParam);
}
