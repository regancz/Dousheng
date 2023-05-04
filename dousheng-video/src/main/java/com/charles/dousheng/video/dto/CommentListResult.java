package com.charles.dousheng.video.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author charles
 * @date 5/2/2023 4:11 PM
 */
@Getter
@Setter
public class CommentListResult {
    /**
     * 评论列表
     */
    private List<CommentActionResult> commentActionResultList;
}
