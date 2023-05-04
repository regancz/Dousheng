package com.charles.dousheng.video.gateway.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author charles
 * @date 4/30/2023 6:55 PM
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.charles.dousheng.mbg.mapper","com.charles.dousheng.dao"})
public class MyBatisConfig {
}
