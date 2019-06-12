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

    private Integer credit;

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

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
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

