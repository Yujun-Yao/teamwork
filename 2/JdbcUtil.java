package com.mysql.day19.homework.like;

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
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
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
