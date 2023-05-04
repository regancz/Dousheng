package com.charles.dousheng.video.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author charles
 * @date 4/30/2023 5:59 PM
 */
@Getter
@Setter
public class UserResult {
    /**
     * 关注总数
     */
    private long followCount;
    /**
     * 粉丝总数
     */
    private long followerCount;
    /**
     * 用户id
     */
    private long id;
    /**
     * true-已关注，false-未关注
     */
    private boolean isFollow;
    /**
     * 用户名称
     */
    private String name;
}
