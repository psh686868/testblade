package com.copyblade.ioc.bean;

/**
 * ioc和bean进行信息交互
 * Date: 2017/12/13
 */
public class BeanDefine {
    //首先注入时要有对象
    private Object bean;
    //这个注入对象的class描述
    private Class<?> type;
    //是否是单列模式
    private boolean isSingle;

    public BeanDefine(Object bean, Class<?> type, boolean isSingle) {
        this.bean = bean;
        this.type = type;
        this.isSingle = isSingle;
    }

    public BeanDefine(Object bean, Class<?> type) {
        this.bean = bean;
        this.type = type;
        this.isSingle = true;
    }

    public BeanDefine(Object bean) {
        this(bean,bean.getClass());
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public boolean isSingle() {
        return isSingle;
    }

    public void setSingle(boolean single) {
        isSingle = single;
    }
}
