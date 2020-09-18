package com.mt.fpb.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "event_content")
public class EventContent {
    /**
     * 自增id
     */
    @Id
    private Integer id;

    /**
     * 内容名称
     */
    @Column(name = "content_name")
    private String contentName;

    /**
     * 分值
     */
    private String deductions;

    @Transient
    private String eventName;
    /**
     * 关联事件类型表id
     */
    private Integer pid;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 状态
     */
    private Integer status;

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
     * 获取内容名称
     *
     * @return content_name - 内容名称
     */
    public String getContentName() {
        return contentName;
    }

    /**
     * 设置内容名称
     *
     * @param contentName 内容名称
     */
    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public String getDeductions() {
        return deductions;
    }

    public void setDeductions(String deductions) {
        this.deductions = deductions;
    }

    /**
     * 获取关联事件类型表id
     *
     * @return pid - 关联事件类型表id
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置关联事件类型表id
     *
     * @param pid 关联事件类型表id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
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

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}