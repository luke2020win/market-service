package com.joiest.market.common.example;

import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author admin 
 */
public class ExcelExportDemo {

    /**
     * 写入标题
     * @param sheet
     * @param rowNum 第几行的行号
     * @param values key:第几列的列号  value:值
     */
    public static void genSheetHead(SXSSFSheet sheet, int rowNum, Map<Integer, Object> values) {
        SXSSFRow row = sheet.createRow(rowNum);
        for (Integer cellNum : values.keySet()) {
            SXSSFCell cell = row.createCell(cellNum);
            Object value = values.get(cellNum);
            generateValue(value, cell);
        }
    }

    /**
     * @param row
     * @param cellNum 第几列的列号
     * @param value   值
     */
    public static void createCell(SXSSFRow row, int cellNum, Object value) {
        SXSSFCell cell = row.createCell(cellNum);
        generateValue(value, cell);
    }

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

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        SXSSFWorkbook workbook = new SXSSFWorkbook(1);
        // 导出文件
        File file = new File("E:\\"+ new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()) +".xlsx");
        SXSSFSheet sheet = workbook.getSheet("sheet1");
        if (sheet == null) {
            sheet = workbook.createSheet("sheet1");
        }
        // 生成标题
        Map<Integer, Object> firstTitles = new HashMap<>();
        firstTitles.put(0, "ID");
        firstTitles.put(1, "订单号");
        firstTitles.put(2, "产品名称");
        firstTitles.put(3, "产品类型");
        firstTitles.put(4, "数量");
        firstTitles.put(5, "总金额");
        firstTitles.put(6, "总欣豆");
        firstTitles.put(7, "微信昵称");
        firstTitles.put(8, "下单时间");
        firstTitles.put(9, "支付时间");
        firstTitles.put(10, "状态");
        firstTitles.put(11, "供应商");
        firstTitles.put(12, "订单来源");
        genSheetHead(sheet, 0, firstTitles);

        for (int rownum = 1; rownum < 100000; rownum++) {
            SXSSFRow row = sheet.createRow(rownum);
            int k = -1;
            createCell(row, ++k, "" + rownum + "");
            createCell(row, ++k, "34343123456789");
            createCell(row, ++k, "携程任我行");
            createCell(row, ++k, "携程");
            createCell(row, ++k, "1332");
            createCell(row, ++k, "100");
            createCell(row, ++k, "200");
            createCell(row, ++k, "爱吃素的男孩子");
            createCell(row, ++k, "2018-02-31 19:23:33");
            createCell(row, ++k, "2018-02-31 19:23:33");
            createCell(row, ++k, "已支付");
            createCell(row, ++k, "欧飞");
            createCell(row, ++k, "自平台");
        }
        FileOutputStream out = new FileOutputStream(file);
        workbook.write(out);
        System.out.println("执行时间：" + (System.currentTimeMillis()-start) / 1000 + "秒");
        out.close();
    }
}
