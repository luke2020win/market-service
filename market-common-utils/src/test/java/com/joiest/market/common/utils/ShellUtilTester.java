package com.joiest.market.common.utils;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * ssh远程连接工具类测试类
 * @author admin 
 */
public class ShellUtilTester {

    private static Logger logger = LoggerFactory.getLogger(ShellUtilTester.class);
    
    private static final String IP = PropertiesUtils.readProperties("ssh_ip");
    private static final String SSH_PORT = PropertiesUtils.readProperties("ssh_port");
    private static final String SSH_USERNAME = PropertiesUtils.readProperties("ssh_username");
    private static final String SSH_PASSWORD = PropertiesUtils.readProperties("ssh_password");
    
    @Value("${ssh_password}")
    private static String getSshPassword;
    
    @Test
    public void test_connectHost(){
        //ShellUtils.connectHost();
        System.out.println(IP);
        System.out.println(SSH_PORT);
        System.out.println(SSH_USERNAME);
        System.out.println(getSshPassword);
    }
}
