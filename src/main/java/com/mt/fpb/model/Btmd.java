package com.mt.fpb.model;

import javax.persistence.Id;

public class Btmd {
    /**
     * 主键id
     */
    @Id
    private String id;

    /**
     * 名店名称
     */
    private String name;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取名店名称
     *
     * @return name - 名店名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名店名称
     *
     * @param name 名店名称
     */
    public void setName(String name) {
        this.name = name;
    }
}