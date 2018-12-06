package com.joiest.market.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 线程池工具类
 * @author admin 
 */
public class ScheduleUtils {

    private static Logger logger = LoggerFactory.getLogger(ScheduleUtils.class);
    
    /**
     * 基本参数
     */
    static int corePoolSize = 10;

    static int maximumPoolSizeSize = 100;

    static long keepAliveTime = 1;

    static ArrayBlockingQueue workQueue = new ArrayBlockingQueue(10);
    
}
