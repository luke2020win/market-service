package com.joiest.market.common.utils;

import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.glassfish.jersey.internal.guava.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

/**
 * Excel操作工具类
 * @author admin 
 */
public class ExcelUtils {
    
    private static Logger logger = LoggerFactory.getLogger(ExcelUtils.class);

    private final static Object object = new Object();

    /**
     * 采用线程池的方式分sheet页导出数据
     * @param filePath 生成Excel文件的路径
     * @param fileName 生成Excel文件的名字(不用带.xlsx或.xls文件后缀)
     */
    public static void exportExcelFile(String filePath, String fileName){
        int processor = Runtime.getRuntime().availableProcessors();
        logger.info("获取处理器核心数:{}",processor);
        SXSSFWorkbook workBook = new SXSSFWorkbook();
        // 手工创建线程池
        ExecutorService executorService = new ThreadPoolExecutor(processor,
                processor,
                1000,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque(),
                new ThreadFactoryBuilder().setNameFormat("poi-task-%d").build());
        //计数器 等待线程池中的线程执行完毕
        CountDownLatch countDownLatch = new CountDownLatch(processor);
        for (int i = 0; i < processor; i++) {
            int sheetId = i;
            // 放入线程池中 
            executorService.execute(() -> createSheet(workBook, sheetId, countDownLatch));
        }
        FileOutputStream fou = null;
        try {
            //等待所有线程执行完毕
            countDownLatch.await();
            executorService.shutdown();
            fou = new FileOutputStream(filePath + "/" + fileName + ".xlsx");
            workBook.write(fou);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fou != null) {
                try {
                    fou.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 创建Sheet页的方法
     * @param workBook
     * @param sheetId
     * @param countDownLatch
     */
    private static void createSheet(SXSSFWorkbook workBook, int sheetId, CountDownLatch countDownLatch) {
        try {
            SXSSFSheet sxssfSheet;
            //这个地方一定要加锁，要不然会出现问题 
            synchronized (object) {
                //创建sheet页 
                sxssfSheet = workBook.createSheet(String.format("第%d个sheet页", sheetId));
            }
            SXSSFRow sxssfRow = sxssfSheet.createRow(0);
            SXSSFCell sxssfCell = sxssfRow.createCell(0);
            sxssfCell.setCellValue("第" + sheetId + "个sheet页，第一行，第一个单元格");

            sxssfCell = sxssfRow.createCell(1);
            sxssfCell.setCellValue("第" + sheetId + "个sheet页，第一行，第二个单元格");

            sxssfCell = sxssfRow.createCell(2);
            sxssfCell.setCellValue("第" + sheetId + "个sheet页，第一行，第三个单元格");

            SXSSFRow hssfRows;
            SXSSFCell hSSFCells;
            for (int i = 1; i < 10; i++) {
                hssfRows = sxssfSheet.createRow(i);
                hSSFCells = hssfRows.createCell(0);
                hSSFCells.setCellValue("第" + sheetId + "个sheet页，第" + (i + 1) + "行，第一个单元格");
                hSSFCells = hssfRows.createCell(1);
                hSSFCells.setCellValue("第" + sheetId + "个sheet页，第" + (i + 1) + "行，第二个单元格");
                hSSFCells = hssfRows.createCell(2);
                hSSFCells.setCellValue("第" + sheetId + "个sheet页，第" + (i + 1) + "行，第三个单元格");
            }
        }finally {
            countDownLatch.countDown();
        }
    }

    /**
     * 将List导出数据到Excel
     * @param list 要导出的数据集合(注意：List的泛型需要根据具体的类来定制)
     * @param operationType 操作类型 1.下载文件形式 2.生成文件形式
     * @param titleArray 数据表的表头字段数组
     * @return JSONObject
     */
    public static <T> JSONObject exportDataToExcel(HttpServletResponse response, List<T> list, int operationType, String path, String [] titleArray) throws NoSuchMethodException {
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
            // TODO 这里需要设置需要生成Excel表的表头字段内容(需要根据具体需求定制) start
            firstTitles.put(0, "姓名");
            firstTitles.put(1, "密码");
            // TODO 这里需要设置需要生成Excel表的表头字段内容(需要根据具体需求定制) end
            genSheetHead(sheet, firstTitles);
            for (int rowNum = 1; rowNum < list.size(); rowNum++) {
                SXSSFRow row = sheet.createRow(rowNum);
                int k = -1;
                // TODO 这里需要设置具体写入单元格的内容，一般为对象属性的值(需要根据具体需求定制) start
                createCell(row, ++k, list.get(rowNum - 1).getClass().getMethod(""));
                // TODO 这里需要设置具体写入单元格的内容，一般为对象属性的值(需要根据具体需求定制) end
            }
        }
        String fileName = "欣豆市场订单列表-" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".xlsx";
        return writeIntoExcel(fileName,response,xssfWorkbook,path,operationType,res);
    }

    /**
     * 将数据写入Excel文件
     * @param fileName 文件名称
     * @param response 响应
     * @param xssfWorkbook 要写入Excel的workbook对象
     * @param path 文件路径
     * @param type 操作类型
     * @param res 返回的JSON对象
     * @return
     */
    private static JSONObject writeIntoExcel(String fileName, HttpServletResponse response, SXSSFWorkbook xssfWorkbook, String path, int type, JSONObject res){
        logger.info("开始将数据写入Excel文件");
        OutputStream output= null;
        try{
            if(type == 1){
                response.reset();
                output = response.getOutputStream();
                response.setCharacterEncoding("utf-8");
                response.setHeader("Content-disposition", "attachment;filename="+new String(fileName.getBytes("gbk"), "iso8859-1"));
                response.setContentType("application/vnd.ms-excel");
                xssfWorkbook.write(output);
                output.close();
            }else{
                File fileDir = new File(path);
                if (!fileDir.exists()) {
                    fileDir.mkdirs();
                }
                File file = new File(path + fileName);
                file.createNewFile();
                //将excel写入
                FileOutputStream stream= FileUtils.openOutputStream(file);
                xssfWorkbook.write(stream);
                stream.close();

                JSONObject fileInfo = new JSONObject();
                //服务器实际路径
                fileInfo.put("localUrl",path + fileName);
                //文件名
                fileInfo.put("fileName",fileName);

                res.put("data",fileInfo);
            }
        }catch (IOException e){
            e.printStackTrace();
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
        SXSSFRow row = sheet.createRow(0);
        for (Integer cellNum : firstTitles.keySet()) {
            SXSSFCell cell = row.createCell(cellNum);
            Object value = firstTitles.get(cellNum);
            generateValue(value, cell);
        }
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
