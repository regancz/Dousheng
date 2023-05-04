package com.charles.dousheng.video.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author charles
 * @date 5/2/2023 4:10 PM
 */
@Getter
@Setter
public class CommentListParam {
    /**
     * 用户鉴权token
     */
    private String token;
    /**
     * 视频id
     */
    private Long videoid;
}
