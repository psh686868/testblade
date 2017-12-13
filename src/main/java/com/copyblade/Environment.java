package com.copyblade;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import static java.util.Optional.ofNullable;

/**
 *
 * 系统环境
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Environment {

    /**
     * Classpath prefix
     */
    private static final String PREFIX_CLASSPATH = "classpath:";

    /**
     * File prefix
     */
    private static final String PREFIX_FILE = "file:";

    /**
     * Url prefix
     */
    private static final String PREFIX_URL = "url:";

    /**
     * Save the internal configuration
     */
    private static Properties props = new Properties();


    public static Environment empty () {
        return new Environment();
    }

    /**
     * 返回带配置的全局变量
     */

    public static Environment of (@NonNull Properties properties) {
        Environment environment = new Environment();
        environment.props = properties;
        return environment;
    }

    /**
     * 返回带配置的全局变量通过map设置属性
     */

    public static Environment of (@NonNull Map<String,String> map) {
        Environment environment = new Environment();
        map.forEach((key,value) -> environment.props.setProperty(key,value));
        return environment;
    }

    /**
     * 通过网络设置变量
     */

    public static Environment of (@NonNull URL url) {
        try {
            return of(url.openStream());
        } catch (IOException e) {
            throw new IllegalStateException(e);

        }
    }

    /**
     * 通过指定配置文件配置
     */

    public static Environment of (@NonNull File file) {
        try {
            return of(Files.newInputStream(Paths.get(file.getPath())));
        } catch (IOException e) {
            throw new IllegalStateException(e);

        }
    }




    private static Environment of(InputStream inputStream) throws IOException {
        Environment environment = new Environment();
        environment.props.load(new InputStreamReader(inputStream,"UTF-8"));
        return environment;
    }

    public Map<String,String> toMap () {
        Map<String,String> map = new HashMap<>(props.size());
        this.props.forEach((key,value) -> map.put(key.toString(),value.toString()));
        return map;
    }


    /**
     * java8 的方式获取值
     * @param key
     * @param value
     * @return
     */
    public static Integer getInt (String key , int value) {
        return getInt(key).orElse(value);
    }

    public static Optional<Integer> getInt (String key) {
    if (null != key && !(getObject(key).isPresent())) {
            return Optional.of(Integer.parseInt(getObject(key).get().toString()));
        }
        return Optional.empty();
    }

    /**
     * 获取一些默认的信息
     */
    public static String get(String key ,String defaultValue) {
        return get(key).orElse(defaultValue);
    }

    public static Optional<String> get (String key) {
        if (null == key)  {
            return Optional.empty();
        }
        return Optional.ofNullable(props.getProperty(key));
    }

    public static Optional<Object> getObject(String key) {
        return ofNullable(key);
    }


}
