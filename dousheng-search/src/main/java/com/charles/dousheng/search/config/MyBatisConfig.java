package com.charles.dousheng.search.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis相关配置
 *
 * @author charles
 * @date 5/4/2023 7:12 PM
 */
@Configuration
@MapperScan({"com.charles.dousheng.mbg.mapper","com.charles.dousheng.search.dao"})
public class MyBatisConfig {
}
