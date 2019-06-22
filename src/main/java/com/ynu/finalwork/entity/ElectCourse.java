package com.ynu.finalwork.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Created on 2019/6/12 0012
 * BY hujianlong
 */
@Entity
@Table(name = "student_course")
@IdClass(DoubleKey.class)
public class ElectCourse {
    private Integer sid;
    private Integer cid;
    private Double grade;

    public ElectCourse(){

    }

    public ElectCourse(Integer sid, Integer cid, Double grade) {
        this.sid = sid;
        this.cid = cid;
        this.grade = grade;
    }

    @Id
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Id
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "ElectCourse{" +
                "sid=" + sid +
                ", cid=" + cid +
                ", grade=" + grade +
                '}';
    }
}
