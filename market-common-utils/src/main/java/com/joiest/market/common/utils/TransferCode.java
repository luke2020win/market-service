package com.joiest.market.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 转码工具类
 * @author admin 
 */
public class TransferCode {

    private static Logger logger = LoggerFactory.getLogger(TransferCode.class);
    
    /**
     * 测试
     * @param args
     * @throws UnsupportedEncodingException
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(urlDecoder(urlEecoder("http://www.baidu.com",TranscodingEnum.UTF_8.getCode()), TranscodingEnum.UTF_8.getCode()));
    }

    /**
     * URI转码(针对汉字的密文转明文)
     * @param urlCode url密文
     * @param codeFormat 编码格式
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String urlDecoder(String urlCode,String codeFormat) throws UnsupportedEncodingException {
        logger.info("获取的密文数据是：{}",urlCode);
        return URLDecoder.decode(urlCode, codeFormat);
    }

    /**
     * URI转码(针对汉字的明文转密文)
     * @param url 要转码的url
     * @param codeFormat 编码格式
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String urlEecoder(String url,String codeFormat) throws UnsupportedEncodingException {
        logger.info("获取的url是：{}",url);
        return URLEncoder.encode(url, codeFormat);
    }
}
