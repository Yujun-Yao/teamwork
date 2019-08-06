package com.mysql.day19.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
    static final JdbcUtil JDBC_UTIL = new JdbcUtil();
    private JdbcUtil() {

    }
    public static JdbcUtil getInstance() {
        return JDBC_UTIL;
    }
    public Connection getConnection(){
        Connection connection = null;
        try {
            //连接资源
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=GBK","root","123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**|
     * 关闭资源
     * @param autoCloseable
     */
    public void closeResource(AutoCloseable autoCloseable) {
        if (null != autoCloseable) {
            try {
                autoCloseable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
