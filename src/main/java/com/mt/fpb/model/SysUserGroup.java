package com.mt.fpb.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户组
 */
@Table(name = "sys_user_group")
public class SysUserGroup {
    /**
     * 主键
     */
    @Id
    private String id;

    /**
     * 组名
     */
    private String name;

    /**
     * 所属类型（学校，颐养之家...）
     */
    @Column(name = "type_id")
    private String typeId;

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
     * 获取组名
     *
     * @return name - 组名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置组名
     *
     * @param name 组名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取所属类型（学校，颐养之家...）
     *
     * @return type_id - 所属类型（学校，颐养之家...）
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * 设置所属类型（学校，颐养之家...）
     *
     * @param typeId 所属类型（学校，颐养之家...）
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
}