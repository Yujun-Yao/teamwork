package com.mysql.day19.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ShopingDemo {
    /**|
     * main 方法
     * @param args
     */
    public static void main(String[] args) {
        Buy buy = new Buy();
        buy.setGid(001);
        buy.setCount(10);
        buyGood(buy);
    }

    /**|
     * 购买商品
     * @param buy
     */
    public static void buyGood(Buy buy) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = JdbcUtil.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);

            //购买的商品号和数量的sql语句
            String sqlInsert = "insert into buy values(null,'"+buy.getGid()+"','"+buy.getCount()+"')";
            preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.executeUpdate();

            //商品对应库存的sql语句
            String sqlUpdate = "update good set count=count-'"+buy.getCount()+"'";
            preparedStatement = connection.prepareStatement(sqlUpdate);
           int aferedRow = preparedStatement.executeUpdate();
            if (aferedRow > 0) {
                System.out.println("购买成功");
            }
            //提交修改
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.clearParameters();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
