package com.charles.dousheng.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author charles
 * @date 5/1/2023 10:16 PM
 */
@Setter
@Getter
public class RegisterParam {
    /**
     * 注册用户名，最长32个字符
     */
    String username;
    /**
     * 密码，最长32个字符
     */
    String password;
}
