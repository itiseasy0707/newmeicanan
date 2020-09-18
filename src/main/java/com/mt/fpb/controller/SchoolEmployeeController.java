package com.mt.fpb.controller;

import com.github.pagehelper.PageHelper;
import com.mt.fpb.common.util.DataUtil;
import com.mt.fpb.common.util.HintUtil;
import com.mt.fpb.mapper.SchoolEmployeeMapper;
import com.mt.fpb.mapper.SchoolMapper;
import com.mt.fpb.model.School;
import com.mt.fpb.model.SchoolEmployee;
import com.mt.fpb.model.dto.BaseQueryParams;
import com.mt.fpb.model.vo.CommonPage;
import com.mt.fpb.model.vo.CommonResult;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

/**
 *  学校人员信息
 */
@RestController
@RequestMapping("/schoolEmployee")
public class SchoolEmployeeController {

    @Resource
    private SchoolEmployeeMapper schoolEmployeeMapper;

    @Resource
    private DataUtil dataUtil;
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

        String userId = queryParams.getUserId();// 接收用户id
        String roleId = dataUtil.getRoleIdByUserId(userId);// 获取用户的角色id
        String roleType = dataUtil.getRoleTypeByRoleId(roleId);// 根据用户的角色id获取到该角色的角色类型
        if (roleType.equals("1")) { // 学校管理员   只能查看到自己学校的人员信息
            Example example = new Example(SchoolEmployee.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("userId", userId);
            List<SchoolEmployee> schoolEmployees = schoolEmployeeMapper.selectByExample(example);
            return CommonResult.success(CommonPage.restPage(schoolEmployees));
        } //系统管理员，可以查看所有的学校的人员信息
        List<SchoolEmployee> list = schoolEmployeeMapper.selectAll();
        return CommonResult.success(CommonPage.restPage(list));
    }

    /**
     * 添加
     *
     * @return
     */
    @PostMapping("add")
    public CommonResult add(@RequestBody SchoolEmployee schoolEmployee) {
//        if (StringUtils.isEmpty(area.getAreaName())) {
//            return CommonResult.fail(-1, "地区名称不能为空");
//        }
//        if (StringUtils.isEmpty(area.getAreaDesc())) {
//            return CommonResult.fail(-1, "地区描述不能为空");
//        }
        schoolEmployeeMapper.insert(schoolEmployee);
        return CommonResult.success(1);
    }
//
    /**
     * 修改
     *
     * @param schoolEmployee
     * @return
     */
    @PostMapping("update")
    public CommonResult update(@RequestBody SchoolEmployee schoolEmployee) {
        if (StringUtils.isEmpty(schoolEmployee.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        Example example = new Example(SchoolEmployee.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", schoolEmployee.getId());
        schoolEmployeeMapper.updateByExample(schoolEmployee, example);
        return CommonResult.success(1);
    }
//
    /**
     * 根据id获取
     *
     * @param schoolEmployee
     * @return
     */
    @GetMapping("getById")
    public CommonResult getById(SchoolEmployee schoolEmployee) {
        if (StringUtils.isEmpty(schoolEmployee.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        return CommonResult.success(schoolEmployeeMapper.selectOne(schoolEmployee));
    }


    /**
     * 删除
     *
     * @param schoolEmployee
     * @return
     */
//    @PostMapping("delete")
//    public CommonResult delete(@RequestBody SchoolEmployee schoolEmployee) {
//        if (StringUtils.isEmpty(schoolEmployee.getId())) {
//            return CommonResult.fail(-1, "id不能为空");
//        }
//        schoolEmployeeMapper.delete(schoolEmployee);
//        return CommonResult.success(1);
//    }


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public CommonResult delete(@PathVariable("id") String id) {
        int cnt =  schoolEmployeeMapper.deleteByPrimaryKey(id);
        return HintUtil.delete(cnt);
    }

//    /**
//     * 测试
//     *
//     * @param map
//     * @return
//     */
//    @PostMapping("getJson")
//    public CommonResult getJson(@RequestBody Map map) {
//        Map map1 = (Map) map.get("data");
//        List<Map> list = (List<Map>) map1.get("con");
//        for (int i = 0; i < list.size(); i++) {
//           String  email = (String) list.get(i).get("login_name");
//           if (email != null){
//               System.out.println(email);
//           }
//        }
//        return null;
//    }



}
