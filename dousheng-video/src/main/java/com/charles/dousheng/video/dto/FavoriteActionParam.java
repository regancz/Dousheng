package com.charles.dousheng.video.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author charles
 * @date 5/2/2023 3:09 PM
 */
@Getter
@Setter
public class FavoriteActionParam {
    /**
     * 1-点赞，2-取消点赞
     */
    @ApiModelProperty("是否点赞")
    private String actionType;
    /**
     * 用户鉴权token
     */
    @ApiModelProperty("用户鉴权token")
    private String token;
    /**
     * 视频id
     */
    @ApiModelProperty("视频id")
    private Long videoid;
}
