package com.mt.fpb.controller;

import com.github.pagehelper.PageHelper;
import com.mt.fpb.mapper.*;
import com.mt.fpb.model.Area;
import com.mt.fpb.model.School;
import com.mt.fpb.model.SchoolDishes;
import com.mt.fpb.model.SchoolEmployee;
import com.mt.fpb.model.dto.BaseQueryParams;
import com.mt.fpb.model.vo.CommonPage;
import com.mt.fpb.model.vo.CommonResult;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 *  微信小程序接口
 */
@RestController
@RequestMapping("/wx")
public class WxUserController {

    @Resource
    private WxUserMapper wxUserMapper;


    @Resource
    private SchoolDishesMapper schoolDishesMapper;


    @Resource
    private SchoolEmployeeMapper schoolEmployeeMapper;


    @Resource
    private SchoolMapper schoolMapper;


    /**
     * 学校列表
     *
     * @return
     */
    @GetMapping("list")
    public CommonResult list(BaseQueryParams queryParams) {
        PageHelper.startPage(queryParams.getPage(), queryParams.getPageSize());
        List<School> list = wxUserMapper.selectAllSchool();
        return CommonResult.success(CommonPage.restPage(list));
    }

    /**
     * 根据id获取  视频信息
     *
     * @param schoolEmployee
     * @return
     */
    @GetMapping("getEmployeeById")
    public CommonResult getEmployeeById(SchoolEmployee schoolEmployee) {
        if (StringUtils.isEmpty(schoolEmployee.getUserId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        return CommonResult.success(schoolEmployeeMapper.selectOne(schoolEmployee));
    }



    /**
     * 根据id获取  菜单信息
     *
     * @param schoolDishes
     * @return
     */
    @GetMapping("getDishById")
    public CommonResult getDishById(SchoolDishes schoolDishes) {
        if (StringUtils.isEmpty(schoolDishes.getUserId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        return CommonResult.success(schoolDishesMapper.selectOne(schoolDishes));
    }
}
