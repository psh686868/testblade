package com.copyblade.ioc;

import com.copyblade.ioc.bean.BeanDefine;

import java.util.List;
import java.util.Set;

/**
 * ioc 容器
 */
public interface Ioc {

    /**
     * Add bean to ioc container
     *
     * @param bean  instance
     */
    void addBean (Object bean);


    void addBean (String name , Object bean);

    /**
     * Create bean by type, and register to ioc container
     *
     * @param type bean class type
     * @param <T>  class Type
     * @return return no instance constructor
     */

    <T>T addBean (Class<T> type) ;

    /**
     * Set bean, e.g aop proxy
     *
     * @param type      bean class type
     * @param proxyBean bean instance by proxy
     */
    void setBean (Class<?> type, Object proxyBean);

    Object getBean(String name);

    <T>T getBean (Class<T> type);

    /**
     * Get ioc container bean defines
     *
     * @return ioc container bean defines
     */
    List<BeanDefine> getBeanDefines();

    /**
     * Get ioc bean names
     *
     * @return return bean name set
     */
    Set<String> getBeanNames();

    /**
     * Remove bean by class type
     *
     * @param type bean class type
     */
    void remove(Class<?> type);

    /**
     * Remove bean by name
     *
     * @param beanName bean name
     */
    void remove(String beanName);

    /**
     * Clean ioc container
     */
    void clearAll();
}
