package com.joiest.market.common.utils;

import com.jcraft.jsch.*;
import com.joiest.market.common.exception.GoPayException;
import com.joiest.market.common.model.request.SftpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * SFTP工具类
 * @author zhouchaowei 
 */
public class SFTPUtils {

    private static Logger logger = LoggerFactory.getLogger(SFTPUtils.class);
    
    private static Session sshSession = null;
    private static ChannelSftp sftp = null;

    /**
     * 上传单个文件 
     * @param directory 远程主机的文件存放目录(以路径符号结束) 
     * @param uploadFilePath 要上传的文件本机存放 如：D:\\test\\xxx.txt 
     * @param fileName 文件名称 如：xxx.txt 或 xxx.zip 
     * @throws GoPayException
     */
    public static void uploadFile(String directory, String uploadFilePath, String fileName, SftpRequest request)
            throws GoPayException {
        logger.info("开始通过SFTP上传文件");
        FileInputStream in = null;
        connect(request);
        try {
            sftp.cd(directory);
        }catch (SftpException e) {
            try {
                sftp.mkdir(directory);
                sftp.cd(directory);
            }catch (SftpException e1) {
                throw new GoPayException("ftp创建文件路径失败，路径为" + directory);
            }
        }
        File file = new File(uploadFilePath);
        try {
            in = new FileInputStream(file);
            sftp.put(in, fileName);
        }catch (FileNotFoundException e) {
            logger.error("文件不存在:{}",e.getMessage());
            throw new GoPayException("路径" + uploadFilePath + "文件不存在");
        }catch (SftpException e) {
            logger.error("SFTP异常:{}",e.getMessage());
            throw new GoPayException("SFTP异常");
        }finally {
            if (in != null){
                try {
                    in.close();
                }catch (IOException e) {
                    logger.error("{}",e.getMessage());
                    throw new GoPayException("传输流出错");
                }
            }
            disconnect();
        }
        logger.info("SFTP上传文件结束");
    }
    
    /**
     * 连接sftp服务器 
     * @return ChannelSftp sftp类型 
     * @throws GoPayException
     */
    private static ChannelSftp connect(SftpRequest request) throws GoPayException {
        logger.info("SFTP连接开始...正在连接主机{}中...用户名:{},连接秘钥:{}", 
                request.getHost() + ":" + request.getPort() ,request.getUsername(),request.getPassword());
        JSch jsch = new JSch();
        try {
            jsch.getSession(request.getUsername(), request.getHost(), request.getPort());
            sshSession = jsch.getSession(request.getUsername(), request.getHost(), request.getPort());
            logger.info("Session已创建完成");
            sshSession.setPassword(request.getPassword());
            Properties properties = new Properties();
            properties.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(properties);
            sshSession.connect();
            logger.info("Session已连接");
            Channel channel = sshSession.openChannel("sftp");
            channel.connect();
            logger.info("正在打开SFTP传输信道......");
            sftp = (ChannelSftp) channel;
            logger.info("已连接到SFTP主机:sftp://{}",request.getHost() + ":" + request.getPort());
        }catch (JSchException e) {
            logger.error("SFTP连接异常:{}", e.getMessage());
            throw new GoPayException("SFTP连接异常");
        }
        return sftp;
    }

    /**
     * 关闭连接 
     */
    private static void disconnect() {
        if (sftp != null && sftp.isConnected()) {
            sftp.disconnect();
            sftp = null;
            logger.error("SFTP连接已关闭");
        }
        if (sshSession != null && sshSession.isConnected()) {
            sshSession.disconnect();
            sshSession = null;
            logger.error("SSH连接已关闭");
        }
    }
}
