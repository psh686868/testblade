package com.copyblade.ioc.annotation;

/**
 *
 * 注入相关
 */
public @interface Inject {
    String value() default "";
}
