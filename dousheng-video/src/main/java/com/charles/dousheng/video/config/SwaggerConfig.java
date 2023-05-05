package com.charles.dousheng.video.config;

import com.charles.dousheng.common.config.BaseSwaggerConfig;
import com.charles.dousheng.common.domain.SwaggerProperties;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author charles
 * @date 4/30/2023 6:56 PM
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.charles.dousheng.video.controller")
                .title("dousheng视频系统")
                .description("dousheng视频相关接口文档")
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
