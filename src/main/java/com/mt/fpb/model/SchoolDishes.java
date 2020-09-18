package com.mt.fpb.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "school_dishes")
public class SchoolDishes {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 添加时间
     */
    @Column(name = "add_time")
    private String addTime;

    /**
     * 学校id
     */
    @Column(name = "user_id")
    private String userId;

    private String name; // 菜名

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 图片
     */
    @Column(name = "img_address")
    private String imgAddress;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取添加时间
     *
     * @return add_time - 添加时间
     */
    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取图片
     *
     * @return img_address - 图片
     */
    public String getImgAddress() {
        return imgAddress;
    }

    /**
     * 设置图片
     *
     * @param imgAddress 图片
     */
    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }
}