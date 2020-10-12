package com.mt.fpb.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 健康档案信息(ShHealth)实体类
 *
 * @author hf
 * @since 2020-10-12 13:57:14
 */
@Table(name = "`sh_health`")
public class ShHealth implements Serializable {
    private static final long serialVersionUID = -61369580297813789L;

    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "`id`")
    @ExcelIgnore
    private Integer id;

    /**
     * 血型
     */

    @Column(name = "`Blood_type`")
    private String bloodType;

    /**
     * 药物过敏史
     */
    @Column(name = "`Drug_allergy`")
    private String drugAllergy;

    /**
     * 暴露史
     */
    @Column(name = "`Expose`")
    private String expose;

    /**
     * 手术史
     */
    @Column(name = "`Operation`")
    private String operation;

    /**
     * 外伤史
     */
    @Column(name = "`Trauma`")
    private String trauma;

    /**
     * 输血史
     */
    @Column(name = "`Blood_transfusion`")
    private String bloodTransfusion;

    /**
     * 家族史
     */
    @Column(name = "`Family_history`")
    private String familyHistory;

    /**
     * 遗传史
     */
    @Column(name = "`Genetic`")
    private String genetic;

    /**
     * 残疾情况
     */
    @Column(name = "`Disability`")
    private String disability;

    /**
     * 心率
     */
    @Column(name = "`Heart_rate`")
    private Integer heartRate;

    /**
     * 心电图结论
     */
    @Column(name = "`ECG_conclusion`")
    private String ecgConclusion;

    /**
     * 体温
     */
    @Column(name = "`Temperature`")
    private String temperature;

    /**
     * 血压-收缩压
     */
    @Column(name = "`Blood_pressure_shrink`")
    private String bloodPressureShrink;

    /**
     * 血压-舒张压
     */
    @Column(name = "`Blood_pressure_diastole`")
    private String bloodPressureDiastole;

    /**
     * 血氧饱和度
     */
    @Column(name = "`Blood_oxygen_saturation`")
    private String bloodOxygenSaturation;

    /**
     * 脉率
     */
    @Column(name = "`Pulse_rate`")
    private String pulseRate;

    /**
     * 灌注指数
     */
    @Column(name = "`Perfusion_index`")
    private String perfusionIndex;

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

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getDrugAllergy() {
        return drugAllergy;
    }

    public void setDrugAllergy(String drugAllergy) {
        this.drugAllergy = drugAllergy;
    }

    public String getExpose() {
        return expose;
    }

    public void setExpose(String expose) {
        this.expose = expose;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getTrauma() {
        return trauma;
    }

    public void setTrauma(String trauma) {
        this.trauma = trauma;
    }

    public String getBloodTransfusion() {
        return bloodTransfusion;
    }

    public void setBloodTransfusion(String bloodTransfusion) {
        this.bloodTransfusion = bloodTransfusion;
    }

    public String getFamilyHistory() {
        return familyHistory;
    }

    public void setFamilyHistory(String familyHistory) {
        this.familyHistory = familyHistory;
    }

    public String getGenetic() {
        return genetic;
    }

    public void setGenetic(String genetic) {
        this.genetic = genetic;
    }

    public String getDisability() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public Integer getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public String getEcgConclusion() {
        return ecgConclusion;
    }

    public void setEcgConclusion(String ecgConclusion) {
        this.ecgConclusion = ecgConclusion;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getBloodPressureShrink() {
        return bloodPressureShrink;
    }

    public void setBloodPressureShrink(String bloodPressureShrink) {
        this.bloodPressureShrink = bloodPressureShrink;
    }

    public String getBloodPressureDiastole() {
        return bloodPressureDiastole;
    }

    public void setBloodPressureDiastole(String bloodPressureDiastole) {
        this.bloodPressureDiastole = bloodPressureDiastole;
    }

    public String getBloodOxygenSaturation() {
        return bloodOxygenSaturation;
    }

    public void setBloodOxygenSaturation(String bloodOxygenSaturation) {
        this.bloodOxygenSaturation = bloodOxygenSaturation;
    }

    public String getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(String pulseRate) {
        this.pulseRate = pulseRate;
    }

    public String getPerfusionIndex() {
        return perfusionIndex;
    }

    public void setPerfusionIndex(String perfusionIndex) {
        this.perfusionIndex = perfusionIndex;
    }

}