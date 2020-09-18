package com.mt.fpb.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

public class Shop {
    @Transient
    private Integer page;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Transient
    private Integer pageSize;
    /**
     * 自增id
     */
    @Id
    private Integer id;

    /**
     * 商铺名称
     */
    @Column(name = "shop_name")
    private String shopName;

    /**
     * 添加时间
     */
    @Column(name = "add_time")
    private Date addTime;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 商家地址
     */
    private String address;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 商家logo
     */
    @Column(name = "shop_logo")
    private String shopLogo;

    /**
     * 商家简介
     */
    @Column(name = "shop_desc")
    private String shopDesc;

    private String contact;// 联系人

    @Column(name = "area_id")
    private String areaId; // 地区id

    private String video; // 视频元数据

    @Transient
    private String areaName; // 地区名称

    @Transient
    private String deducts; // 累计扣分数

    @Transient
    private String rate;// 店铺等级


    /**
     * 纬度
     */
    private String lat;

    /**
     * 精度
     */
    private String lng;

    /**
     * 营业执照
     */
    @Column(name = "charter_img")
    private String charterImg;

    /**
     * 类型
     */
    private Integer type;

    private String foodBusiness;

    private String qualified;

    private Date businessTime;

    private Date qualifiedTime;




    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getFoodBusiness() {
        return foodBusiness;
    }

    public void setFoodBusiness(String foodBusiness) {
        this.foodBusiness = foodBusiness;
    }

    public String getQualified() {
        return qualified;
    }

    public void setQualified(String qualified) {
        this.qualified = qualified;
    }

    public Date getBusinessTime() {
        return businessTime;
    }

    public void setBusinessTime(Date businessTime) {
        this.businessTime = businessTime;
    }

    public Date getQualifiedTime() {
        return qualifiedTime;
    }

    public void setQualifiedTime(Date qualifiedTime) {
        this.qualifiedTime = qualifiedTime;
    }

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

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 获取商铺名称
     *
     * @return shop_name - 商铺名称
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 设置商铺名称
     *
     * @param shopName 商铺名称
     */
    public void setShopName(String shopName) {
        this.shopName = shopName;
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
     * 获取商家地址
     *
     * @return address - 商家地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置商家地址
     *
     * @param address 商家地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取电话号码
     *
     * @return phone - 电话号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话号码
     *
     * @param phone 电话号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取商家logo
     *
     * @return shop_logo - 商家logo
     */
    public String getShopLogo() {
        return shopLogo;
    }

    /**
     * 设置商家logo
     *
     * @param shopLogo 商家logo
     */
    public void setShopLogo(String shopLogo) {
        this.shopLogo = shopLogo;
    }

    /**
     * 获取商家简介
     *
     * @return shop_desc - 商家简介
     */
    public String getShopDesc() {
        return shopDesc;
    }

    /**
     * 设置商家简介
     *
     * @param shopDesc 商家简介
     */
    public void setShopDesc(String shopDesc) {
        this.shopDesc = shopDesc;
    }

    /**
     * 获取纬度
     *
     * @return lat - 纬度
     */
    public String getLat() {
        return lat;
    }

    /**
     * 设置纬度
     *
     * @param lat 纬度
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * 获取精度
     *
     * @return lng - 精度
     */
    public String getLng() {
        return lng;
    }

    /**
     * 设置精度
     *
     * @param lng 精度
     */
    public void setLng(String lng) {
        this.lng = lng;
    }

    /**
     * 获取营业执照
     *
     * @return charter_img - 营业执照
     */
    public String getCharterImg() {
        return charterImg;
    }

    /**
     * 设置营业执照
     *
     * @param charterImg 营业执照
     */
    public void setCharterImg(String charterImg) {
        this.charterImg = charterImg;
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

    public String getDeducts() {
        return deducts;
    }

    public void setDeducts(String deducts) {
        this.deducts = deducts;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}