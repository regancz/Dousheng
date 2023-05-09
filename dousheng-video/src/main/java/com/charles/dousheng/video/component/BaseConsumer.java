package com.charles.dousheng.video.component;

import com.charles.dousheng.video.service.impl.MinioServiceImpl;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhengyangxin
 * @date 2023/5/8
 */
@Component
public abstract class BaseConsumer implements MessageListenerConcurrently {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseConsumer.class);

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        return null;
    }
}
