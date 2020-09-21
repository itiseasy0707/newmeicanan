package com.mt.fpb.model;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "consult_article")
public class ConsultArticle {
    @Id
    private Integer id;

    /**
     * 咨训名称
     */
    private String name;

    /**
     * 图片元数据
     */
    private String img;

    /**
     * 内容
     */
    private String contents;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取咨训名称
     *
     * @return name - 咨训名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置咨训名称
     *
     * @param name 咨训名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取图片元数据
     *
     * @return img - 图片元数据
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置图片元数据
     *
     * @param img 图片元数据
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 获取内容
     *
     * @return contents - 内容
     */
    public String getContents() {
        return contents;
    }

    /**
     * 设置内容
     *
     * @param contents 内容
     */
    public void setContents(String contents) {
        this.contents = contents;
    }
}