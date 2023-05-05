package com.charles.dousheng.video.component;

import com.charles.dousheng.common.service.RedisService;
import com.charles.dousheng.video.dto.UserReadHistoryDto;
import com.charles.dousheng.video.dto.VideoResult;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 点赞消息的处理者
 *
 * @author charles
 * @date 5/4/2023 1:11 PM
 */
@Component
@RocketMQMessageListener(topic = "dousheng-video-read-history", selectorExpression = "tag1", consumerGroup = "dousheng-video-read-history")
public class UserReadHistoryReceiver implements RocketMQListener<UserReadHistoryDto> {
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
    public void onMessage(UserReadHistoryDto userReadHistoryDto) {
        String preKey = REDIS_DATABASE + ":" + REDIS_KEY_READ_HISTORY + ":" + userReadHistoryDto.getUserId();
        for (VideoResult videoResult : userReadHistoryDto.getVideoResultList()) {
            String key = preKey + ":" + videoResult.getId();
            redisService.lPush(key, videoResult, REDIS_EXPIRE);
        }
        LOGGER.info("process userReadHistory:{}", userReadHistoryDto.getUserId());
    }
}
