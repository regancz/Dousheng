package com.charles.dousheng.common.id;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * @author charles
 * @date 5/1/2023 11:06 PM
 */
public class IdProcessor {
    private static Snowflake snowflake = IdUtil.getSnowflake();

    /**
     * 生成long 类型的ID
     * @return
     */
    public static Long getId() {
        return snowflake.nextId();
    }

    /**
     * 生成String 类型的ID
     * @return
     */
    public static String getIdStr() {
        return snowflake.nextIdStr();
    }
}
