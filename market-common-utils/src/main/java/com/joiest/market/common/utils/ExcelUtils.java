package com.joiest.market.common.utils;

import com.joiest.market.common.example.User;
import net.sf.json.JSONObject;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

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
     * @param titleArray 数据表的表头字段数组
     * @return JSONObject
     */
    public static JSONObject exportDataToExcel(List<User> list, int operationType, String [] titleArray){
        logger.info("开始将List的数据导出到Excel");
        operationType = operationType < 1 ? 1 : operationType;
        JSONObject res = new JSONObject();
        res.put("code","10000");
        res.put("info","SUCCESS");
        SXSSFWorkbook xssfWorkbook = new SXSSFWorkbook();
        for (int i = 0; i < 1; i++) {
            SXSSFSheet sheet = xssfWorkbook.getSheet("sheet" + (i + 1));
            if (sheet == null) {
                sheet = xssfWorkbook.createSheet("sheet" + (i + 1));
            }
            // 生成标题
            Map<Integer, Object> firstTitles = new HashMap<>();
            for(int k = 0;k < titleArray.length;k++){
                firstTitles.put(k, titleArray[k]);
            }
            genSheetHead(sheet, firstTitles);
            for (int rowNum = 1; rowNum < list.size(); rowNum++) {
                SXSSFRow row = sheet.createRow(rowNum);
                int k = -1;
                createCell(row, ++k, list.get(rowNum - 1).getName());
                createCell(row, ++k, list.get(rowNum - 1).getPassword());
            }
        }
        return res;
    }

    /**
     * 生成sheet页的方法
     * @param sheet 当前sheet页对象
     * @param firstTitles 传入的数据表头字段
     */
    private static void genSheetHead(SXSSFSheet sheet, Map<Integer, Object> firstTitles) {
        logger.info("开始生成Sheet页");
    }

    /**
     * 写入单元格
     * @param row
     * @param cellNum
     * @param value
     */
    private static void createCell(SXSSFRow row, int cellNum, Object value) {
        logger.info("开始写入单元格");
        SXSSFCell cell = row.createCell(cellNum);
        generateValue(value, cell);
    }

    /**
     * 生成值方法
     * @param value 生成的值
     * @param cell 要写入的单元格对象
     */
    private static void generateValue(Object value, SXSSFCell cell) {
        if (value instanceof String) {
            cell.setCellValue((String) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if (value instanceof Double) {
            cell.setCellValue((Double) value);
        } else if (value instanceof Date) {
            cell.setCellValue((Date) value);
        } else if (value instanceof Calendar) {
            cell.setCellValue((Calendar) value);
        } else if (value instanceof RichTextString) {
            cell.setCellValue((RichTextString) value);
        }
    }
}
