package com.joiest.market.common.utils;

/**
 * 字符串工具类
 * @author admin 
 */
public class StringCustomUtils {

    /**
     * 将字符串的第一个字母大写并输出
     * @param str
     * @return
     */
    public static String toUpperCaseOfFirstWord(String str){
        return str.substring(0,1).toUpperCase() + str.substring(1,str.length());
    }
}
