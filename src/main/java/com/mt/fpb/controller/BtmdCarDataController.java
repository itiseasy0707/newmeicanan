package com.mt.fpb.controller;

import com.github.pagehelper.PageHelper;
import com.mt.fpb.mapper.AreaMapper;
import com.mt.fpb.mapper.BtmdCarDataMapper;
import com.mt.fpb.model.Area;
import com.mt.fpb.model.BtmdCarData;
import com.mt.fpb.model.dto.BaseQueryParams;
import com.mt.fpb.model.vo.CommonPage;
import com.mt.fpb.model.vo.CommonResult;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 *  备胎客户
 */
@RestController
@RequestMapping("/btmdCarData")
public class BtmdCarDataController {

    @Resource
    private BtmdCarDataMapper btmdCarDataMapper;


    /**
     *  列表
     *
     * @param queryParams
     * @return
     */
    @GetMapping("list")
    public CommonResult list(BaseQueryParams queryParams) {
        PageHelper.startPage(queryParams.getPage(), queryParams.getPageSize());

        List<BtmdCarData> list = btmdCarDataMapper.selectAll();
        return CommonResult.success(CommonPage.restPage(list));
    }

    /**
     * 添加
     *
     * @return
     */
    @PostMapping("add")
    public CommonResult add(@RequestBody BtmdCarData btmdCarData) {
//        if (StringUtils.isEmpty(area.getAreaName())) {
//            return CommonResult.fail(-1, "地区名称不能为空");
//        }
//        if (StringUtils.isEmpty(area.getAreaDesc())) {
//            return CommonResult.fail(-1, "地区描述不能为空");
//        }
        btmdCarDataMapper.insert(btmdCarData);
        return CommonResult.success(1);
    }

    /**
     * 修改
     *
     * @param btmdCarData
     * @return
     */
    @PostMapping("update")
    public CommonResult update(@RequestBody BtmdCarData btmdCarData) {
        if (StringUtils.isEmpty(btmdCarData.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        Example example = new Example(BtmdCarData.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", btmdCarData.getId());
        btmdCarDataMapper.updateByExample(btmdCarData, example);
        return CommonResult.success(1);
    }
//
    /**
     * 根据id获取
     *
     * @param btmdCarData
     * @return
     */
    @GetMapping("getById")
    public CommonResult getById(BtmdCarData btmdCarData) {
        if (StringUtils.isEmpty(btmdCarData.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        return CommonResult.success(btmdCarDataMapper.selectOne(btmdCarData));
    }


    /**
     * 删除
     *
     * @param btmdCarData
     * @return
     */
    @PostMapping("delete")
    public CommonResult delete(@RequestBody BtmdCarData btmdCarData) {
        if (StringUtils.isEmpty(btmdCarData.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        btmdCarDataMapper.delete(btmdCarData);
        return CommonResult.success(1);
    }






}
