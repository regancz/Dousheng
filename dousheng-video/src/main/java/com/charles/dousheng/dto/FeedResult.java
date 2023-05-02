package com.charles.dousheng.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author charles
 * @date 4/30/2023 5:59 PM
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeedResult {
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
