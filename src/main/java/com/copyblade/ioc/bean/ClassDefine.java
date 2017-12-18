package com.copyblade.ioc.bean;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * Date: 2017/12/13
 */
public class ClassDefine {
    //clazz 容器
    public static final ConcurrentHashMap<Class<?>, ClassDefine> poll = new ConcurrentHashMap<>();

    //类的描述符
    private final Class<?> clazz;

    private ClassDefine(Class<?> clazz) {
        this.clazz = clazz;
    }

    //通过clazz 创建一个clazzDefine,确保只有一个类的描述符
    //http://javarevisited.blogspot.com/2013/02/concurrenthashmap-in-java-example-tutorial-working.html为什么使用 putifAbsent
    public static ClassDefine create (Class<?> type) {
        Objects.nonNull(type);
        ClassDefine classDefine = poll.get(type);
        if (classDefine == null) {
            classDefine = new ClassDefine(type);
            ClassDefine old = poll.putIfAbsent(type, classDefine);//不能直接有put
            if (old != null) {
                classDefine = old;
            }
            return classDefine;
        }
        return classDefine;
    }




    //获取这个 对象的描述 clazz

    public <T>Class<T> getType () {
        return (Class<T>) clazz;
    }

    //获取这个对象的名字

    public String getName () {
        return clazz.getName();
    }

    //获取这个对象的简单描述
    public String getSimpleName () {
        return clazz.getSimpleName();
    }

    //获取父类的calssDefine
    public ClassDefine getSuperKlass () {
        Class<?> superclass = clazz.getSuperclass();
        return superclass == null ? null : ClassDefine.create(superclass);
    }

    //getInterfaces需要琢磨一些
    // public List<ClassDefine> getInterfaces()

    //获取这个类的注解集合

    public Annotation[] getAnnotations () {
        Annotation[] annotations = clazz.getAnnotations();
        return annotations;
    }

    //根据注解class获取指定注解
    public <A extends Annotation> A  getAnnotation (Class<A> annotationClass) {
        A annotation = clazz.getAnnotation(annotationClass);
        return annotation;
    }

    //如果类型的注释出现在该元素上返回true 否则返回lese
    //Returns true if an annotation for the specified type is present on this element, else false.
    //判断这个注释是否在该类上

    public boolean isAnnotationPresent (Class<? extends Annotation> annotationClass) {
        boolean isAnnotationPresent = clazz.isAnnotationPresent(annotationClass);
        return isAnnotationPresent;
    }


    //获取这个类的所有的属性
    public Field[] getDeclaredFields () {
        Field[] declaredFields = clazz.getDeclaredFields();
        return declaredFields;
    }

    //判断类的修饰符
    public int getModifiers () {
        int modifiers = clazz.getModifiers();
        return modifiers;
    }

    public boolean isInterface () {
        return Modifier.isInterface (getModifiers());
    }

    public boolean isAbstract () {
        return Modifier.isAbstract (getModifiers());
    }

    public boolean isStatic () {
        return Modifier.isStatic (getModifiers());
    }
    public boolean isPrivate () {
        return Modifier.isPrivate (getModifiers());
    }

    public boolean isProtected () {
        return Modifier.isProtected (getModifiers());
    }

    public boolean isPublic () {
        return Modifier.isPublic (getModifiers());
    }



}
