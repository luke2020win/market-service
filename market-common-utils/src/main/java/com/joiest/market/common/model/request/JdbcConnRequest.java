package com.joiest.market.common.model.request;

/**
 * JDBC请求模型
 * @author zhouchaowei 
 */
public class JdbcConnRequest {
    
    private String driverClass;
    private String username;
    private String password;
    private String url;

    public JdbcConnRequest(String username, String password, String url) {
        this.username = username;
        this.password = password;
        this.url = url;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
