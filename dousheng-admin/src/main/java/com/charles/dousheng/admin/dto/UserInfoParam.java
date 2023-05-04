package com.charles.dousheng.admin.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author charles
 * @date 5/1/2023 11:18 PM
 */
@Setter
@Getter
public class UserInfoParam {
    /**
     * 用户鉴权token
     */
    private String token;
    /**
     * 用户id
     */
    private long userid;
}
