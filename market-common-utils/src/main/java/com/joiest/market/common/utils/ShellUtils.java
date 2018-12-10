package com.joiest.market.common.utils;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.ConnectionInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * SSH连接操作工具类
 * @author admin 
 */
public class ShellUtils {
    
    private static Logger logger = LoggerFactory.getLogger(ShellUtils.class);

    /**
     * 连接远程Linux主机，执行SSH命令
     * @param hostIp 远程ssh主机Ip
     * @param cmd 要运行的Linux命令
     */
    public static boolean connectHost(String hostIp,String cmd){
        Connection connection = new Connection("192.168.37.128",22);
        try {
            connection.connect();
            boolean authenticate = connection.authenticateWithPassword("joiest_centos", "123456");
            if(authenticate){
                logger.info("连接成功");
            }
            logger.info("连接完成");
        } catch (IOException e) {
            logger.error("连接失败:{}",e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}
