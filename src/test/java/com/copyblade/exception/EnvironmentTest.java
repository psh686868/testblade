package com.copyblade.exception;

import com.copyblade.Environment;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * @author biezhi
 * @date 2017/9/18
 */
public class EnvironmentTest {

    @Test
    public void testEmpty() {
        Environment environment = Environment.empty();
        assertEquals(0, environment.toMap().size());
    }

    @Test
    public void testEnvByProperties() {
        Properties properties = new Properties();
        properties.setProperty("name", "jack");
        Environment environment = Environment.of(properties);
       // Assert.assertEquals("jack", environment.get("name").get());
    }


}