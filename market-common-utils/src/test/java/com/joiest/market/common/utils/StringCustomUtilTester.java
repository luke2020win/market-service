package com.joiest.market.common.utils;

import org.junit.Test;

/**
 * 字符串工具类测试类
 * @author admin
 */
public class StringCustomUtilTester {
    
    @Test
    public void test_toUpperCaseOfFirstWord(){
        String username = StringCustomUtils.toUpperCaseOfFirstWord("username");
        System.out.println(username);
    }
}
