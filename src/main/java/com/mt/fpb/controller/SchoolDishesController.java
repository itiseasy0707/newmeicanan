package com.mt.fpb.controller;

import com.github.pagehelper.PageHelper;
import com.mt.fpb.common.util.DataUtil;
import com.mt.fpb.common.util.HintUtil;
import com.mt.fpb.mapper.SchoolDishesMapper;
import com.mt.fpb.mapper.SchoolMapper;
import com.mt.fpb.model.School;
import com.mt.fpb.model.SchoolDishes;
import com.mt.fpb.model.dto.BaseQueryParams;
import com.mt.fpb.model.vo.CommonPage;
import com.mt.fpb.model.vo.CommonResult;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *  学校菜品
 */
@RestController
@RequestMapping("/schoolDishes")
public class SchoolDishesController {

    @Resource
    private SchoolDishesMapper schoolDishesMapper;

    @Resource
    private DataUtil dataUtil;
    /**
     * 列表
     *
     * @param queryParams
     * @return
     */
    @GetMapping("list")
    public CommonResult list(BaseQueryParams queryParams) {

        PageHelper.startPage(queryParams.getPage(), queryParams.getPageSize());

        String userId = queryParams.getUserId();
        String roleId = dataUtil.getRoleIdByUserId(userId);
        String roleType = dataUtil.getRoleTypeByRoleId(roleId);
        if (roleType.equals("1")) { // 学校管理员   只能查看到自己学校的基本信息  根据角色不同，展示不同的信息
            Example example = new Example(SchoolDishes.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("userId", userId);
            List<SchoolDishes> schools = schoolDishesMapper.selectByExample(example);
            return CommonResult.success(CommonPage.restPage(schools));
        } //系统管理员，可以查看所有的学校信息
        List<SchoolDishes> list = schoolDishesMapper.selectAll();
        return CommonResult.success(CommonPage.restPage(list));
    }

    /**
     * 添加
     *
     * @return
     */
    @PostMapping("add")
    public CommonResult add(@RequestBody SchoolDishes schoolDishes) {
//        if (StringUtils.isEmpty(area.getAreaName())) {
//            return CommonResult.fail(-1, "地区名称不能为空");
//        }
//        if (StringUtils.isEmpty(area.getAreaDesc())) {
//            return CommonResult.fail(-1, "地区描述不能为空");
//        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH;mm:ss");
        String format = simpleDateFormat.format(new Date());
        schoolDishes.setAddTime(format);
        int cnt = schoolDishesMapper.insert(schoolDishes);
        return HintUtil.insert(cnt);
    }
//
    /**
     * 修改
     *
     * @param schoolDishes
     * @return
     */
    @PostMapping("update")
    public CommonResult update(@RequestBody SchoolDishes schoolDishes) {
        if (StringUtils.isEmpty(schoolDishes.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        Example example = new Example(SchoolDishes.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", schoolDishes.getId());
        int cnt = schoolDishesMapper.updateByExample(schoolDishes, example);
        return HintUtil.update(cnt);
    }
//
    /**
     * 根据id获取
     *
     * @param schoolDishes
     * @return
     */
    @GetMapping("getById")
    public CommonResult getById(SchoolDishes schoolDishes) {
        if (StringUtils.isEmpty(schoolDishes.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        return CommonResult.success(schoolDishesMapper.selectOne(schoolDishes));
    }


    /**
     * 删除
     *
     * @param schoolDishes
     * @return
     */
//    @PostMapping("delete")
//    public CommonResult delete(@RequestBody SchoolDishes schoolDishes) {
//        if (StringUtils.isEmpty(schoolDishes.getId())) {
//            return CommonResult.fail(-1, "id不能为空");
//        }
//        int cnt = schoolDishesMapper.delete(schoolDishes);
//        return HintUtil.delete(cnt);
//    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public CommonResult delete(@PathVariable("id") String id) {
        int cnt =  schoolDishesMapper.deleteByPrimaryKey(id);
        return HintUtil.delete(cnt);
    }





}
