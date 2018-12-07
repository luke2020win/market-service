package com.joiest.market.common.exception;

/**
 * 异常类
 * @author zhouchaowei 
 */
public class GoPayException extends Exception {

    /**
     * 打印异常
     * @param s
     */
    public GoPayException(String s) {
        System.out.println(s);
    }
}
