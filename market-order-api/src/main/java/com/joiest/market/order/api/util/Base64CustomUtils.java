package com.joiest.market.order.api.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * base64加密
 * @author zhouchaowei
 */
public class Base64CustomUtils {

    /**
     * 加密
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String base64Encoder(String str){
        String result = "";
        try {
            result = new BASE64Encoder().encode(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 解密
     * @param str
     * @return
     * @throws IOException
     */
    public static String base64Decoder(String str) throws IOException {
        return new String(new BASE64Decoder().decodeBuffer(str),"UTF-8");
    }
}
