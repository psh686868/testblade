package com.copyblade.ioc.annotation;

/**
 * 凡是标注了 InjectFieldWith 的第三方 Annotation，就被允许进行自定义注入字段
 * 需要品下
 */
public @interface InjectWith {
    Class<? extends Inject> value();
}
