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

    private String snumber;

    private String name;

    private String password;

    private Integer sex;

    private String telephone;


    public Student(){

    }

    public Student(String snumber, String name, String password, Integer sex, String telephone){
        this.snumber = snumber;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.telephone = telephone;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSnumber() {
        return snumber;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "Student{" +
                "sid=" + sid +
                ", snumber='" + snumber + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
