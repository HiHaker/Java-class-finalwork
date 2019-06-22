package com.ynu.finalwork.entity;


import javax.persistence.*;

/**
 *create by fukaimi
 * 2019/6/12
 */

@Entity
@Table(name="course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;

    private String  name;

    private Double credit;

    public Course(){

    }

    public Course(String name, Double credit) {
        this.name = name;
        this.credit = credit;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    // 重写比较课程的方法，如果课程号相同，认为相同
    @Override
    public boolean equals(Object obj) {
        Course temp = (Course)obj;
        if (temp.getCid() == this.cid){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                '}';
    }
}

