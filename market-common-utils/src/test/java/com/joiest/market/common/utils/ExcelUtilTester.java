package com.joiest.market.common.utils;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Excel工具类测试类
 * @author zhouchaowei 
 */
public class ExcelUtilTester {
    
    private static Logger logger = LoggerFactory.getLogger(ExcelUtilTester.class);
    
    @Test
    public void test_exportExcelFile(){
        ExcelUtils.exportExcelFile("/Users/zhouchaowei/Downloads","Test");
    }
}
