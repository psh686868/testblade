package com.copyblade.server.neety;

import com.copyblade.Blade;
import com.copyblade.Environment;
import com.copyblade.mvc.Const;
import com.copyblade.server.Server;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.concurrent.ExecutorService;

/**
 * Create by psh
 * Date: 2017/11/15
 */
@Slf4j
public class NeetyServer implements Server {
    /*
     * 服务器的一些相关属性
     */
    //全局变量
    private Blade blade ;

    // neety 相关
    private EventLoopGroup      bossGroup;
    private EventLoopGroup      workerGroup;
    private EventLoopGroup eventExecutors;
    private Channel channel;
    // 主线程池的个数
    private int threadCount;
    // neety的工作线程池个数
    private int workCount;
    //线程相关
    private ExecutorService bossExecutor;
    private ExecutorService wokeExecutor;
    // backlog
    private int backlog;


    @Override
    public void start(Blade blade, String[] args) throws Exception {
         this.blade = blade;

         long initStart = System.currentTimeMillis();

         log.info("Environment: jdk.version => {}" ,System.getProperty("java.version"));
         log.info("Environment: file.encoding => {}" ,System.getProperty("file.encoding"));
         log.info("Environment:  classpath => {}" ,System.getProperty(this.getClass().getClassLoader().getResource("").getPath()));

        this.startServer(initStart);

    }

    /**
     * 启动服务
     * @param initStart
     */
    private void startServer(long initStart) throws InterruptedException {
        // 创建ServerBootstrap
        ServerBootstrap bootstrap = new ServerBootstrap();
        //设置scoket
        bootstrap.option(ChannelOption.SO_BACKLOG,backlog);
        bootstrap.option(ChannelOption.SO_REUSEADDR,true);
        bootstrap.childOption(ChannelOption.SO_REUSEADDR,true);

        //检查是否使用linux的epoll 详情http://blog.csdn.net/chen_fly2011/article/details/56480925

        if (false) {
            log.info("😜 使用linux的epoll进行开启");
            bootstrap.option(EpollChannelOption.SO_REUSEADDR,true);
            NettyServerGroup nettyServerGroup = EpoolKit.group(threadCount, bossExecutor, workCount, wokeExecutor);
            this.bossGroup= nettyServerGroup.getBoosGroup();
            this.workerGroup= nettyServerGroup.getWokeGroup();
            bootstrap.group(bossGroup,workerGroup);
            bootstrap.channel(NioServerSocketChannel.class);// 指定所使用的 NIO 传输 Channel
        } else {
            log.info("🤪 使用nioEventLoopGriup");
             this.bossGroup = new NioEventLoopGroup(threadCount, bossExecutor);
            this.workerGroup  = new NioEventLoopGroup(workCount, wokeExecutor);
            bootstrap.group(bossGroup,workerGroup); //设置工作
            bootstrap.channel(NioServerSocketChannel.class); // 指定所使用的 NIO 传输 Channel
        }

       //设置 childHandler
        bootstrap.handler(new LoggingHandler(LogLevel.DEBUG)).//下面这句 添加ServerHandler到于Channel的 ChannelPipeline
                childHandler(new HttpServerInitializer(blade, bossGroup.next()));

        ChannelFuture bind = bootstrap.bind(Environment.get(Const.ENV_KEY_SERVER_ADDRESS, Const.LOCAL_IP_ADDRESS),
                Environment.getInt(Const.ENV_KEY_SERVER_PORT, Const.DEFAULT_SERVER_PORT));// 使用指定的端口设置套接字地址

        channel = bind.sync().channel();

        //打印启动的信息
        log.info("🤪 服务器成功的启动 initialize success appName is {} ; 启动所花时间：{}",
                Const.ENV_KEY_APP_NAME, System.nanoTime()-initStart);
        log.info("😜 服务器启动的信息 ip:{} ; 端口{}",Environment.get(Const.ENV_KEY_SERVER_ADDRESS, Const.LOCAL_IP_ADDRESS),
                Environment.getInt(Const.ENV_KEY_SERVER_PORT, Const.DEFAULT_SERVER_PORT));
        //blade.eventManager()

    }

    @Override
    public void stop() {

    }

    @Override
    public void join() {

    }

    @Override
    public void stopAndWrite() {

    }
}
