package com.mt.fpb.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Table(name = "btmd_landry")
public class BtmdLandry {
    /**
     * 主键
     */
    @Id
    private String id;

    /**
     * 车牌号
     */
    @Column(name = "car_number")
    private String carNumber;

    /**
     * 门店类型  关联门店表id
     */
    private String type;

    /**
     * 是否洗完车  0-未洗完  1-洗完了
     */
    private String status;

    /**
     * 添加时间
     */
    @Column(name = "add_time")
    private Date addTime;


    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 所处表中位置(第几位)
     */
    @Transient
    private Integer place;

    @Transient
    private String name; // 门店名称



    @Transient
    private String beginTime;

    @Transient
    private String ownTime;

    @Transient
    private String endTime;

    @Transient
    private Integer page;
    @Transient
    private Integer pageSize;

    public String getOwnTime() {
        return ownTime;
    }

    public void setOwnTime(String ownTime) {
        this.ownTime = ownTime;
    }

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

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取车牌号
     *
     * @return car_number - 车牌号
     */
    public String getCarNumber() {
        return carNumber;
    }

    /**
     * 设置车牌号
     *
     * @param carNumber 车牌号
     */
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    /**
     * 获取门店类型  关联门店表id
     *
     * @return type - 门店类型  关联门店表id
     */
    public String getType() {
        return type;
    }

    /**
     * 设置门店类型  关联门店表id
     *
     * @param type 门店类型  关联门店表id
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取是否洗完车  0-未洗完  1-洗完了
     *
     * @return status - 是否洗完车  0-未洗完  1-洗完了
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置是否洗完车  0-未洗完  1-洗完了
     *
     * @param status 是否洗完车  0-未洗完  1-洗完了
     */
    public void setStatus(String status) {
        this.status = status;
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

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}