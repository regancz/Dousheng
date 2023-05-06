package com.charles.dousheng.video.component;

import com.charles.dousheng.video.service.VideoService;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author charles
 * @date 5/6/2023 2:44 PM
 */
@Component
public class FeedJobHandler {
    private static Logger LOGGER = LoggerFactory.getLogger(FeedJobHandler.class);

    @Autowired
    private VideoService videoService;

    /**
     * 1、简单任务示例（Bean模式）
     */
    @XxlJob("feedJobHandler")
    public void feedJobHandler() throws Exception {
        XxlJobHelper.log("XXL-JOB, Hello World.");

        for (int i = 0; i < 5; i++) {
            XxlJobHelper.log("beat at:" + i);
            TimeUnit.SECONDS.sleep(2);
        }
        // default success
//        videoService.feed();
    }
}
