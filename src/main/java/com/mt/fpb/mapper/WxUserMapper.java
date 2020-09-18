package com.mt.fpb.mapper;


import com.mt.fpb.common.config.MyMapper;
import com.mt.fpb.model.School;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WxUserMapper extends MyMapper<School> {
    /**
     * 微信小程序 列表
     * @return
     */
    List<School> selectAllSchool();
}