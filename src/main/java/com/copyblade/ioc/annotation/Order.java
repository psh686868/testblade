package com.copyblade.ioc.annotation;

/**
 * 排序相关
 */
public @interface Order {
    int value() default Integer.MAX_VALUE;
}
