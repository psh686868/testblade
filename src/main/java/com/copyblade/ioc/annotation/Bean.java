package com.copyblade.ioc.annotation;

/**
 *
 * 将bean加载容器的注解
 *
 */
public @interface Bean {
    String value() default "";
}
