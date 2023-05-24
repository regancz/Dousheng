package com.charles.dousheng.video.task;

import com.charles.dousheng.mbg.model.Comment;

/**
 * @author zhengyangxin
 * @date 2023/5/24
 */

public class CommentPermissionValidationTask extends CommentValidationTask{
    public CommentPermissionValidationTask(Comment comment) {
        super(comment);
    }

    @Override
    protected boolean doValidation() {
        return false;
    }
}
