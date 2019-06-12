package com.ynu.finalwork.entity;

import javax.persistence.*;

/**
 *create by fukaimi
 * 2019/6/12
 */

@Entity
@Table(name="teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    private String  name;

    private Integer sex;

    private String telephone;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
