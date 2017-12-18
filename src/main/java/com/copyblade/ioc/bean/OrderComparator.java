package com.copyblade.ioc.bean;

import com.copyblade.ioc.annotation.Order;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Date: 2017/12/14
 */
public class OrderComparator<T> implements Serializable , Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        Order annotation1 = o1.getClass().getAnnotation(Order.class);
        Order annotation2 = o2.getClass().getAnnotation(Order.class);
        if (annotation1 != null && annotation2!=null) {
            Integer.valueOf(annotation1.value()).compareTo(Integer.valueOf(annotation2.value()));
        }
        return 0;
    }
}
