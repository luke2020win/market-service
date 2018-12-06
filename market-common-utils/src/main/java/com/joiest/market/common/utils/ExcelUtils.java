package com.joiest.market.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Excel操作工具类
 * @author admin 
 */
public class ExcelUtils {
    
    private static Logger logger = LoggerFactory.getLogger(ExcelUtils.class);

    /**
     * 将List导出数据到Excel
     * @param list 要导出的数据集合
     * @param operationType 操作类型 1.下载文件形式 2.生成文件形式
     * @param <T>
     */
    public static <T> void exportDataToExcel(List<T> list, int operationType){
        
    }
}
