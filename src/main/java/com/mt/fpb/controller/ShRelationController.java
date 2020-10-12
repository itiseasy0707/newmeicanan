package com.mt.fpb.controller;

import com.github.pagehelper.PageHelper;
import com.mt.fpb.mapper.ShRelationMapper;
import com.mt.fpb.model.ShRelation;
import com.mt.fpb.model.ShRelation;
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

/**
 * 家属家属信息(ShRelation)表控制层
 *
 * @author hf
 * @since 2020-10-12 13:36:36
 */@Api(description = "家属家属信息")
@RestController
@RequestMapping("shRelation")
public class ShRelationController {
    /**
     * 服务对象
     */
    @Autowired
    private ShRelationMapper relationMapper;

    /**
     * 查询所有家属
     * @return 所有家属
     */
    @ApiOperation("查询所有家属")
    @GetMapping("/list")
    public CommonResult list(BaseQueryParams queryParams){
        PageHelper.startPage(queryParams.getPage(),queryParams.getPageSize());
        List<ShRelation> list = relationMapper.selectAll();
        return CommonResult.success(CommonPage.restPage(list));
    }

    /**
     * 根据主键id查询家属信息
     * @param relation 主键实体
     * @return 返回单条家属对象
     */
    @ApiOperation("根据id查询家属信息")
    @GetMapping("/getById")
    public CommonResult getById(ShRelation relation){
        if (StringUtils.isEmpty(relation.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        ShRelation bt = relationMapper.selectOne(relation);
        return CommonResult.success(bt);
    }

    /**
     * 修改家属信息
     * @param relation 家属对象
     * @return 修改结果
     */
    @ApiOperation("修改家属信息")
    @PostMapping("/update")
    public CommonResult update(@RequestBody ShRelation relation){
        if (StringUtils.isEmpty(relation.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        Example example = new Example(ShRelation.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", relation.getId());
        relationMapper.updateByExample(relation, example);
        return CommonResult.success(1);
    }

    /**
     * 新增家属信息
     * @param relation 家属对象
     * @return 添加结果
     */
    @ApiOperation("新增家属信息")
    @PostMapping("/add")
    public CommonResult add(@RequestBody ShRelation relation){
        relationMapper.insert(relation);
        return CommonResult.success(1);
    }

    @ApiOperation("根据id删除家属信息")
    @DeleteMapping("/delete/{id}")
    public CommonResult delete(@PathVariable("id") String id) {
        if (StringUtils.isEmpty(id)) {
            return CommonResult.fail(-1, "id不能为空");
        }
        relationMapper.deleteByPrimaryKey(id);
        return CommonResult.success(1);
    }

}