package com.mt.fpb.mapper;

import com.mt.fpb.common.config.MyMapper;
import com.mt.fpb.model.Shop;
import com.mt.fpb.model.Violation;

import java.util.List;
import java.util.Map;


public interface ViolationMapper extends MyMapper<Violation> {

    List<Map<String, String>> findAll(String ShopName);

    Map<String, String> findOne(Integer id);

    List<Map<String, String>> warning();

    List<Map<String, String>> warningList();

    List<Shop> expire();

    /**
     * 查询所有的违规记录数量
     * @return
     */
    int findAllVios();

    /**
     * 违规类型（每种违规类型的个数统计）
     * @return
     */
    List<Map> findAllVioTypeNum();

    /**
     *  ③四季度统计（每个季度的违规数量） 当前年的季度汇总
     * @return
     */
    List<Map> findQuarterNum();

    /**
     *  今日违规记录数量统计
     * @return
     */
    int findDayVioNum();
    /**
     *  ③月份统计   大屏
     * @return
     */
    List<Map> findMonthNum();
}