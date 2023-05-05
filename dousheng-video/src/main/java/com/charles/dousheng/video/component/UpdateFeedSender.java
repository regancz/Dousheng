package com.charles.dousheng.video.component;

import com.charles.dousheng.video.dto.UserReadHistoryDto;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author charles
 * @date 5/5/2023 3:05 PM
 */
@Component
public class UpdateFeedSender {
    private static Logger LOGGER = LoggerFactory.getLogger(UpdateFeedSender.class);

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 发送异步消息
     *
     * @param topic   topic
     * @param userId 消息体
     */
    public void asyncSendMessage(String topic, Long userId) {
        rocketMQTemplate.asyncSend(topic, userId, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                LOGGER.info("异步消息发送成功，userId = {}, SendStatus = {}", userId, sendResult.getSendStatus());
            }

            @Override
            public void onException(Throwable e) {
                LOGGER.info("异步消息发送异常，exception = {}", e.getMessage());
            }
        });
    }
}
