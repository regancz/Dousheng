package com.charles.dousheng.video;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author charles
 * @date 5/5/2023 10:14 AM
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class DoushengVideoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DoushengVideoApplication.class, args);
    }
}
