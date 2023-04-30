package com.charles.dousheng.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author charles
 * @date 4/30/2023 6:55 PM
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.charles.dousheng.mapper","com.charles.dousheng.dao"})
public class MyBatisConfig {
}
