package com.mt.fpb.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class School {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 学校地址
     */
    private String address;

    /**
     * 角色id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * logo原地址
     */
    @Column(name = "logo_img")
    private String logoImg;


    /**
     * 视频原地址
     */
    @Column(name = "video_address")
    private String videoAddress;
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
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取学校地址
     *
     * @return address - 学校地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置学校地址
     *
     * @param address 学校地址
     */
    public void setAddress(String address) {
        this.address = address;
    }


    public String getVideoAddress() {
        return videoAddress;
    }

    public void setVideoAddress(String videoAddress) {
        this.videoAddress = videoAddress;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取logo原地址

     *
     * @return logo_img - logo原地址
     */
    public String getLogoImg() {
        return logoImg;
    }

    /**
     * 设置logo原地址
     *
     * @param logoImg logo原地址
     */
    public void setLogoImg(String logoImg) {
        this.logoImg = logoImg;
    }
}