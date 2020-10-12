package com.mt.fpb.controller;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.mt.fpb.mapper.KsInfoMapper;
import com.mt.fpb.model.Btmd;
import com.mt.fpb.model.KsInfo;
import com.mt.fpb.model.KsInfo;
import com.mt.fpb.model.dto.BaseQueryParams;
import com.mt.fpb.model.vo.CommonPage;
import com.mt.fpb.model.vo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * 矿山基本信息表(KsInfo)表控制层
 *
 * @author hf
 * @since 2020-09-27 09:43:40
 */
@RestController
@RequestMapping("/ksInfoController")
@Api("矿山信息控制层")
public class KsInfoController {
    /**
     * 服务对象
     */
    @Autowired
    private KsInfoMapper ksInfoMapper;


    @GetMapping("/list")
    public CommonResult list(BaseQueryParams queryParams){
        PageHelper.startPage(queryParams.getPage(),queryParams.getPageSize());
        List<KsInfo> list = ksInfoMapper.selectAll();
        return CommonResult.success(CommonPage.restPage(list));
    }

    /**
     * 根据主键id查询矿山信息
     * @param ksInfo 主键实体
     * @return 返回单条矿山对象
     */
    @GetMapping("/getById")
    public CommonResult getById(KsInfo ksInfo){
        if (StringUtils.isEmpty(ksInfo.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        KsInfo bt = ksInfoMapper.selectOne(ksInfo);
        return CommonResult.success(bt);
    }

    /**
     * 修改矿山信息
     * @param ksInfo 矿山对象
     * @return 修改结果
     */
    @PostMapping("/update")
    public CommonResult update(@RequestBody KsInfo ksInfo){
        if (StringUtils.isEmpty(ksInfo.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        Example example = new Example(KsInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", ksInfo.getId());
        ksInfoMapper.updateByExample(ksInfo, example);
        return CommonResult.success(1);
    }

    /**
     * 新增矿山信息
     * @param ksInfo 矿山对象
     * @return 添加结果
     */
    @PostMapping("/add")
    public CommonResult add(@RequestBody KsInfo ksInfo){
        ksInfoMapper.insert(ksInfo);
        return CommonResult.success(1);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResult delete(@PathVariable("id") String id) {
        if (StringUtils.isEmpty(id)) {
            return CommonResult.fail(-1, "id不能为空");
        }
        ksInfoMapper.deleteByPrimaryKey(id);
        return CommonResult.success(1);
    }
}