package com.ynu.finalwork.entity;

import java.io.Serializable;

/**
 * Created on 2019/6/12 0012
 * BY hujianlong
 * 复合主键类
 */
public class DoubleKey implements Serializable {
    private Integer sid;
    private Integer cid;

    // getter 和 setter

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((sid == null) ? 0 : sid.hashCode());
        result = PRIME * result + ((cid == null) ? 0 : cid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }

        final DoubleKey other = (DoubleKey) obj;
        if(sid == null){
            if(other.sid != null){
                return false;
            }
        }else if(!sid.equals(other.sid)){
            return false;
        }
        if(cid == null){
            if(other.cid != null){
                return false;
            }
        }else if(!cid.equals(other.cid)){
            return false;
        }

        return true;
    }
}
