package com.mt.fpb.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 老人家属信息(ShRelation)实体类
 *
 * @author hf
 * @since 2020-10-12 13:36:38
 */
@Table(name = "`sh_relation`")
public class ShRelation implements Serializable {
    private static final long serialVersionUID = 593814480664544719L;

    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "`id`")
    private Integer id;

    /**
     * 家属姓名
     */
    @Column(name = "`name`")
    private Integer name;

    /**
     * 联系方式
     */
    @Column(name = "`tel`")
    private String tel;

    /**
     * 户籍地址
     */
    @Column(name = "`Permanent_address`")
    private String permanentAddress;

    /**
     * 亲属关系
     */
    @Column(name = "`relation`")
    private String relation;

    @Column(name = "`oldMan_id`")
    private Integer oldmanId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public Integer getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }

}