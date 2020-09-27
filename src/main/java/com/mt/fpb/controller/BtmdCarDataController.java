package com.mt.fpb.controller;

import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageHelper;
import com.mt.fpb.common.listener.EasyExcelListener;
import com.mt.fpb.common.util.EasyExcelUtils;
import com.mt.fpb.common.util.MyExcelUtil;
import com.mt.fpb.mapper.BtmdCarDataMapper;
import com.mt.fpb.model.BtmdCarData;
import com.mt.fpb.model.dto.BaseQueryParams;
import com.mt.fpb.model.vo.CommonPage;
import com.mt.fpb.model.vo.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 *  备胎客户
 */
@RestController
@RequestMapping("/btmdCarData")
public class BtmdCarDataController {

    @Resource
    private BtmdCarDataMapper btmdCarDataMapper;
    @Value("${system.upload.filePath}")
    private String uploadUrl;

    /**
     *  列表
     *
     * @param queryParams
     * @return
     */
    @GetMapping("list")
    public CommonResult list(BaseQueryParams queryParams,BtmdCarData btmdCarData) {
        PageHelper.startPage(queryParams.getPage(), queryParams.getPageSize());
        Example example = new Example(BtmdCarData.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("name", "%"+btmdCarData.getName()+"%");
        List<BtmdCarData> list = btmdCarDataMapper.selectByExample(example);
        System.out.println(list);
        return CommonResult.success(CommonPage.restPage(list));
    }

    /**
     * 添加
     *
     * @return
     */
    @PostMapping("add")
    public CommonResult add(@RequestBody BtmdCarData btmdCarData) {
//        if (StringUtils.isEmpty(area.getAreaName())) {
//            return CommonResult.fail(-1, "地区名称不能为空");
//        }
//        if (StringUtils.isEmpty(area.getAreaDesc())) {
//            return CommonResult.fail(-1, "地区描述不能为空");
//        }
        btmdCarDataMapper.insert(btmdCarData);
        return CommonResult.success(1);
    }

    /**
     * 修改
     *
     * @param btmdCarData
     * @return
     */
    @PostMapping("update")
    public CommonResult update(@RequestBody BtmdCarData btmdCarData) {
        if (StringUtils.isEmpty(btmdCarData.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        Example example = new Example(BtmdCarData.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", btmdCarData.getId());
        btmdCarDataMapper.updateByExample(btmdCarData, example);
        return CommonResult.success(1);
    }
//
    /**
     * 根据id获取
     *
     * @param btmdCarData
     * @return
     */
    @GetMapping("getById")
    public CommonResult getById(BtmdCarData btmdCarData) {
        if (StringUtils.isEmpty(btmdCarData.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        return CommonResult.success(btmdCarDataMapper.selectOne(btmdCarData));
    }


    /**
     * 删除
     *
     * @param
     * @return
     */
    @DeleteMapping("delete/{id}")
    public CommonResult delete(@PathVariable("id") String id) {
        if (StringUtils.isEmpty(id)) {
            return CommonResult.fail(-1, "id不能为空");
        }
        btmdCarDataMapper.deleteByPrimaryKey(id);
        return CommonResult.success(1);
    }


    @PostMapping("/excelImport")
    public CommonResult excelImport(MultipartFile file){
        if (StringUtils.isEmpty(file)){
            CommonResult.fail(-1,"文件不能为空!");
        }
        try {
            InputStream inputStream = file.getInputStream();
            EasyExcel.read(inputStream,BtmdCarData.class,new EasyExcelListener(btmdCarDataMapper)).sheet().doRead();
            return CommonResult.success(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return CommonResult.fail(-1, "导入错误!");
    }

    @GetMapping("/excelExport")
    public void excelExport(HttpServletResponse response) {
        List<BtmdCarData> list = btmdCarDataMapper.selectAll();
        String[] headArr = {"name","carNumber","carShape","phone","birthday","carShelf","licenseNumber"};
        String[] headArrAlias = {"用户名称","车牌号","车型","电话号码","生日","车架号","行驶证号"};

        try {
            MyExcelUtil.getExcel(response, list, "备胎车服客户信息.xlsx",headArr, headArrAlias);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
