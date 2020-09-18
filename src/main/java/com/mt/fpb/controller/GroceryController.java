package com.mt.fpb.controller;

import com.github.pagehelper.PageHelper;
import com.mt.fpb.mapper.EventContentMapper;
import com.mt.fpb.mapper.EventTypeMapper;
import com.mt.fpb.model.EventContent;
import com.mt.fpb.model.EventType;
import com.mt.fpb.model.Shop;
import com.mt.fpb.model.dto.BaseQueryParams;
import com.mt.fpb.model.vo.CommonPage;
import com.mt.fpb.model.vo.CommonResult;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.awt.*;
import java.util.List;

/**
 *  以后此类做成字典项的
 */
@RestController
@RequestMapping("/grocery")
public class GroceryController {
    @Resource
    private EventTypeMapper eventTypeMapper;

    @Resource
    private EventContentMapper eventContentMapper;

    /**
     * 列表
     *
     * @param queryParams
     * @return
     */
    @GetMapping("large/list")
    public CommonResult list(BaseQueryParams queryParams) {
        PageHelper.startPage(queryParams.getPage(), queryParams.getPageSize());

        List<EventType> list = eventTypeMapper.selectAll();
        return CommonResult.success(CommonPage.restPage(list));
    }

    /**
     * 添加
     *
     * @return
     */
    @PostMapping("large/add")
    public CommonResult add(@RequestBody EventType eventType) {
        if (StringUtils.isEmpty(eventType.getEventName())) {
            return CommonResult.fail(-1, "大类名称不能为空");
        }
        eventTypeMapper.insert(eventType);
        return CommonResult.success(1);
    }
//
    /**
     * 修改
     *
     * @param eventType
     * @return
     */
    @PostMapping("large/update")
    public CommonResult update(@RequestBody EventType eventType) {
        if (StringUtils.isEmpty(eventType.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        Example example = new Example(Shop.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", eventType.getId());
        eventTypeMapper.updateByExample(eventType, example);
        return CommonResult.success(1);
    }
//
    /**
     * 根据id获取
     *
     * @param eventType
     * @return
     */
    @GetMapping("large/getById")
    public CommonResult getById(EventType eventType) {
        if (StringUtils.isEmpty(eventType.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        return CommonResult.success(eventTypeMapper.selectOne(eventType));
    }


    /**
     * 删除
     *
     * @param eventType
     * @return
     */
    @PostMapping("large/delete")
    public CommonResult delete(@RequestBody EventType eventType) {
        if (StringUtils.isEmpty(eventType.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        eventTypeMapper.delete(eventType);
        return CommonResult.success(1);
    }


    /**
     * 大类下拉
     *
     * @return
     */
    @GetMapping("large/findAllLarge")
    public CommonResult findAllLarge() {
        List<EventType>  list = eventTypeMapper.selectAll();
        return CommonResult.success(list);
    }



    /**
     *   小类 列表
     *
     * @param queryParams
     * @return
     */
    @GetMapping("little/list")
    public CommonResult list02(BaseQueryParams queryParams) {
        PageHelper.startPage(queryParams.getPage(), queryParams.getPageSize());

        List<EventContent> list = eventContentMapper.selectAllVio();
        return CommonResult.success(CommonPage.restPage(list));
    }

    /**
     * 添加
     *
     * @return
     */
    @PostMapping("little/add")
    public CommonResult add02(@RequestBody EventContent eventContent) {
        if (StringUtils.isEmpty(eventContent.getContentName())) {
            return CommonResult.fail(-1, "小类名称不能为空");
        }
        if (StringUtils.isEmpty(eventContent.getDeductions())) {
            return CommonResult.fail(-1, "分数不能为空");
        }
        if (StringUtils.isEmpty(eventContent.getPid())) {
            return CommonResult.fail(-1, "大类名称不能为空");
        }
        eventContentMapper.insert(eventContent);
        return CommonResult.success(1);
    }
//
    /**
     * 修改
     *
     * @param eventContent
     * @return
     */
    @PostMapping("little/update")
    public CommonResult update02(@RequestBody EventContent eventContent) {
        if (StringUtils.isEmpty(eventContent.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        Example example = new Example(Shop.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", eventContent.getId());
        eventContentMapper.updateByExample(eventContent, example);
        return CommonResult.success(1);
    }
//
    /**
     * 根据id获取
     *
     * @param eventContent
     * @return
     */
    @GetMapping("little/getById")
    public CommonResult getById02(EventContent eventContent) {
        if (StringUtils.isEmpty(eventContent.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        return CommonResult.success(eventContentMapper.selectOne(eventContent));
    }


    /**
     * 删除
     *
     * @param eventContent
     * @return
     */
    @PostMapping("little/delete")
    public CommonResult delete02(@RequestBody EventContent eventContent) {
        if (StringUtils.isEmpty(eventContent.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        eventContentMapper.delete(eventContent);
        return CommonResult.success(1);
    }



    /**
     * 根据id获取 到所有的小类信息
     *
     * @param id
     * @return
     */
    @GetMapping("getByIdLargeId")
    public CommonResult getByIdLargeId(String id) {
        List<EventContent> list = eventContentMapper.getByIdLargeId(id);

        return CommonResult.success(list);
    }

}
