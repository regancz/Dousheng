package com.charles.dousheng.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author charles
 * @date 5/2/2023 10:33 PM
 */
@Getter
@Setter
public class RelationActionParam {
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
     * 对方用户id
     */
    @ApiModelProperty("对方用户id")
    private Long toUserid;
}
