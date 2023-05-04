package com.charles.dousheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author charles
 * @date 5/4/2023 7:04 PM
 */
@EnableDiscoveryClient
@SpringBootApplication
public class DoushengSearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(DoushengSearchApplication.class, args);
    }
}
