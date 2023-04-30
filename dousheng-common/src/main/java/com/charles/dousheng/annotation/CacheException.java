package com.charles.dousheng.annotation;

import java.lang.annotation.*;

/**
 * @author charles
 * @date 4/30/2023 9:39 PM
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheException {
}
