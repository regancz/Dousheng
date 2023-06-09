package com.charles.dousheng.video.domain;

import lombok.Getter;

/**
 * @author charles
 * @date 5/4/2023 12:58 PM
 */
@Getter
public enum QueueEnum {
    /**
     * 消息通知队列
     */
    QUEUE_ORDER_CANCEL("dousheng.order.direct", "dousheng.order.cancel", "dousheng.order.cancel"),
    /**
     * 消息通知ttl队列
     */
    QUEUE_TTL_ORDER_CANCEL("dousheng.order.direct.ttl", "dousheng.order.cancel.ttl", "dousheng.order.cancel.ttl");

    /**
     * 交换名称
     */
    private String exchange;
    /**
     * 队列名称
     */
    private String name;
    /**
     * 路由键
     */
    private String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }
}
