package com.charles.dousheng.component;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
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
    @Override
    public void onMessage(String message) {

    }
}
