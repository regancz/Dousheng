package com.charles.dousheng.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Long nextTime;
    /**
     * 状态码，0-成功，其他值-失败
     */
    private long statusCode;
    /**
     * 返回状态描述
     */
    private String statusMsg;
    /**
     * 视频列表
     */
    private VideoResult[] videoList;
}
