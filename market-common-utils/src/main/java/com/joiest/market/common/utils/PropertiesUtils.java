package com.joiest.market.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * 读取配置文件的工具类
 * @author zhouchaowei 
 */
public class PropertiesUtils {
    
    private static Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);

    /**
     * 读取配置文件方法
     * @param key 键
     * @return
     */
    public static String readProperties(String key){
        Properties properties = new Properties();
        return properties.getProperty(key);
    }
}
