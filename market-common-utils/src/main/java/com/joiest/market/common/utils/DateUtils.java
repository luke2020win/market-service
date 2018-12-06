package com.joiest.market.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * @author admin 
 */
public class DateUtils {

    private static Logger logger = LoggerFactory.getLogger(DateUtils.class);
    
    public static void main(String[] args) {
        System.out.println(getBeforeDayTimeReturnDate(3, 23, 0, 0));
        System.out.println(getBeforeDayTimeReturnString(3, 23, 0, 0));
    }

    /**
     * 获取day天前的指定时间
     * (例如:生成当前时间前一天时间零点，当前时间为2016/7/18 15:44:30，则生成时间为2016/7/17 00:00:00)
     * @param day 天
     * @param hour 时
     * @param minute 分
     * @param second 秒
     * @return 日期类型
     */
    public static Date getBeforeDayTimeReturnDate(int day,int hour,int minute,int second){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar. HOUR_OF_DAY, hour < 0 || hour > 24 ? 0 : hour);
        calendar.set(Calendar. MINUTE, minute < 0 || minute > 60 ? 0 : minute);
        calendar.set(Calendar. SECOND, second < 0 || second > 60 ? 0 : second);
        calendar.set(Calendar. MILLISECOND, 0);
        calendar.add(Calendar. DAY_OF_MONTH, Integer.valueOf("-" + (day < 0 ? 0 : day)));
        return calendar.getTime();
    }

    /**
     * 获取day天前的指定时间，返回标准格式的(2016-7-18 15:44:30)
     * (例如:生成当前时间前一天时间零点，当前时间为2016/7/18 15:44:30，则生成时间为2016/7/17 00:00:00)
     * @param day 天
     * @param hour 时
     * @param minute 分
     * @param second 秒
     * @return 字符串类型
     */
    public static String getBeforeDayTimeReturnString(int day,int hour,int minute,int second){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar. HOUR_OF_DAY, hour < 0 || hour > 24 ? 0 : hour);
        calendar.set(Calendar. MINUTE, minute < 0 || minute > 60 ? 0 : minute);
        calendar.set(Calendar. SECOND, second < 0 || second > 60 ? 0 : second);
        calendar.set(Calendar. MILLISECOND, 0);
        calendar.add(Calendar. DAY_OF_MONTH, Integer.valueOf("-" + (day < 0 ? 0 : day)));
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
    }

    /**
     * 获取当前时间若干小时之前的时间点
     * @param hour 小时数
     * @return 时间类型
     */
    public static Date getBeforeHourTimeReturnDate(int hour){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - hour);
        return calendar.getTime();
    }
}
