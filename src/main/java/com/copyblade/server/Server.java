package com.copyblade.server;

import com.copyblade.Blade;

/**
 * 服务器相关的接口
 */
public interface Server {

    /**
     * 服务的启动 blade是全局变量所以需要传，很坑啊 args 是启动的参数
     * @param blade
     * @param args
     * @throws Exception
     */
    void start (Blade blade , String[] args) throws Exception;

    /**
     *  服务器的关闭
     */
    void stop ();

    /***
     * 目的是等所有的任务以便 服务器关闭时 等待所有的任务关闭
     */
    void join ();

    /***
     * 等待关闭所有的任务
     */
    void stopAndWrite ();
}
