package com.copyblade.event;

/**
 * 事件的类型
 */
public enum EventType {
    SERVER_STARTING, //服务启动的时候
    SERVER_STARTED, //服务启动结束的时候
    SERVER_STOPPING, //服务停止的过程中
    SERVER_STOPPED,  //服务停止后
    SESSION_CREATED, // session创建的时候
    SESSION_DESTROY, //session 销毁的时候
    SOURCE_CHANGED  //资源改变的时候
}
