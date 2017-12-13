package com.copyblade.event;

import com.copyblade.Blade;

/**
 * 定义事件
 * Create by psh
 * Date: 2017/12/11
 */
public class Event {
    //事件有类型
    public EventType eventType;

    // 附属于Application
    public Blade blade;

    public Event(EventType eventType) {
        this.eventType = eventType;
    }

    public Event(EventType eventType, Blade blade) {
        this.eventType = eventType;
        this.blade = blade;
    }
}
