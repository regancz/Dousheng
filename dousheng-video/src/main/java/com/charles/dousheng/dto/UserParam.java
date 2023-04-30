package com.charles.dousheng.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author charles
 * @date 4/30/2023 5:49 PM
 */
@Getter
@Setter
public class UserParam {
    @ApiModelProperty("用户鉴权token")
    private String token;
    @ApiModelProperty("用户id")
    private String user_id;
}
