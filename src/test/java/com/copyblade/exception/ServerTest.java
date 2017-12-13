package com.copyblade.exception;

import com.copyblade.Blade;
import com.copyblade.server.Server;
import com.copyblade.server.neety.NeetyServer;
import org.junit.Test;

/**
 * @author biezhi
 * @date 2017/9/19
 */
public class ServerTest {

    @Test
    public void testCreateServer() throws Exception {
        Server server = new NeetyServer();
        server.start(Blade.me().listen(10086), null);
        //server.stop();
    }

}
