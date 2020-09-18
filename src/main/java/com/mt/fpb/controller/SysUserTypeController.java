package com.mt.fpb.controller;

import com.github.pagehelper.PageHelper;
import com.mt.fpb.mapper.SysUserTypeMapper;
import com.mt.fpb.model.SysUserType;
import com.mt.fpb.model.dto.BaseQueryParams;
import com.mt.fpb.model.vo.CommonPage;
import com.mt.fpb.model.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@RequestMapping("userType")
@RestController
public class SysUserTypeController   {

    @Autowired
    private SysUserTypeMapper sysUserTypeMapper;

    /**
     * 添加
     *
     * @param sysUserType
     * @return
     */
    @PostMapping("add")
    public CommonResult add(@RequestBody SysUserType sysUserType) {
//        exTitle.setAddTime(new Date());
        sysUserTypeMapper.insert(sysUserType);
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

        List<SysUserType> list = sysUserTypeMapper.selectAll();

        return CommonResult.success(CommonPage.restPage(list));
    }



    /**
     * 修改
     *
     * @param sysUserType
     * @return
     */
    @PostMapping("update")
    public CommonResult update(@RequestBody SysUserType sysUserType) {
        if (StringUtils.isEmpty(sysUserType.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        Example example = new Example(SysUserType.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", sysUserType.getId());
        sysUserTypeMapper.updateByExampleSelective(sysUserType, example);
        return CommonResult.success(1);
    }

    /**
     * 根据ID获取
     *
     * @param sysUserType
     * @return
     */
//    @GetMapping("getById")
//    public CommonResult getById(SysUserType sysUserType) {
//        if (StringUtils.isEmpty(sysUserType.getId())) {
//            return CommonResult.fail(-1, "id不能为空");
//        }
//        SysUserType sysUserType1 = sysUserTypeMapper.selectOne(sysUserType);
//        return CommonResult.success(sysUserType1);
//    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public CommonResult delete(@PathVariable("id") String id) {
        sysUserTypeMapper.deleteByPrimaryKey(id);
        return CommonResult.success(1);
    }


    /**
     * 验证题目是否已经存在
     *
     * @param
     * @return
     */
//    @GetMapping("checkTitleData")
//    public CommonResult checkTitleData(SysUserType sysUserType) {
//
//        String titleName = exTitle.getTitleName(); // 题目名称
//
//        Example example = new Example(ExTitle.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("titleName", exTitle.getTitleName());
//        List<ExTitle> exTitles = exTitleMapper.selectByExample(example);
//        if(exTitles.size() > 0){ // >0   已存在此题目
//            return CommonResult.fail(-1,"已存在此题目");
//        }
//        return CommonResult.success(1);
//    }
}