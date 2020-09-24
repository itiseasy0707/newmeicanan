package com.mt.fpb.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "btmd_car_data")
public class BtmdCarData {
    /**
     * 主键
     */
    @Id
    @ExcelIgnore
    private Integer id;

    /**
     * 用户名称
     */
    @ExcelProperty(index = 0,value = "用户名称")
    private String name;

    /**
     * 车牌号
     */
    @ExcelProperty(index = 1,value = "车牌号")
    @Column(name = "car_number")
    private String carNumber;

    /**
     * 车型
     */
    @ExcelProperty(index = 2,value = "车型")
    @Column(name = "car_shape")
    private String carShape;

    /**
     * 电话号码
     */
    @ExcelProperty(index = 3,value = "电话号码")
    private String phone;

    /**
     * 生日
     */
    @ExcelProperty(index = 4,value = "生日")
    private String birthday;

    /**
     * 车架号
     */
    @Column(name = "car_shelf")
    @ExcelProperty(index = 5,value = "车架号")
    private String carShelf;

    /**
     * 行驶证号
     */
    @Column(name = "license_number")
    @ExcelProperty(index = 6,value = "行驶证号")
    private String licenseNumber;

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
     * 获取用户名称
     *
     * @return name - 用户名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户名称
     *
     * @param name 用户名称
     */
    public void setName(String name) {
        this.name = name;
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
     * 获取车型
     *
     * @return car_shape - 车型
     */
    public String getCarShape() {
        return carShape;
    }

    /**
     * 设置车型
     *
     * @param carShape 车型
     */
    public void setCarShape(String carShape) {
        this.carShape = carShape;
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
     * 获取生日
     *
     * @return birthday - 生日
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取车架号
     *
     * @return car_shelf - 车架号
     */
    public String getCarShelf() {
        return carShelf;
    }

    /**
     * 设置车架号
     *
     * @param carShelf 车架号
     */
    public void setCarShelf(String carShelf) {
        this.carShelf = carShelf;
    }

    /**
     * 获取行驶证号
     *
     * @return license_number - 行驶证号
     */
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     * 设置行驶证号
     *
     * @param licenseNumber 行驶证号
     */
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
}