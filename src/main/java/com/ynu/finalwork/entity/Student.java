package com.ynu.finalwork.entity;

import javax.persistence.*;

/**
 * Created on 2019/6/12 0012
 * BY hujianlong
 */
@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sid;
    @Column
    private String name;
    @Column
    private Integer sex;
    @Column
    private String telephone;

    public Student(){

    }

    public Student(String name, Integer sex, String telephone){
        this.name = name;
        this.sex = sex;
        this.telephone = telephone;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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
}
