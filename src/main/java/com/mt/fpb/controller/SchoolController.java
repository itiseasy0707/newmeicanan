package com.mt.fpb.controller;

import com.github.pagehelper.PageHelper;
import com.mt.fpb.common.util.DataUtil;
import com.mt.fpb.common.util.DateUtil;
import com.mt.fpb.mapper.SchoolDishesMapper;
import com.mt.fpb.mapper.SchoolEmployeeMapper;
import com.mt.fpb.mapper.SchoolMapper;
import com.mt.fpb.model.School;
import com.mt.fpb.model.SchoolDishes;
import com.mt.fpb.model.SchoolEmployee;
import com.mt.fpb.model.dto.BaseQueryParams;
import com.mt.fpb.model.vo.CommonPage;
import com.mt.fpb.model.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 以后此类做成字典项的
 */
@RestController
@RequestMapping("/school")
public class SchoolController {

    @Resource
    private SchoolMapper schoolMapper;

    @Resource
    private DataUtil dataUtil;
    @Resource
    private SchoolEmployeeMapper schoolEmployeeMapper;
    @Resource
    private SchoolDishesMapper schoolDishesMapper;

//    DataUtil dataUtil = DataUtil.getInstance();

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
        if (roleType.equals("1")) { // 学校管理员   只能查看到自己学校的基本信息
            Example example = new Example(School.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("userId", userId);
            List<School> schools = schoolMapper.selectByExample(example);
            return CommonResult.success(CommonPage.restPage(schools));
        } //系统管理员，可以查看所有的学校信息
        Example example = new Example(School.class);
        Example.Criteria criteria = example.createCriteria();
        if (queryParams.getName() != null) {
            criteria.andLike("name", "%" + queryParams.getName() + "%");
        }
        List<School> list = schoolMapper.selectByExample(example);
        return CommonResult.success(CommonPage.restPage(list));
    }

    /**
     * 添加
     *
     * @return
     */
    @PostMapping("add")
    public CommonResult add(@RequestBody School school) {
//        if (StringUtils.isEmpty(area.getAreaName())) {
//            return CommonResult.fail(-1, "地区名称不能为空");
//        }
//        if (StringUtils.isEmpty(area.getAreaDesc())) {
//            return CommonResult.fail(-1, "地区描述不能为空");
//        }
        schoolMapper.insert(school);
        return CommonResult.success(1);
    }
//

    /**
     * 修改
     *
     * @param school
     * @return
     */
    @PostMapping("update")
    public CommonResult update(@RequestBody School school) {
        if (StringUtils.isEmpty(school.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        Example example = new Example(School.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", school.getId());
        schoolMapper.updateByExampleSelective(school, example);
        return CommonResult.success(1);
    }
//

    /**
     * 根据id获取
     *
     * @param school
     * @return
     */
    @GetMapping("getById")
    public CommonResult getById(School school) {
        if (StringUtils.isEmpty(school.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }

        return CommonResult.success(schoolMapper.selectOne(school));
    }

    /**
     *
     * @param school
     * @return
     */
    @GetMapping("getByUserId")
    public CommonResult getByUserId(School school) {
        if (StringUtils.isEmpty(school.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        if (StringUtils.isEmpty(school.getUserId())) {
            return CommonResult.fail(-1, "用户id不能为空");
        }
        school = schoolMapper.selectOne(school);
        Example example = new Example(SchoolEmployee.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", school.getUserId());
        List<SchoolEmployee> list = schoolEmployeeMapper.selectByExample(example);
        if (list.size() > 0) {
            school.setSchoolEmployeeList(list);
        }
        //查询当天学校菜单
        Example examples = new Example(SchoolDishes.class);
        Example.Criteria criterias = examples.createCriteria();
        criterias.andEqualTo("userId", school.getUserId());
        criterias.andLike("addTime", "%"+DateUtil.getCurrentDate("yyyy-MM-dd")+"%");
        List<SchoolDishes> dishesList = schoolDishesMapper.selectByExample(examples);
        if (list.size() > 0) {
            school.setSchoolDishesList(dishesList);
        }
        return CommonResult.success(school);
    }


    /**
     * 删除
     *
     * @param school
     * @return
     */
    @PostMapping("delete")
    public CommonResult delete(@RequestBody School school) {
        if (StringUtils.isEmpty(school.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        schoolMapper.delete(school);
        return CommonResult.success(1);
    }


}
