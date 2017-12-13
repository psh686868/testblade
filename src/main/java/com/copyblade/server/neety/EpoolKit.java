package com.copyblade.server.neety;

import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;

import java.util.concurrent.ExecutorService;

/**
 * Epool kit
 * 开启epool 事件或者 loop grop事件
 */
public class EpoolKit {

    public static NettyServerGroup group(int threadCount, ExecutorService bossExecutors, int workers, ExecutorService workerExecutors) {
        EpollEventLoopGroup bossGroup   = new EpollEventLoopGroup(threadCount, bossExecutors);

        EpollEventLoopGroup workerGroup = new EpollEventLoopGroup(workers, workerExecutors);
        return NettyServerGroup.builder().boosGroup(bossGroup).wokeGroup(workerGroup).socketChannel(EpollServerSocketChannel.class).build();
    }

}
