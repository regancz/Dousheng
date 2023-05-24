package com.charles.dousheng.video.component;

import com.charles.dousheng.mbg.model.Comment;
import com.charles.dousheng.video.task.CommentContentValidationTask;
import com.charles.dousheng.video.task.CommentPermissionValidationTask;
import com.charles.dousheng.video.task.CommentValidationTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * @author zhengyangxin
 * @date 2023/5/24
 */

public class CommentValidator {
    private static final ForkJoinPool forkJoinPool = new ForkJoinPool();

    public boolean validateOrder(Comment comment) {
        // 创建任务列表
        List<CommentValidationTask> tasks = new ArrayList<>();
        tasks.add(new CommentContentValidationTask(comment));
        tasks.add(new CommentPermissionValidationTask(comment));

        // 执行任务列表
        try {
            forkJoinPool.submit(tasks);
            forkJoinPool.invokeAll(tasks);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }

        // 检查是否有任何错误
        for (CommentValidationTask task : tasks) {
            if (!task.isValid()) {
                return false;
            }
        }
        return true;
    }
}
