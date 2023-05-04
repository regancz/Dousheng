package com.charles.dousheng.video.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author charles
 * @date 4/30/2023 5:51 PM
 */
@Getter
@Setter
public class FeedParam {
    @ApiModelProperty("用户登录状态下设置")
    private String token;
    @ApiModelProperty("可选参数，限制返回视频的最新投稿时间戳，精确到秒，不填表示当前时间")
    private String latest_time;
}
