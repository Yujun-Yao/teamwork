package com.mysql.day19.homework.like;

import java.util.List;

public interface StudentOperatable {
    /*
     * 查询所有
     * @return 执行sql
     **/
    List<Student> findAllStudent();

    /**|
     * 根据姓名模糊查找
     * @param userName
     */
    void findByUserNameLike(String userName);

    /**|
     * 根据用户年龄进行排序
     */
    void findOrderByUserAge();

    /**|
     * 根据用户名分页查询
     * @param userName
     * @param pageSize
     */
    void findByUserNameLikeOrderLimit(String userName,int currPage,int pageSize);
}
