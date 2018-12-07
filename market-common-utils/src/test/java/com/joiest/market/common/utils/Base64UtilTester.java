package com.joiest.market.common.utils;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base64工具类测试类
 * @author admin 
 */
public class Base64UtilTester {

    private static Logger logger = LoggerFactory.getLogger(JsonUtilTester.class);
    
    @Test
    public void test_base64Encoder(){
        System.out.println("base64加密后的串是：" + Base64CustomUtils.base64Encoder("Hello world"));
    }
}
