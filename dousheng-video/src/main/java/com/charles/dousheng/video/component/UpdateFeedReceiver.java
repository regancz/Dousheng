package com.charles.dousheng.video.component;

import com.charles.dousheng.common.service.RedisService;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author charles
 * @date 5/5/2023 3:14 PM
 */
@Component
@RocketMQMessageListener(topic = "dousheng-video-feed", selectorExpression = "tag1", consumerGroup = "dousheng-video-feed")
public class UpdateFeedReceiver implements RocketMQListener<Long> {
    private static Logger LOGGER = LoggerFactory.getLogger(UserReadHistoryReceiver.class);

    @Autowired
    private RedisService redisService;

    @Value("${redis.database}")
    private String REDIS_DATABASE;

    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;

    @Value("${redis.key.read.history}")
    private String REDIS_KEY_READ_HISTORY;

    @Override
    public void onMessage(Long userId) {
        LOGGER.info("process feed:{}", userId);
    }
}
