package com.joiest.market.common.utils;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 二维码工具类
 * @author admin 
 */
public class QrcodeUtils {

    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;
    
    private static Map<EncodeHintType,String> map = new HashMap<EncodeHintType, String>();

    /**
     * ZXing方式将字符串生成二维码
     * @param text 二维码内容
     */
    public static void zxingCodeCreate(String text){
        map.put(EncodeHintType.CHARACTER_SET,"utf-8");
        try {
            // 1.生成二维码
            BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE,300,300,map);
            // 2.将二维码放入缓冲流
            BufferedImage image = new BufferedImage(bitMatrix.getWidth(),bitMatrix.getHeight(),BufferedImage.TYPE_INT_RGB);
            for (int i = 0;i < bitMatrix.getWidth();i++){
                for (int j = 0;j < bitMatrix.getHeight();j++){
                    // 3.通过循环,将内容写入二维码图片
                    image.setRGB(i,j,bitMatrix.get(i,j) ? BLACK : WHITE);
                }
            }
            File imageFile = new File("D://二维码.jpg");
            if(!imageFile.exists()){
                imageFile.createNewFile();
            }
            ImageIO.write(image, "jpg", imageFile);
        } catch (WriterException e) {
            e.printStackTrace();
            System.out.println("二维码生成失败");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("生成二维码图片失败");
        }
    }
}
