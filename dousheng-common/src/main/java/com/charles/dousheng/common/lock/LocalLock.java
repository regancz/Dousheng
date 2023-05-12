package com.charles.dousheng.common.lock;

import java.lang.annotation.*;

/**
 * 接口防刷，
 *
 * @author zhengyangxin
 * @date 2023/5/9
 */
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface LocalLock {
    String key() default "";
}
