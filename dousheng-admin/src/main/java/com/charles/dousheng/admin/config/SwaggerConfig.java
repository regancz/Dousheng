package com.charles.dousheng.admin.config;

import com.charles.dousheng.common.config.BaseSwaggerConfig;
import com.charles.dousheng.common.domain.SwaggerProperties;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author charles
 * @date 5/5/2023 11:05 PM
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.charles.dousheng.controller")
                .title("doushengAdmin系统")
                .description("dousheng后台相关接口文档")
                .contactName("charles")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }

    @Bean
    public BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
        return generateBeanPostProcessor();
    }
}
