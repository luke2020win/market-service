package com.joiest.market.order.api.util;

import java.util.concurrent.*;

public class ScheduleUtils {

    /**
     * 基本参数
     */
    static int corePoolSize = 10;

    static int maximumPoolSizeSize = 100;

    static long keepAliveTime = 1;

    static ArrayBlockingQueue workQueue = new ArrayBlockingQueue(10);
    
}
