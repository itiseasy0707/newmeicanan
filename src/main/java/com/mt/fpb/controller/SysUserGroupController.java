package com.mt.fpb.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.mt.fpb.mapper.SysUserGroupMapper;
import com.mt.fpb.model.SysUserGroup;
import com.mt.fpb.model.dto.BaseQueryParams;
import com.mt.fpb.model.vo.CommonPage;
import com.mt.fpb.model.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("group")
@RestController
public class SysUserGroupController  {

    @Autowired
    private SysUserGroupMapper sysUserGroupMapper;


    /**
     * 下拉  类型
     */
    @GetMapping("/pullDown")
    public CommonResult pullDown(@RequestBody SysUserGroup sysUserGroup) {
        List<SysUserGroup> sysUserGroups = sysUserGroupMapper.selectAll();
        return CommonResult.success(sysUserGroups);
    }


    /**
     * 添加
     *
     * @param sysUserGroup
     * @return
     */
    @PostMapping("add")
    public CommonResult add(@RequestBody SysUserGroup sysUserGroup) {
//        sysUserGroup.setAddTime(new Date());
        sysUserGroupMapper.insert(sysUserGroup);
        return CommonResult.success(1);
    }



    /**
     * 列表
     *
     * @param baseQueryParams
     * @return
     */
    @GetMapping("list")
    public CommonResult list(BaseQueryParams baseQueryParams) {
        PageHelper.startPage(baseQueryParams.getPage(), baseQueryParams.getPageSize());


        Example example = new Example(SysUserGroup.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andLike("titleName","%"+ baseQueryParams.getName() +"%");
        List<SysUserGroup> list = sysUserGroupMapper.selectAll();

        return CommonResult.success(CommonPage.restPage(list));
    }



    /**
     * 修改
     *
     * @param sysUserGroup
     * @return
     */
    @PostMapping("update")
    public CommonResult update(@RequestBody SysUserGroup sysUserGroup) {
        if (StringUtils.isEmpty(sysUserGroup.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        Example example = new Example(SysUserGroup.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", sysUserGroup.getId());
        sysUserGroupMapper.updateByExampleSelective(sysUserGroup, example);
        return CommonResult.success(1);
    }

    /**
     * 根据ID获取  详情
     *
     * @param sysUserGroup
     * @return
     */
//    @GetMapping("getById")
//    public CommonResult getById(SysUserGroup sysUserGroup) {
//        if (StringUtils.isEmpty(sysUserGroup.getId())) {
//            return CommonResult.fail(-1, "id不能为空");
//        }
//        SysUserGroup userGroup = sysUserGroupMapper.selectOne(sysUserGroup);
//        return CommonResult.success(userGroup);
//    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public CommonResult delete(@PathVariable("id") String id) {
        sysUserGroupMapper.deleteByPrimaryKey(id);
        return CommonResult.success(1);
    }


    /**
     * 验证用户组是否已经存在
     *
     * @param
     * @return
     */
//    @GetMapping("checkGroupData")
//    public CommonResult checkTitleData(SysUserGroup sysUserGroup) {
//
//        return CommonResult.success(1);
//    }
//


}