package com.joiest.market.common.utils;

import com.joiest.market.common.model.request.JdbcConnRequest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JDBC连接工具类
 * @author zhouchaowei 
 */
public class JDBCUtils {

    /**
     * JDBC连接MySQL数据库
     * @param request
     */
    public static void getConnectMysql(JdbcConnRequest request){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(request.getUrl(),request.getUsername(),request.getPassword());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 数据查询操作(DQL语句)
     * @param sql
     * @return
     */
    public static ResultSet dql(String sql){
        return null;
    }

    /**
     * 数据库插入、删除、更新操作(DML语句)
     * @param sql
     */
    public static void ddl(String sql){
        
    }
}
