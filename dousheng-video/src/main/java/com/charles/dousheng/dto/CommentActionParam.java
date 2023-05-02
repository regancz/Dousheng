package com.charles.dousheng.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author charles
 * @date 5/2/2023 4:03 PM
 */
@Getter
@Setter
public class CommentActionParam {
    /**
     * 1-发布评论，2-删除评论
     */
    private String actionType;
    /**
     * 要删除的评论id，在action_type=2的时候使用
     */
    private Long commentid;
    /**
     * 用户填写的评论内容，在action_type=1的时候使用
     */
    private String commentText;
    /**
     * 用户鉴权token
     */
    private String token;
    /**
     * 视频id
     */
    private Long videoid;
}
