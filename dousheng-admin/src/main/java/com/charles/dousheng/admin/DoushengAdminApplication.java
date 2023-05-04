package com.charles.dousheng.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author charles
 * @date 5/4/2023 11:12 PM
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class DoushengAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(DoushengAdminApplication.class, args);
    }
}