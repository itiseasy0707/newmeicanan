package com.mt.fpb.model;


import java.io.Serializable;

/**
 * 水西颐养之家()实体类
 *
 * @author hf
 * @since 2020-10-12 13:36:34
 */
//@Table(name = "`sh_old_man`")
public class SxHome implements Serializable {
    private static final long serialVersionUID = 155753157480825659L;


    private Integer userId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}