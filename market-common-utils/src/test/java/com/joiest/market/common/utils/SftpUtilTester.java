package com.joiest.market.common.utils;

import com.joiest.market.common.exception.GoPayException;
import com.joiest.market.common.model.request.SftpRequest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SFTP工具类测试类
 * @author zhouchaowei 
 */
public class SftpUtilTester {

    private Logger logger = LoggerFactory.getLogger(SftpUtilTester.class);

    /**
     * SFTP文件上传测试方法
     * @throws GoPayException
     */
    @Test
    public void test_uploadFile() throws GoPayException {
        SFTPUtils.uploadFile("/home/","D:/FTP.zip","FTP.zip",
                new SftpRequest("root","zqznzcw19921115","118.25.236.128",22));
    }
}
