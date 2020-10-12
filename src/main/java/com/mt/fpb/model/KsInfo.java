package com.mt.fpb.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 矿山基本信息表(KsInfo)实体类
 *
 * @author hf
 * @since 2020-09-27 09:43:44
 */
@Table(name = "`ks_info`")
public class KsInfo implements Serializable {
    private static final long serialVersionUID = -11606509191662396L;

    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "`id`")
    private Integer id;

    /**
     * 矿山名称
     */
    @Column(name = "`ks_name`")
    private String ksName;

    /**
     * 矿山地址
     */
    @Column(name = "`ks_address`")
    private String ksAddress;

    /**
     * 矿山经度
     */
    @Column(name = "`ks_lng`")
    private String ksLng;

    /**
     * 矿山纬度
     */
    @Column(name = "`ks_lat`")
    private String ksLat;

    /**
     * 矿山视频地址
     */
    @Column(name = "`ks_Video_address`")
    private String ksVideoAddress;

    public String getKsVideoAddress() {
        return ksVideoAddress;
    }

    public void setKsVideoAddress(String ksVideoAddress) {
        this.ksVideoAddress = ksVideoAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKsName() {
        return ksName;
    }

    public void setKsName(String ksName) {
        this.ksName = ksName;
    }

    public String getKsAddress() {
        return ksAddress;
    }

    public void setKsAddress(String ksAddress) {
        this.ksAddress = ksAddress;
    }

    public String getKsLng() {
        return ksLng;
    }

    public void setKsLng(String ksLng) {
        this.ksLng = ksLng;
    }

    public String getKsLat() {
        return ksLat;
    }

    public void setKsLat(String ksLat) {
        this.ksLat = ksLat;
    }

}