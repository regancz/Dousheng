package com.charles.dousheng.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author charles
 * @date 4/30/2023 5:58 PM
 */
@Getter
@Setter
public class VideoResult {
    /**
     * 视频作者信息
     */
    private UserResult author;
    /**
     * 视频的评论总数
     */
    private long commentCount;
    /**
     * 视频封面地址
     */
    private String coverUrl;
    /**
     * 视频的点赞总数
     */
    private long favoriteCount;
    /**
     * 视频唯一标识
     */
    private long id;
    /**
     * true-已点赞，false-未点赞
     */
    private boolean isFavorite;
    /**
     * 视频播放地址
     */
    private String playUrl;
    /**
     * 视频标题
     */
    private String title;
}
