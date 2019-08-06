package com.train.unit19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * MySQL事务示例：转账业务
 * 例如，用户A转给用户B 100元钱
 * @Author 姚玉军
 * @Date 2019/8/6
 * @Version V1.0
 */
public class TransferAccountDemo {
    public static void main(String[] args) {
        // 1号用户转给2号用户100元钱
        transferAccount(1,2,100);
    }

    /**
     * 转账
     * @param srcUserId 源用户（转钱的用户）的Id
     * @param dstUserId 目标用户（收钱的用户）的Id
     * @param money 要转的钱数
     */
    public static void transferAccount(int srcUserId, int dstUserId, int money) {
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement ps = null;
        try {
            conn.setAutoCommit(false);

            // 转钱的用户
            String sql1 = "UPDATE account SET balance=balance-? WHERE uid=?";
            ps = conn.prepareStatement(sql1);
            ps.setObject(1, money);
            ps.setObject(2, srcUserId);
            ps.executeUpdate();

            // 收钱的用户
            String sql2 = "UPDATE account SET balance=balance+? WHERE uid=?";
            ps = conn.prepareStatement(sql2);
            ps.setObject(1, money);
            ps.setObject(2, dstUserId);
            ps.executeUpdate();

            // 提交事务
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeResource(ps);
            JdbcUtil.closeResource(conn);
        }
    }
}
