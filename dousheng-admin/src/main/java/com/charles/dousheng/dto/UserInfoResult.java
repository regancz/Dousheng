package com.charles.dousheng.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author charles
 * @date 5/1/2023 11:19 PM
 */
@Setter
@Getter
public class UserInfoResult {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "关注人数")
    private Integer followCount;

    @ApiModelProperty(value = "粉丝数")
    private Integer followerCount;

    /**
     * true-已关注，false-未关注
     */
    @ApiModelProperty(value = "是否关注")
    private boolean isFollow;
}
