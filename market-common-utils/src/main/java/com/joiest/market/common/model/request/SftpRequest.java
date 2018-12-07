package com.joiest.market.common.model.request;

/**
 * SFTP连接信息请求实体类
 * @author zhouchaowei 
 */
public class SftpRequest {

    /**
     * 用户名
     */
    private String username;

    /**
     * 连接密码
     */
    private String password;

    /**
     * 连接主机IP地址
     */
    private String host;

    /**
     * 连接端口(SFTP的默认端口为22，FTP的默认端口为21)
     */
    private int port;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    /**
     * SFTP连接主机传参方法
     * @param username 用户名
     * @param password 密码
     * @param host 主机地址
     * @param port 端口
     */
    public SftpRequest(String username, String password, String host, int port) {
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
    }
}
