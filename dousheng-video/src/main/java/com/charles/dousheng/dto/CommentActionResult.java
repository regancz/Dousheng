package com.charles.dousheng.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author charles
 * @date 5/2/2023 4:05 PM
 */
@Getter
@Setter
public class CommentActionResult {
    /**
     * 评论内容
     */
    private String content;
    /**
     * 评论发布日期，格式 mm-dd
     */
    private String createDate;
    /**
     * 评论id
     */
    private Long id;
    /**
     * 评论用户信息
     */
    private UserResult userResult;
}
