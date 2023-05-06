package com.charles.dousheng.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author charles
 * @date 5/5/2023 11:04 PM
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.charles.dousheng.mbg.mapper","com.charles.dousheng.mbg.dao"})
public class MyBatisConfig {
}
