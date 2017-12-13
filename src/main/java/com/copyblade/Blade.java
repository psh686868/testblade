package com.copyblade;

import com.copyblade.server.Server;
import com.copyblade.server.neety.NeetyServer;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Blade {


    /**
     * Web server implementation, currently only netty
     */
    private Server server = new NeetyServer();

    private Consumer<Exception> startupExceptionHandler = (e) -> log.error("服务器启动失败", e);


    public static Blade me() {
        return new Blade();
    }

    public Blade listen(int port) {

        return this;
    }

    //事件管理器
    public Blade eventManager() {

        return this;
    }
}
