package com.copyblade.event;


import com.copyblade.Blade;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 事件管理器
 * Create by psh
 * Date: 2017/12/11
 */
public class EventManager {
    //每个生命周期的一些事件
    private Map<EventType,List<EventListener>>  listenerMap = null; //事件容器 包含不同类型的事件

    public EventManager() {
        this.listenerMap = Stream.of(EventType.values())
                .collect(Collectors.toMap(v -> v,v -> new LinkedList<EventListener>()));
    }

    public void addEventListener (EventType eventType, EventListener eventListener) {
        listenerMap.get(eventType).add(eventListener);
    }

    //
    public void fireEvent (EventType eventType, Blade blade) {
        listenerMap.get(eventType)
                .stream()
                .forEach(eventListener -> eventListener.tigger(new Event(eventType,blade)));
    }

    public void fireEvent (EventType eventType) {
        fireEvent(eventType,null);
    }
}
