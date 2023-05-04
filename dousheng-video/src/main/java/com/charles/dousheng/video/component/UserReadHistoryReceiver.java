package com.charles.dousheng.video.component;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 点赞消息的处理者
 *
 * @author charles
 * @date 5/4/2023 1:11 PM
 */
@Component
@RocketMQMessageListener(topic = "springboot-rocketmq", selectorExpression = "tag1", consumerGroup = "boot-consumer")
public class UserReadHistoryReceiver implements RocketMQListener<String> {
    private static Logger LOGGER = LoggerFactory.getLogger(UserReadHistoryReceiver.class);

    @Override
    public void onMessage(String message) {

    }
}
