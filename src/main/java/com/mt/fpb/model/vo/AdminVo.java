package com.mt.fpb.model.vo;

import com.mt.fpb.model.Admin;
import lombok.Data;

/**
 * @author g
 * @date 2020-02-11 16:30
 */
@Data
public class AdminVo extends Admin {
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
