package com.mt.fpb.controller;

import com.github.pagehelper.PageHelper;
import com.mt.fpb.mapper.AreaMapper;
import com.mt.fpb.mapper.EventContentMapper;
import com.mt.fpb.mapper.EventTypeMapper;
import com.mt.fpb.model.Area;
import com.mt.fpb.model.EventContent;
import com.mt.fpb.model.EventType;
import com.mt.fpb.model.Shop;
import com.mt.fpb.model.dto.BaseQueryParams;
import com.mt.fpb.model.vo.CommonPage;
import com.mt.fpb.model.vo.CommonResult;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 *  以后此类做成字典项的
 */
@RestController
@RequestMapping("/area")
public class AreaController {

    @Resource
    private AreaMapper areaMapper;


    /**
     * 列表
     *
     * @param queryParams
     * @return
     */
    @GetMapping("list")
    public CommonResult list(BaseQueryParams queryParams) {
        PageHelper.startPage(queryParams.getPage(), queryParams.getPageSize());

        List<Area> list = areaMapper.selectAll();
        return CommonResult.success(CommonPage.restPage(list));
    }

    /**
     * 添加
     *
     * @return
     */
    @PostMapping("add")
    public CommonResult add(@RequestBody Area area) {
        if (StringUtils.isEmpty(area.getAreaName())) {
            return CommonResult.fail(-1, "地区名称不能为空");
        }
        if (StringUtils.isEmpty(area.getAreaDesc())) {
            return CommonResult.fail(-1, "地区描述不能为空");
        }
        areaMapper.insert(area);
        return CommonResult.success(1);
    }
//
    /**
     * 修改
     *
     * @param area
     * @return
     */
    @PostMapping("update")
    public CommonResult update(@RequestBody Area area) {
        if (StringUtils.isEmpty(area.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        Example example = new Example(Area.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", area.getId());
        areaMapper.updateByExample(area, example);
        return CommonResult.success(1);
    }
//
    /**
     * 根据id获取
     *
     * @param area
     * @return
     */
    @GetMapping("getById")
    public CommonResult getById(Area area) {
        if (StringUtils.isEmpty(area.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        return CommonResult.success(areaMapper.selectOne(area));
    }


    /**
     * 删除
     *
     * @param area
     * @return
     */
    @PostMapping("delete")
    public CommonResult delete(@RequestBody Area area) {
        if (StringUtils.isEmpty(area.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        areaMapper.delete(area);
        return CommonResult.success(1);
    }






}
