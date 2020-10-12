package com.mt.fpb.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 美天API对接表
 *
 * @author 风起忆阳娇
 * @since 2020-09-29 16:24:59
 */

@ApiModel(value = "MtApi对象", description = "美天API对接表")
public class MtApi  implements Serializable {
    private static final long serialVersionUID = 899474149257444489L;

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty("设备imei")
    private String imei;

    @ApiModelProperty("告警类型")
    private String alarmtype;

    @ApiModelProperty("设备名称")
    private String devicename;

    @ApiModelProperty("纬度(WGS84坐标系) ")
    private String lat;

    @ApiModelProperty("经度(WGS84坐标系)")
    private String lng;

    @ApiModelProperty("告警时间，格式(yyyy-MM-dd HH:mm:ss) ")
    private String alarmtime;

    @ApiModelProperty("告警地址（未解析成功时返回null） ")
    private String address;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getAlarmtype() {
        return alarmtype;
    }

    public void setAlarmtype(String alarmtype) {
        this.alarmtype = alarmtype;
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getAlarmtime() {
        return alarmtime;
    }

    public void setAlarmtime(String alarmtime) {
        this.alarmtime = alarmtime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public MtApi() {
    }

}