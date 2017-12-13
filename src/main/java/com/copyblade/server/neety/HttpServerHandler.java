package com.copyblade.server.neety;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 *
 * Create by psh
 * Date: 2017/12/13
 */
public class HttpServerHandler extends SimpleChannelInboundHandler <FullHttpRequest> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {

    }
}
