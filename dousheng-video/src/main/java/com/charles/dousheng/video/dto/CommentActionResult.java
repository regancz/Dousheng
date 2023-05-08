package com.charles.dousheng.video.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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
     * 评论发布日期，格式 MM-dd
     */
    @JsonFormat(pattern = "MM-dd")
    private Date createDate;
    /**
     * 评论id
     */
    private Long id;
    /**
     * 评论用户信息
     */
    private UserResult userResult;
}
