package com.charles.dousheng.video.task;

import com.charles.dousheng.mbg.model.Comment;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * @author zhengyangxin
 * @date 2023/5/24
 */

public abstract class CommentValidationTask extends RecursiveTask<Boolean> {
    protected final Comment comment;
    protected boolean isValid;

    public CommentValidationTask(Comment comment) {
        this.comment = comment;
    }

    public boolean isValid() {
        return isValid;
    }

    @Override
    protected Boolean compute() {
        return doValidation();
    }

    protected abstract boolean doValidation();
}
