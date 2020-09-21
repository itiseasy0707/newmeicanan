package com.mt.fpb.controller;

import cn.hutool.core.util.IdUtil;
import com.mt.fpb.mapper.BtmdMapper;
import com.mt.fpb.model.Btmd;
import com.mt.fpb.model.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;
import java.util.List;


/**
 * 备胎门店管理
 */
@RestController
@RequestMapping("/btmdController")
public class BtmdController {

    @Autowired
    private BtmdMapper btmdMapper;

    /**
     * 查询所有门店
     * @return 所有门店
     */
    @GetMapping("/list")
    public CommonResult list(){
        List<Btmd> list = btmdMapper.selectAll();
        return CommonResult.success(CommonResult.success(list));
    }

    /**
     * 根据主键id查询门店信息
     * @param btmd 主键实体
     * @return 返回单条门店对象
     */
    @GetMapping("/getById")
    public CommonResult getById(Btmd btmd){
        if (StringUtils.isEmpty(btmd.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        Btmd bt = btmdMapper.selectOne(btmd);
        return CommonResult.success(CommonResult.success(bt) );
    }

    /**
     * 修改门店信息
     * @param btmd 门店对象
     * @return 修改结果
     */
    @PostMapping("/update")
    public CommonResult update(@RequestBody Btmd btmd){
        if (StringUtils.isEmpty(btmd.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        Example example = new Example(Btmd.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", btmd.getId());
        btmdMapper.updateByExample(btmd, example);
        return CommonResult.success(1);
    }

    /**
     * 新增门店信息
     * @param btmd 门店对象
     * @return 添加结果
     */
    @PostMapping("/add")
    public CommonResult add(@RequestBody Btmd btmd){
       //TODO 校验实体对象(非空)

        btmd.setId(IdUtil.simpleUUID());
        btmdMapper.insert(btmd);
        return CommonResult.success(1);
    }

    @DeleteMapping("/delete")
    public CommonResult delete(@RequestBody Btmd btmd) {
        if (StringUtils.isEmpty(btmd.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        btmdMapper.delete(btmd);
        return CommonResult.success(1);
    }
}
