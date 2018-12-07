package com.joiest.market.common.utils;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 二维码工具类测试类
 * @author zhouchaowei 
 */
public class QrcodeUtilTester {
    
    private static Logger logger = LoggerFactory.getLogger(QrcodeUtilTester.class);

    /**
     * 生成二维码测试
     */
    @Test
    public void test_zxingCodeCreate() {
        QrcodeUtils.zxingCodeCreate("https://mp.weixin.qq.com/s/don_apn9-iH15tmq0dmlCg");
    }
}
