package com.charles.dousheng.video.service;

import com.charles.dousheng.video.dto.CommentActionParam;
import com.charles.dousheng.video.dto.CommentActionResult;
import com.charles.dousheng.video.dto.CommentListParam;
import com.charles.dousheng.video.dto.CommentListResult;

/**
 * @author charles
 * @date 5/1/2023 10:09 PM
 */
public interface CommentVideoService {
    CommentListResult commentList(CommentListParam commentListParam);

    CommentActionResult commentAction(CommentActionParam commentActionParam);
}
