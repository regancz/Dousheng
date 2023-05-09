package com.charles.dousheng.common.lock;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author zhengyangxin
 * @date 2023/5/9
 */
@Component
@Aspect
public class LockInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(LockInterceptor.class);

    private static final Cache<String, Object> CACHES = CacheBuilder.newBuilder().maximumSize(500).expireAfterWrite(5, TimeUnit.SECONDS).build();

    @Around("execution(public * *(..)) && @annotation(com.charles.dousheng.common.lock.LocalLock)")
    public Object connection(ProceedingJoinPoint point) throws Throwable {

    }
}
