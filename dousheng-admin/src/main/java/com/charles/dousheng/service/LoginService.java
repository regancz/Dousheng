package com.charles.dousheng.service;

import com.charles.dousheng.dto.RegisterParam;
import com.charles.dousheng.dto.RegisterResult;
import com.charles.dousheng.dto.UserInfoParam;
import com.charles.dousheng.dto.UserInfoResult;

/**
 * @author charles
 * @date 5/1/2023 10:03 PM
 */
public interface LoginService {
    RegisterResult register(RegisterParam registerParam);

    RegisterResult login(RegisterParam registerParam);

    UserInfoResult userInfo(UserInfoParam userInfoParam);
}
