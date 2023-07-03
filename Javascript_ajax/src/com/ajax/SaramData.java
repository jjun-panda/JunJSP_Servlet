package com.ajax;

public class SaramData {
    private int seq;
    private String id;
    private String name;
    private int age;

    public SaramData() {
        this(0,"","",0);
    }

    public SaramData(int seq, String id, String name, int age) {
        this.seq = seq;
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getSeq() {
        return seq;
    }
    public void setSeq(int seq) {
        this.seq = seq;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SaramData [seq=" + seq + ", id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
