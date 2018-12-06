package com.joiest.market.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 排序工具类
 * @author zhouchaowei
 */
public class SortUtils {

    private static Logger logger = LoggerFactory.getLogger(SortUtils.class);
    
    /**
     * 冒泡排序
     * @param arrayParam 要排序的整形数组
     * @return
     */
    public static int [] bubbleSort(int [] arrayParam){
        System.out.println("整形数组快速排序程序");
        int temp = 0;
        for (int i = 0;i < arrayParam.length - 1;i++){
            for (int j = 0;j < arrayParam.length - 1 -i;j++){
                if(arrayParam[j] > arrayParam[j+1]){
                    temp = arrayParam[j];
                    arrayParam[j] = arrayParam[j+1];
                    arrayParam[j+1] = temp;
                }
            }
        }
        return arrayParam;
    }

    /**
     * 快速排序(待完成)
     * @param arrayParam 需要进行快速排序的数组
     * @return
     */
    public int [] quickSort(int [] arrayParam){
        arrayParam[0] = getMiddle(arrayParam, 0, 0);
        return arrayParam;
    }

    /**
     * 
     * @param arrayParam
     * @param low
     * @param high
     * @return
     */
    private int getMiddle(int[] arrayParam, int low, int high) {
        int temp = arrayParam[low];
        while(low < high){
            while(low < high && arrayParam[high] > temp){
                high--;
            }
            arrayParam[low] = arrayParam[high];
            while(low < high && arrayParam[low] < temp){
                low++;
            }
            arrayParam[high] = arrayParam[low];
        }
        arrayParam[low] = temp;
        return low;
    }
}
