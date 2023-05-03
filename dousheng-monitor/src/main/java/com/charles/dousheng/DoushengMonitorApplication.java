package com.charles.dousheng;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author charles
 * @date 5/3/2023 11:25 AM
 */
@EnableDiscoveryClient
@EnableAdminServer
@SpringBootApplication
public class DoushengMonitorApplication {
    public static void main(String[] args) {
        SpringApplication.run(DoushengMonitorApplication.class, args);
    }
}
