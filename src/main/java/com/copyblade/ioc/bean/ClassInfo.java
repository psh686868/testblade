package com.copyblade.ioc.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 类的一些信息
 */
@Data
@EqualsAndHashCode
public class ClassInfo {
    private String className;
    private Class<?> clazz;

    public ClassInfo(String className, Class<?> clazz) {
        this.clazz = clazz;
        this.className = className;
    }

    public ClassInfo(String className) {
        this.className = className;
    }

    public ClassInfo(Class<?> className) {
        this(className.getName(),className);
    }

    public Object newInstance () {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
           throw new RuntimeException(e);
        }
    }

}
