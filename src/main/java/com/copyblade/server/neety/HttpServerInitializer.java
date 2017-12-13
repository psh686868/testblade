package com.copyblade.server.neety;

import com.copyblade.Blade;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.HttpServerExpectContinueHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

import java.util.concurrent.ScheduledExecutorService;

/**
 * HttpServerInitializer
 * 初始化管道
 *
 */
public class HttpServerInitializer extends ChannelInitializer<SocketChannel> {

    private final Blade blade;
    //private final boolean                  enableGzip;
    //是否开启跨域请求
    //private final boolean                  enableCors;
    private final ScheduledExecutorService service;

    public HttpServerInitializer(Blade blade, ScheduledExecutorService service) {
        this.blade = blade;
        this.service = service;
        //this.enableGzip = blade.environment().getBoolean(Const.ENV_KEY_GZIP_ENABLE, false);
        //this.enableCors = blade
    }

    //处理 ChannelInitializer
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        // neety的管道处理器  个人感觉http://blog.csdn.net/yinwenjie/article/details/48829419 这篇文章讲的不错
        ChannelPipeline p = ch.pipeline();

        p.addLast(new HttpServerCodec(36192 * 2, 36192 * 8, 36192 * 16, false));
        p.addLast(new HttpServerExpectContinueHandler());
        p.addLast(new HttpObjectAggregator(Integer.MAX_VALUE));
        p.addLast(new ChunkedWriteHandler());


    }
}
