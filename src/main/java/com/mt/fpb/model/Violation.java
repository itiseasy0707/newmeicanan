package com.mt.fpb.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Violation {
    /**
     * 自增id
     */
    @Id
    private Integer id;

    /**
     * 违规店铺id
     */
    @Column(name = "shop_id")
    private Integer shopId;

    /**
     * 添加时间
     */
    @Column(name = "add_time")
    private Date addTime;

    /**
     * 违规图片
     */
    @Column(name = "vio_img")
    private String vioImg;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 分值
     */
    private String deductions;

    /**
     * 违规描述
     */
    @Column(name = "vio_desc")
    private String vioDesc;


    @Column(name = "vio_type")
    private String vioType;  // 违规类型  外键  大类关联


    /**
     * 获取自增id
     *
     * @return id - 自增id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增id
     *
     * @param id 自增id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取违规店铺id
     *
     * @return shop_id - 违规店铺id
     */
    public Integer getShopId() {
        return shopId;
    }

    /**
     * 设置违规店铺id
     *
     * @param shopId 违规店铺id
     */
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    /**
     * 获取添加时间
     *
     * @return add_time - 添加时间
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 设置添加时间
     *
     * @param addTime 添加时间
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取违规图片
     *
     * @return vio_img - 违规图片
     */
    public String getVioImg() {
        return vioImg;
    }

    /**
     * 设置违规图片
     *
     * @param vioImg 违规图片
     */
    public void setVioImg(String vioImg) {
        this.vioImg = vioImg;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取类型
     *
     * @return type - 类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型
     *
     * @param type 类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    public String getDeductions() {
        return deductions;
    }

    public void setDeductions(String deductions) {
        this.deductions = deductions;
    }

    /**
     * 获取违规描述
     *
     * @return vio_desc - 违规描述
     */
    public String getVioDesc() {
        return vioDesc;
    }

    /**
     * 设置违规描述
     *
     * @param vioDesc 违规描述
     */
    public void setVioDesc(String vioDesc) {
        this.vioDesc = vioDesc;
    }

    public String getVioType() {
        return vioType;
    }

    public void setVioType(String vioType) {
        this.vioType = vioType;
    }
}