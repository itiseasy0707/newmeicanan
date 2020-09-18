package com.mt.fpb.mapper;

import com.mt.fpb.common.config.MyMapper;
import com.mt.fpb.model.Shop;
import com.mt.fpb.model.dto.BaseQueryParams;

import java.util.List;
import java.util.Map;


public interface ShopMapper extends MyMapper<Shop> {

    List<Shop> shopGrade(Shop shop);

    List<Map<String, String>> scoreSummary();

    List<Map<String, String>> violationSummary();

    /**
     * 统计商家所有数量
     *
     * @return
     */
    int findAllShop();

    /**
     * 每个等级的商家个数展示
     * @return
     */
    List<Map> findGradeNum();

    /**
     * 分页查询 店铺
     * @return
     */
    List<Shop> findList(BaseQueryParams queryParams);
}