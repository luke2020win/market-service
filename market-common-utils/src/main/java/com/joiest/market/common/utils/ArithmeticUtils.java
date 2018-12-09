package com.joiest.market.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * 数学类、财务计算工具类
 * @author admin 
 */
public class ArithmeticUtils {

    private static Logger logger = LoggerFactory.getLogger(ArithmeticUtils.class);
    
    /**
     * 将两个字符串类型的数字相加(带四舍五入功能)
     * @param num1 被加数
     * @param num2 加数
     * @param decimalPlace 保留小数点后面的位数
     * @return
     */
    public static String add(String num1,String num2,int decimalPlace){
        if (decimalPlace < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        logger.info("将 {} 与 {} 相加,保留 {} 位小数",num1,num2,decimalPlace);
        return new BigDecimal(num1).add(new BigDecimal(num2)).setScale(decimalPlace,BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 将两个字符串类型的数字相减(带四舍五入功能)
     * @param num1 被减数
     * @param num2 减数
     * @param decimalPlace 保留小数点后面的位数
     * @return
     */
    public static String subtract(String num1,String num2,int decimalPlace){
        if (decimalPlace < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        logger.info("将 {} 与 {} 相减,保留 {} 位小数",num1,num2,decimalPlace);
        return new BigDecimal(num1).subtract(new BigDecimal(num2)).setScale(decimalPlace, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 将两个字符串类型的数字相乘(带四舍五入功能)
     * @param num1 乘数1
     * @param num2 乘数2
     * @param decimalPlace 保留小数点后面的位数
     * @return
     */
    public static String multiply(String num1, String num2, int decimalPlace){
        if (decimalPlace < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        logger.info("将 {} 与 {} 相乘,保留 {} 位小数",num1,num2,decimalPlace);
        return new BigDecimal(num1).multiply(new BigDecimal(num2)).setScale(decimalPlace, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 将两个字符串类型的数字相除(带四舍五入功能，当发生除不尽的情况时，由scale参数指定精度)
     * @param num1 被除数
     * @param num2 除数
     * @param decimalPlace 保留小数点后面的位数
     * @return
     */
    public static String divide(String num1, String num2, int decimalPlace){
        if (decimalPlace < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        logger.info("将 {} 与 {} 相除,保留 {} 位小数",num1,num2,decimalPlace);
        return new BigDecimal(num1).divide(new BigDecimal(num2), decimalPlace, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 取余数
     * @param num1 被除数
     * @param num2 除数
     * @param decimalPlace 保留小数点后面的位数
     * @return
     */
    public static String remainder(String num1, String num2, int decimalPlace){
        if (decimalPlace < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        logger.info("将 {} 与 {} 相除,余数保留 {} 位小数",num1,num2,decimalPlace);
        return new BigDecimal(num1).remainder(new BigDecimal(num2)).setScale(decimalPlace, BigDecimal.ROUND_HALF_UP).toString();
    }
}
