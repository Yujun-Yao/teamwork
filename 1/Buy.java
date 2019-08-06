package com.mysql.day19.homework;

public class Buy {
    private int id;
    private int gid;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Buy{" +
                "id=" + id +
                ", gid=" + gid +
                ", count=" + count +
                '}';
    }
}
