package com.charles.dousheng.video.component;

import com.charles.dousheng.video.domain.QueueEnum;
import com.charles.dousheng.video.dto.UserReadHistoryDto;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.core.MessagePostProcessor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author charles
 * @date 5/5/2023 11:07 AM
 */
@Component
public class UserReadHistorySender {
    private static Logger LOGGER = LoggerFactory.getLogger(UserReadHistorySender.class);

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 发送异步消息
     *
     * @param topic   topic
     * @param userReadHistoryDto 消息体
     */
    public void asyncSendMessage(String topic, UserReadHistoryDto userReadHistoryDto) {
        rocketMQTemplate.asyncSend(topic, userReadHistoryDto, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                LOGGER.info("异步消息发送成功，message = {}, SendStatus = {}", userReadHistoryDto, sendResult.getSendStatus());
            }

            @Override
            public void onException(Throwable e) {
                LOGGER.info("异步消息发送异常，exception = {}", e.getMessage());
            }
        });
    }

}
