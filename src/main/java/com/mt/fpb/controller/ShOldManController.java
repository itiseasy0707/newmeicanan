package com.mt.fpb.controller;

import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.mt.fpb.mapper.ShOldManMapper;
import com.mt.fpb.model.ShOldMan;
import com.mt.fpb.model.ShOldMan;
import com.mt.fpb.model.dto.BaseQueryParams;
import com.mt.fpb.model.vo.CommonPage;
import com.mt.fpb.model.vo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 水西颐养之家老人档案(ShOldMan)表控制层
 *
 * @author hf
 * @since 2020-10-12 13:36:32
 */
@Api(description = "老人信息层")
@RestController
@RequestMapping("shOldMan")
public class ShOldManController {
    /**
     * 服务对象
     */
    @Autowired
    private ShOldManMapper oldManMapper;


    /**
     * 查询所有老人
     * @return 所有老人
     */
    @ApiOperation("查询所有老人")
    @GetMapping("/list")
    public CommonResult list(BaseQueryParams queryParams){
        PageHelper.startPage(queryParams.getPage(),queryParams.getPageSize());
        List<ShOldMan> list = oldManMapper.selectAll();
        return CommonResult.success(CommonPage.restPage(list));
    }

    /**
     * 根据主键id查询老人信息
     * @param oldMan 主键实体
     * @return 返回单条老人对象
     */
    @ApiOperation("根据id查询老人信息")
    @GetMapping("/getById")
    public CommonResult getById(ShOldMan oldMan){
        if (StringUtils.isEmpty(oldMan.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        ShOldMan bt = oldManMapper.selectOne(oldMan);
        return CommonResult.success(bt);
    }

    /**
     * 修改老人信息
     * @param oldMan 老人对象
     * @return 修改结果
     */
    @ApiOperation("修改老人信息")
    @PostMapping("/update")
    public CommonResult update(@RequestBody ShOldMan oldMan){
        if (StringUtils.isEmpty(oldMan.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        Example example = new Example(ShOldMan.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", oldMan.getId());
        oldManMapper.updateByExample(oldMan, example);
        return CommonResult.success(1);
    }

    /**
     * 新增老人信息
     * @param oldMan 老人对象
     * @return 添加结果
     */
    @ApiOperation("新增老人信息")
    @PostMapping("/add")
    public CommonResult add(@RequestBody ShOldMan oldMan){
        oldManMapper.insert(oldMan);
        return CommonResult.success(1);
    }

    @ApiOperation("根据id删除老人信息")
    @DeleteMapping("/delete/{id}")
    public CommonResult delete(@PathVariable("id") String id) {
        if (StringUtils.isEmpty(id)) {
            return CommonResult.fail(-1, "id不能为空");
        }
        oldManMapper.deleteByPrimaryKey(id);
        return CommonResult.success(1);
    }
}