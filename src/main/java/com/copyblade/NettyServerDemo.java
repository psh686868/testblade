package com.copyblade;

/**
 * Create by psh
 * Date: 2017/11/22
 */
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.util.concurrent.ExecutionException;


/**
 * Created by zhengyong on 16/10/21.
 */
public class NettyServerDemo {

    private static ServerBootstrap bootstrap;

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        EventLoopGroup boss = new NioEventLoopGroup(1);
        EventLoopGroup worker = new NioEventLoopGroup();

        bootstrap = new ServerBootstrap();
        bootstrap.group(boss,worker).channel(NioServerSocketChannel.class).handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new ChannelInitializer<SocketChannel>() {//初始化channel
                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline p = ch.pipeline();
                        System.out.println("do init Channel");
                        p.addLast(new ConsoleHandlerDemo());
                    }
                });

        // Start the client.
        ChannelFuture ch = bootstrap.bind(8082).sync();

        System.out.println("start server success, you can telnet 127.0.0.1 8082 to send massage for this server");

        // Wait until the connection is closed.
        ch.channel().closeFuture().sync();
        System.out.println("end !!!!!!!!!!");

    }
}