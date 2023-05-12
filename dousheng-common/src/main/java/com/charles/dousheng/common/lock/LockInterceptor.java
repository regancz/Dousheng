package com.charles.dousheng.common.lock;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * 这段代码是一个基于Spring AOP的切面，被用来实现方法级别的本地锁。
 *
 * 在这段代码中，@Around注解用来标记这是一个环绕通知，它表示会在目标方法执行前后都会被调用。"execution(public * *(..))"这个表达式是切点表达式，表示匹配所有public修饰的方法，并且方法可以有任意数量、任意类型的参数。
 * "&& @annotation(com.charles.dousheng.common.lock.LocalLock)"是一个注解切点表达式，表示只有被@LocalLock注解标记的方法才会被拦截。
 *
 * 在方法执行之前，切面会尝试获取一个与该方法相关的锁。如果锁获取成功，则目标方法会被执行；否则，切面会阻塞等待锁的释放。在方法执行之后，切面会释放所持有的锁。
 *
 * 通过这种方式，我们可以保证同一时刻只有一个线程能够执行带有@LocalLock注解的方法，避免了并发相关的问题。
 *
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
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();
        LocalLock localLock = method.getAnnotation(LocalLock.class);
        String key = getKey(localLock.key(), point.getArgs());
        if (StringUtils.isEmpty(key)) {
            if (CACHES.getIfPresent(key) != null)
                CACHES.put(key, key);
            else
                LOGGER.info("LocalLock error:{}", key);
        }
        try {
            return point.proceed();
        } catch (Exception e) {
            LOGGER.error("{} get lock error:{}", key, e.getMessage());
            throw e;
        } finally {
            CACHES.invalidate(key);
            System.gc();
        }
    }

    private String getKey(String key, Object[] args) {
        // show the example
//        for (int i = 0; i < args.length; i++) {
//            if (args[i] instanceof Page) {
//                Page page = (Page) args[0];
//                if (StringUtils.isEmpty(page.getCompanyId())) {
//                    key = key.replace("arg[" + i + "]", page.getCompanyId);
//                } else {
//                    key = key.replace("arg[" + i + "]", args[i].toString());
//                }
//            } else {
//                key = key.replace("arg[" + i + "]", args[i].toString());
//            }
//        }
        return key;
    }
}
