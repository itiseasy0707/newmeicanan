package com.mt.fpb.controller;


import com.github.pagehelper.PageHelper;
import com.mt.fpb.mapper.ShopMapper;
import com.mt.fpb.mapper.ViolationMapper;
import com.mt.fpb.model.Shop;
import com.mt.fpb.model.dto.BaseQueryParams;
import com.mt.fpb.model.vo.CommonPage;
import com.mt.fpb.model.vo.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bigScreen")
public class BigScreen {

    @Resource
    private ShopMapper shopMapper;

    @Resource
    private ViolationMapper violationMapper;


    /**
     *  商铺   地图展示
     *
     * @param queryParams
     * @return
     */
    @GetMapping("shopList")
    public CommonResult shopList(BaseQueryParams queryParams) {
        List<Shop> list = shopMapper.findList(queryParams);
        return CommonResult.success(list);
    }

    /**
     * 列表
     * @param queryParams
     * @return
     */
    @GetMapping("vioList")
    public CommonResult vioList(BaseQueryParams queryParams) {
        List<Map<String, String>> list = violationMapper.findAll(queryParams.getShopName());
        return CommonResult.success(list);
    }


    /**
     * 月份统计（每个月的违规数量） 当前年的月汇总  大屏
     * @return
     */
    @GetMapping("/findMonthNum")
    public CommonResult findMonthNum(){
        List<Map> list =  violationMapper.findMonthNum();
        return CommonResult.success(list);
    }


}
