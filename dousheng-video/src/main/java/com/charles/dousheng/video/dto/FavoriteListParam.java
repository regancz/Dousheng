package com.charles.dousheng.video.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author charles
 * @date 5/2/2023 3:15 PM
 */
@Getter
@Setter
public class FavoriteListParam {
    @ApiModelProperty("用户鉴权token")
    private String token;
    @ApiModelProperty("用户id")
    private String user_id;
}
