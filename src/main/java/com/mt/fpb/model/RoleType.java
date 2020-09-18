package com.mt.fpb.model;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "role_type")
public class RoleType {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 名称
     */
    private String name;

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
}
