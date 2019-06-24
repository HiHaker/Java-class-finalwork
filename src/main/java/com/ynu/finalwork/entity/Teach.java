package com.ynu.finalwork.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "teach")
public class Teach {
    private Integer tid;
    @Id
    private Integer cid;

    public Teach(){

    }

    public Teach(Integer tid, Integer cid) {
        this.tid = tid;
        this.cid = cid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Teach{" +
                "tid=" + tid +
                ", cid=" + cid +
                '}';
    }
}
