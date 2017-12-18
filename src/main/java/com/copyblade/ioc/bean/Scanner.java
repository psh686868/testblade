package com.copyblade.ioc.bean;


import lombok.Builder;
import lombok.Data;

import java.lang.annotation.Annotation;

/**
 * Ioc 扫描包
 * Date: 2017/12/14
 */
@Data
@Builder
public class Scanner {
    //包的名字
    private String pageName;
    //是否递归
    private boolean recursive;

    //父类
    private Class<?> parent;

    //注解的支持
    private Class<? extends Annotation> annotation;
}
