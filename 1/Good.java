package com.mysql.day19.homework;

public class Good {
    private int id;
    private int gid;
    private String name;
    private int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", gid=" + gid +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
