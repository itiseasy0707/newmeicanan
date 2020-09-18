package com.mt.fpb.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class Area {
    /**
     * 自增id
     */
    @Id
    private Integer id;

    /**
     * 地区名称
     */
    @Column(name = "area_name")
    private String areaName;

    /**
     * 描述
     */
    @Column(name = "area_desc")
    private String areaDesc;

    /**
     * 类型
     */
    private Integer type;

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
     * 获取地区名称
     *
     * @return area_name - 地区名称
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置地区名称
     *
     * @param areaName 地区名称
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 获取描述
     *
     * @return area_desc - 描述
     */
    public String getAreaDesc() {
        return areaDesc;
    }

    /**
     * 设置描述
     *
     * @param areaDesc 描述
     */
    public void setAreaDesc(String areaDesc) {
        this.areaDesc = areaDesc;
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
}