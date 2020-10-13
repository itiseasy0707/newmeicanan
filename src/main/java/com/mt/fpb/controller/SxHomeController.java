package com.mt.fpb.controller;

import com.github.pagehelper.PageHelper;
import com.mt.fpb.mapper.SxHomeMapper;
import com.mt.fpb.model.SxHome;
import com.mt.fpb.model.SxHome;
import com.mt.fpb.model.dto.BaseQueryParams;
import com.mt.fpb.model.vo.CommonPage;
import com.mt.fpb.model.vo.CommonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 水西颐养之家(SxHome)表控制层
 *
 * @author hf
 * @since 2020-10-13 10:46:02
 */
@RestController("/sxHome")

public class SxHomeController {
    /**
     * 服务对象
     */
    @Autowired
    private SxHomeMapper homeMapper;

    /**
     * 查询所有水西颐养之家
     * @return 所有水西颐养之家
     */
    @ApiOperation("所有水西颐养之家")
    @GetMapping("/list")
    public CommonResult list(BaseQueryParams queryParams){
        PageHelper.startPage(queryParams.getPage(),queryParams.getPageSize());
        List<SxHome> list = homeMapper.selectAll();
        return CommonResult.success(CommonPage.restPage(list));
    }

    /**
     * 根据主键id查询水西颐养之家信息
     * @param sxhome 主键实体
     * @return 返回单条水西颐养之家对象
     */
    @GetMapping("/getById")
    public CommonResult getById(SxHome sxhome){
        if (StringUtils.isEmpty(sxhome.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        SxHome bt = homeMapper.selectOne(sxhome);
        return CommonResult.success(bt);
    }

    /**
     * 修改水西颐养之家信息
     * @param sxhome 水西颐养之家对象
     * @return 修改结果
     */
    @PostMapping("/update")
    public CommonResult update(@RequestBody SxHome sxhome){
        if (StringUtils.isEmpty(sxhome.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        Example example = new Example(SxHome.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", sxhome.getId());
        homeMapper.updateByExample(sxhome, example);
        return CommonResult.success(1);
    }

    /**
     * 新增水西颐养之家信息
     * @param sxhome 水西颐养之家对象
     * @return 添加结果
     */
    @PostMapping("/add")
    public CommonResult add(@RequestBody SxHome sxhome){
        homeMapper.insert(sxhome);
        return CommonResult.success(1);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResult delete(@PathVariable("id") String id) {
        if (StringUtils.isEmpty(id)) {
            return CommonResult.fail(-1, "id不能为空");
        }
        homeMapper.deleteByPrimaryKey(id);
        return CommonResult.success(1);
    }

}