package com.mt.fpb.controller;

import cn.hutool.core.util.IdUtil;
import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageHelper;
import com.mt.fpb.common.listener.EasyExcelListener;
import com.mt.fpb.common.listener.ShHealthExcelListener;
import com.mt.fpb.common.util.MyExcelUtil;
import com.mt.fpb.mapper.ShHealthMapper;
import com.mt.fpb.model.BtmdCarData;
import com.mt.fpb.model.ShHealth;
import com.mt.fpb.model.dto.BaseQueryParams;
import com.mt.fpb.model.vo.CommonPage;
import com.mt.fpb.model.vo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 健康档案信息(ShHealth)表控制层
 *
 * @author hf
 * @since 2020-10-12 13:54:08
 */
@Api(description = "健康档案信息")
@RestController
@RequestMapping("shHealth")
public class ShHealthController {
    /**
     * 服务对象
     */
    @Autowired
    private ShHealthMapper healthMapper;

    /**
     * 查询所有健康档案信息
     * @return 所有健康档案信息
     */
//    @ApiOperation("所有健康档案信息")
//    @GetMapping("/list")
//    public CommonResult list(BaseQueryParams queryParams){
//        PageHelper.startPage(queryParams.getPage(),queryParams.getPageSize());
//        List<ShHealth> list = healthMapper.selectAll();
//        return CommonResult.success(CommonPage.restPage(list));
//    }

    /**
     * 根据老人id查询健康档案信息信息
     *
     * @param health 主键实体
     * @return 返回单条健康档案信息对象
     */
    @ApiOperation("根据老人身份证号获取健康信息")
    @GetMapping("/getById")
    public CommonResult getById(ShHealth health) {
        if (StringUtils.isEmpty(health.getIdCard())) {
            return CommonResult.fail(-1, "老人身份证号不能为空");
        }
        ShHealth bt = healthMapper.selectOne(health);
        return CommonResult.success(bt);
    }

    /**
     * 修改健康档案信息信息
     *
     * @param health 健康档案信息对象
     * @return 修改结果
     */
    @PostMapping("/update")
    @ApiOperation("根据主键id修改健康信息")
    public CommonResult update(@RequestBody ShHealth health) {
        if (StringUtils.isEmpty(health.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
//        Example example = new Example(ShHealth.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("id", health.getId());
//        healthMapper.updateByExample(health, example);
        healthMapper.updateByPrimaryKey(health);
        return CommonResult.success(1);
    }

    /**
     * 新增健康档案信息信息
     *
     * @param health 健康档案信息对象
     * @return 添加结果
     */
    @PostMapping("/add")
    @ApiOperation("新增健康档案信息信息")
    public CommonResult add(@RequestBody ShHealth health) {
        healthMapper.insert(health);
        return CommonResult.success(1);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除健康档案信息信息")
    public CommonResult delete(@PathVariable("id") String id) {
        if (StringUtils.isEmpty(id)) {
            return CommonResult.fail(-1, "id不能为空");
        }
        healthMapper.deleteByPrimaryKey(id);
        return CommonResult.success(1);
    }

    @PostMapping("/importExcel")
    @ApiOperation("健康档案信息导入")
    public CommonResult importExcel(MultipartFile file) {
        if (StringUtils.isEmpty(file)) {
            CommonResult.fail(-1, "文件不能为空!");
        }
        try {
            InputStream inputStream = file.getInputStream();
            EasyExcel.read(inputStream, ShHealth.class, new ShHealthExcelListener(healthMapper)).sheet().doRead();
            return CommonResult.success(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return CommonResult.fail(-1, "导入错误!");
    }
    @GetMapping("/excelExport")
    @ApiOperation("健康档案信息导出")
    public void excelExport(HttpServletResponse response) {
        List<ShHealth> list = healthMapper.selectAll();
        String[] headArr = {"bloodType","drugAllergy","expose","operation","trauma","bloodTransfusion","familyHistory","genetic","disability","heartRate","ecgConclusion","temperature","bloodPressureShrink","bloodPressureDiastole","bloodOxygenSaturation","pulseRate","perfusionIndex","idCard"};
        String[] headArrAlias = {"血型","药物过敏史","暴露史","手术史","外伤史","输血史","家族史","遗传史","残疾情况","心率","心电图结论","体温","血压-收缩压","血压-舒张压","血氧饱和度","脉率","灌注指数","身份证号"};
        try {
            MyExcelUtil.getExcel(response, list, "老人健康信息.xlsx",headArr, headArrAlias);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}