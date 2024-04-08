package com.ruoyi.common.utils;

import com.ruoyi.common.exception.base.BaseException;

/**
 * @author lizhiwei
 * @date 2024/4/5 19:43
 * 注释：
 */
public class ThrowUtils {

    /**
     * 条件成立则抛异常
     *
     * @param condition
     * @param runtimeException
     */
    public static void throwIf(boolean condition, RuntimeException runtimeException) {
        if (condition) {
            throw runtimeException;
        }
    }

    /**
     * 条件成立则抛异常
     *
     * @param condition
     * @param message
     */
    public static void throwIf(boolean condition, String message) {
        throwIf(condition, new BaseException(message));
    }
}
