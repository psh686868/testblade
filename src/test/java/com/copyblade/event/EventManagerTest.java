package com.copyblade.event;

import com.copyblade.Blade;
import org.junit.Test;

/**
 * Create by psh
 * Date: 2017/12/12
 */
public class EventManagerTest {

    @Test
    public void testEventManager () {
        EventManager eventManager = new EventManager();

        eventManager.addEventListener(EventType.SESSION_CREATED, b -> {
            System.out.println("session cteated");
        });

        eventManager.fireEvent(EventType.SESSION_CREATED);

        eventManager.fireEvent(EventType.SESSION_CREATED, Blade.me());
    }
}
