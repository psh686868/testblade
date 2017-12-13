package com.copyblade.event;

import com.copyblade.Blade;
import org.junit.Assert;
import org.junit.Test;

/**
 * 事件的测试
 * Create by psh
 * Date: 2017/12/12
 */
public class EventTest {
    @Test
    public void testEvent () {
        Event event = new Event(EventType.SERVER_STARTED);
        Assert.assertEquals("SERVER_STARTED",event.eventType.name());
    }
    @Test
    public void testEventAndBlade () {
        Event event = new Event(EventType.SERVER_STARTED,Blade.me());
        Assert.assertEquals("SERVER_STARTED",event.eventType.name());
        Assert.assertNotNull(event.blade);
    }

}
