package com.joiest.market.common.utils;

import com.joiest.market.common.model.request.JdbcConnRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * JDBC连接工具类
 * @author zhouchaowei 
 */
public class JDBCUtils {

    private static Logger logger = LoggerFactory.getLogger(JDBCUtils.class);
    
    /**
     * 数据查询操作(DQL语句)
     * @param sql 查询的SQL语句
     * @return
     */
    public static ResultSet dql(String sql, JdbcConnRequest request){
        logger.info("SQL Statement:{}",sql);
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Connection connection = getConnectMysql(request);
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
        } catch (ClassNotFoundException e) {
            logger.error("获取连接异常:{}",e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            logger.error("SQL操作异常:{}",e.getMessage());
            e.printStackTrace();
        }
        return resultSet;
    }

    /**
     * 数据库插入、删除、更新操作(DML语句)
     * @param sql 操作的SQL语句
     * @param operationType 操作类型 
     *                      DELETE 删除操作
     *                      UPDATE 更新修改操作
     *                      INSERT 插入数据操作
     */
    public static void ddl(String sql,String operationType) {

    }

    /**
     * JDBC连接MySQL数据库
     *
     * @param request
     */
    private static Connection getConnectMysql(JdbcConnRequest request) throws ClassNotFoundException, SQLException {
        Class.forName(request.getDriverClass());
        return DriverManager.getConnection(request.getUrl(), request.getUsername(), request.getPassword());
    }

}