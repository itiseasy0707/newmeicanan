package com.mt.fpb.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 水西颐养之家老人档案(ShOldMan)实体类
 *
 * @author hf
 * @since 2020-10-12 13:36:34
 */
@Table(name = "`sh_old_man`")
public class ShOldMan implements Serializable {
    private static final long serialVersionUID = 155753157480825659L;

    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "`id`")
    private Integer id;

    /**
     * 姓名
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 年龄
     */
    @Column(name = "`age`")
    private Integer age;

    /**
     * 户籍地址
     */
    @Column(name = "`Permanent_address`")
    private String permanentAddress;

    /**
     * 职业
     */
    @Column(name = "`occupation`")
    private String occupation;

    /**
     * 工作单位
     */
    @Column(name = "`Work_unit`")
    private String workUnit;

    /**
     * 文化程度
     */
    @Column(name = "`degree_edu`")
    private String degreeEdu;

    /**
     * 建档日期
     */
    @Column(name = "`date`")
    private Date date;

    /**
     * 医疗支付方式
     */
    @Column(name = "`pay_style`")
    private String payStyle;

    /**
     * 紧急联系人姓名
     */
    @Column(name = "`emergency_name`")
    private String emergencyName;

    /**
     * 紧急联系人电话
     */
    @Column(name = "`emergency_tel`")
    private String emergencyTel;

    /**
     * 身份证号
     */
    @Column(name = "`Id_Card`")
    private String idCard;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getDegreeEdu() {
        return degreeEdu;
    }

    public void setDegreeEdu(String degreeEdu) {
        this.degreeEdu = degreeEdu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPayStyle() {
        return payStyle;
    }

    public void setPayStyle(String payStyle) {
        this.payStyle = payStyle;
    }

    public String getEmergencyName() {
        return emergencyName;
    }

    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    public String getEmergencyTel() {
        return emergencyTel;
    }

    public void setEmergencyTel(String emergencyTel) {
        this.emergencyTel = emergencyTel;
    }

}