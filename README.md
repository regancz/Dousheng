# Dousheng

## Introduction

针对短视频场景进行的开发工作，其中包含用户登陆、投稿、点赞，评论、Feed等模块，青训营Java版本实现，佛系更新

## Features

- 采用微服务架构，Nacos和Dubbo，分为gateway，monitor，用户和视频模块，支持Docker，k8s部署
- RocketMQ异步生成点赞和评论消息，作为数据源给Feed进行推荐，MinIO存储视频和封面
- XXL-JOB定时推荐视频到Redis和根据视频信息定时生成统计信息，大博主发布视频主动更新推荐列表
- ES实现关键字搜索视频名称、副标题和关键词，支持博主和视频类型的筛选，多种方式排序

## 组织结构

```
dousheng
├── dousheng-common -- 工具类及通用代码模块
├── dousheng-mbg -- MyBatisGenerator生成的数据库操作代码模块
├── dousheng-gateway -- 基于Spring Cloud Gateway的微服务API网关服务
├── dousheng-monitor -- 基于Spring Boot Admin的微服务监控中心
├── dousheng-admin -- 后台管理系统服务
├── dousheng-search -- 基于Elasticsearch的搜索系统服务
├── dousheng-video -- 后台视频系统服务
└── config -- 配置中心存储的配置
```