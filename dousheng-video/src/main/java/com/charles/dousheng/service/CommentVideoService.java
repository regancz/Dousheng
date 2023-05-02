package com.charles.dousheng.service;

import com.charles.dousheng.dto.CommentActionParam;
import com.charles.dousheng.dto.CommentActionResult;
import com.charles.dousheng.dto.CommentListParam;
import com.charles.dousheng.dto.CommentListResult;

/**
 * @author charles
 * @date 5/1/2023 10:09 PM
 */
public interface CommentVideoService {
    CommentListResult commentList(CommentListParam commentListParam);

    CommentActionResult commentAction(CommentActionParam commentActionParam);
}
