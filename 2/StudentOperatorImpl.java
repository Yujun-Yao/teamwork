package com.mysql.day19.homework.like;


import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentOperatorImpl implements StudentOperatable {
    /**
     * @Description 查询学生信息
     * @Date 20:39 2019/8/5
     * @Param []
     * @return 返回查询到的对象
     **/
    @Override
    public List<Student> findAllStudent() {
        List<Student> listStu = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
           connection =  JdbcUtil.getInstance().getConnection();
           statement = connection.createStatement();
           String sql = "select * from student";
           rs = statement.executeQuery(sql);
            while (rs.next()) {
                String sno = rs.getString(1);
                String sname = rs.getString("sname");
                String ssex = rs.getString("ssex");
                int age = rs.getInt("sage");
                String clz = rs.getString("clz");

                Student student = new Student();
                student.setSno(sno);
                student.setSname(sname);
                student.setSsex(ssex);
                student.setSage(age);
                student.setClz(clz);
                listStu.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(rs);
            JdbcUtil.getInstance().closeResource(statement);
            JdbcUtil.getInstance().closeResource(connection);
        }
        listStu.forEach(System.out::println);
        return listStu;
    }

    /**|
     * 模糊查找
     * @param likeName
     */
    @Override
    public void findByUserNameLike(String likeName) {
        List<Student> listStu = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection =  JdbcUtil.getInstance().getConnection();
            String sql = "select * from student where sname like ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,likeName);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String sno = rs.getString(1);
                String sname = rs.getString("sname");
                String ssex = rs.getString("ssex");
                int age = rs.getInt("sage");
                String clz = rs.getString("clz");
                //创建学生对象进行接收查询到的信息
                Student student = new Student();
                student.setSno(sno);
                student.setSname(sname);
                student.setSsex(ssex);
                student.setSage(age);
                student.setClz(clz);
                listStu.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(rs);
            JdbcUtil.getInstance().closeResource(preparedStatement);
            JdbcUtil.getInstance().closeResource(connection);
        }
        //遍历查到的学生信息
        listStu.forEach(System.out::println);
    }

    /**|
     * 根据年龄排序
     */
    @Override
    public void findOrderByUserAge() {
        List<Student> listStu = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection =  JdbcUtil.getInstance().getConnection();
            String sql = "select * from student order by sage";
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String sno = rs.getString("sid");
                String sname = rs.getString("sname");
                String ssex = rs.getString("ssex");
                int age = rs.getInt("sage");
                String clz = rs.getString("clz");

                Student student = new Student();
                student.setSno(sno);
                student.setSname(sname);
                student.setSsex(ssex);
                student.setSage(age);
                student.setClz(clz);
                listStu.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(rs);
            JdbcUtil.getInstance().closeResource(preparedStatement);
            JdbcUtil.getInstance().closeResource(connection);
        }
        //遍历排序后的的学生信息
        listStu.forEach(System.out::println);
    }

    @Override
    public void findByUserNameLikeOrderLimit(String likeName, int currPage, int pageSize) {
        List<Student> listStu = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection =  JdbcUtil.getInstance().getConnection();
            String sql = "select * from student where sname like ? limit ?,?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,"%"+likeName+"%");
            preparedStatement.setObject(2,currPage-1);
            preparedStatement.setObject(3,pageSize);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String sno = rs.getString("sid");
                String sname = rs.getString("sname");
                String ssex = rs.getString("ssex");
                int age = rs.getInt("sage");
                String clz = rs.getString("clz");

                Student student = new Student();
                student.setSno(sno);
                student.setSname(sname);
                student.setSsex(ssex);
                student.setSage(age);
                student.setClz(clz);
                listStu.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(rs);
            JdbcUtil.getInstance().closeResource(preparedStatement);
            JdbcUtil.getInstance().closeResource(connection);
        }
        //遍历排序后的的学生信息
        listStu.forEach(System.out::println);
    }

}
