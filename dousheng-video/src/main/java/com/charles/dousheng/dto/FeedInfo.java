package com.charles.dousheng.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author charles
 * @date 4/30/2023 6:08 PM
 */
@Getter
@Setter
public class FeedInfo {
    /**
     * 本次返回的视频中，发布最早的时间，作为下次请求时的latest_time
     */
    @ApiModelProperty("视频中发布最早的时间")
    private Long nextTime;
    /**
     * 视频列表
     */
    @ApiModelProperty("视频列表")
    private List<VideoResult> videoList;
}
