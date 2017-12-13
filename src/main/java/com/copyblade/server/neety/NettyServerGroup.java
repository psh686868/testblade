package com.copyblade.server.neety;

import io.netty.channel.MultithreadEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import lombok.Builder;
import lombok.Getter;


/**
 * 封装的NeetyServerGroup
 */
@Builder
@Getter
public class NettyServerGroup {
    private Class<? extends ServerSocketChannel> socketChannel;
    private MultithreadEventLoopGroup boosGroup;
    private MultithreadEventLoopGroup wokeGroup;
}
