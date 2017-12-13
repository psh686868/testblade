package com.copyblade.event;

/**
 *
 */
@FunctionalInterface
public interface EventListener {
    void tigger (Event event); //触发事件
}
