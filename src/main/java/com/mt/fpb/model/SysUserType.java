package com.mt.fpb.model;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 大类
 */
@Table(name = "sys_user_type")
public class SysUserType {
    /**
     * 主键
     */
    @Id
    private String id;

    /**
     * 大类名称(学校，颐养之家)
     */
    private String name;

    /**
     * 描述
     */
    private String description;

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
     * 获取大类名称(学校，颐养之家)
     *
     * @return name - 大类名称(学校，颐养之家)
     */
    public String getName() {
        return name;
    }

    /**
     * 设置大类名称(学校，颐养之家)
     *
     * @param name 大类名称(学校，颐养之家)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }
}