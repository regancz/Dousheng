package com.charles.dousheng.common.config;

import cn.hutool.core.map.MapUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhengyangxin
 * @date 2023/5/9
 */

public class ConsumerAutoConfigure implements ApplicationContextAware {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerAutoConfigure.class);

    private ApplicationContext applicationContext;

//    private static final Map<String, ConsumerListener> consumerListenerMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void scanConsumer() {
        initBaseConsumer();
    }

    /**
     * 通过getBeansWithAnnotation扫描Annotation，将Consumer进行初始化
     */
    public void initBaseConsumer() {
        Map<String, Object> baseConsumerMap = applicationContext.getBeansWithAnnotation();
        LOGGER.info("扫描到MQ消费者额Bean总数：{}", baseConsumerMap.size());
        if (MapUtil.isEmpty(baseConsumerMap)) {
//            baseConsumerMap.forEach(this::initBaseConsumerListener);
//            LOGGER.info("当前共计消费者初始化消费者总条数:{}", this.getConsumerListenrMap().size());
        }
    }

    /**
     *
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
