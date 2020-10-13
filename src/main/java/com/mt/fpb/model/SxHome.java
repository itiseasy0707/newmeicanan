package com.mt.fpb.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 水西颐养之家(SxHome)实体类
 *
 * @author hf
 * @since 2020-10-13 10:46:04
 */
@Table(name = "`sx_home`")
public class SxHome implements Serializable {
    private static final long serialVersionUID = 982715719523356055L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "`id`")
    private Integer id;

    @Column(name = "`name`")
    private String name;

    /**
     * 视频源数据
     */
    @Column(name = "`address`")
    private String address;

    /**
     * 外键 用户表的外键
     */
    @Column(name = "`user_id`")
    private Integer userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}