package com.charles.dousheng.exception;

import com.charles.dousheng.api.IErrorCode;

/**
 * 断言处理类，用于抛出各种API异常
 *
 * @author charles
 * @date 4/30/2023 9:32 PM
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
