package com.mt.fpb.controller;

import com.github.pagehelper.PageHelper;
import com.mt.fpb.mapper.AreaMapper;
import com.mt.fpb.mapper.RoleTypeManageMapper;
import com.mt.fpb.model.Area;
import com.mt.fpb.model.RoleType;
import com.mt.fpb.model.dto.BaseQueryParams;
import com.mt.fpb.model.vo.CommonPage;
import com.mt.fpb.model.vo.CommonResult;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 *  角色类型管理
 */
@RestController
@RequestMapping("/roleType")
public class RoleTypeManageController {

    @Resource
    private RoleTypeManageMapper roleTypeManageMapper;


    /**
     * 列表
     *
     * @param queryParams
     * @return
     */
    @GetMapping("list")
    public CommonResult list(BaseQueryParams queryParams) {
        PageHelper.startPage(queryParams.getPage(), queryParams.getPageSize());

        List<RoleType> list = roleTypeManageMapper.selectAll();
        return CommonResult.success(CommonPage.restPage(list));
    }

    /**
     * 添加
     *
     * @return
     */
    @PostMapping("add")
    public CommonResult add(@RequestBody RoleType roleType) {
//        if (StringUtils.isEmpty(area.getAreaName())) {
//            return CommonResult.fail(-1, "地区名称不能为空");
//        }
//        if (StringUtils.isEmpty(area.getAreaDesc())) {
//            return CommonResult.fail(-1, "地区描述不能为空");
//        }
        roleTypeManageMapper.insert(roleType);
        return CommonResult.success(1);
    }
//
    /**
     * 修改
     *
     * @param roleType
     * @return
     */
    @PostMapping("update")
    public CommonResult update(@RequestBody RoleType roleType) {
        if (StringUtils.isEmpty(roleType.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        Example example = new Example(RoleType.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", roleType.getId());
        roleTypeManageMapper.updateByExample(roleType, example);
        return CommonResult.success(1);
    }
//
    /**
     * 根据id获取
     *
     * @param roleType
     * @return
     */
    @GetMapping("getById")
    public CommonResult getById(RoleType roleType) {
        if (StringUtils.isEmpty(roleType.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        return CommonResult.success(roleTypeManageMapper.selectOne(roleType));
    }


    /**
     * 删除
     *
     * @param roleType
     * @return
     */
    @PostMapping("delete")
    public CommonResult delete(@RequestBody RoleType roleType) {
        if (StringUtils.isEmpty(roleType.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        roleTypeManageMapper.delete(roleType);
        return CommonResult.success(1);
    }






}
