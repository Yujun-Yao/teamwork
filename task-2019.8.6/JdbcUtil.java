package com.train.unit19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JDBC工具类
 * @Author 姚玉军
 * @Date 2019/8/6
 * @Version V1.0
 */
public class JdbcUtil {
    private static String url = "jdbc:mysql://localhost:3306/task?useUnicode=true&characterEncoding=GBK";
    private static String user = "root";
    private static String password = "123456";

    /**
     * 获取数据库连接
     * @return 数据库连接对象
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭资源
     * @param resource 要关闭的资源对象
     */
    public static void closeResource(AutoCloseable resource) {
        if (null != resource) {
            try {
                resource.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
