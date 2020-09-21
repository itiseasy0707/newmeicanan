package com.mt.fpb.controller;

import com.mt.fpb.mapper.BtmdMapper;
import com.mt.fpb.model.Btmd;
import com.mt.fpb.model.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.List;


/**
 * 备胎门店管理
 */
@RestController
//@CrossOrigin
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
        return CommonResult.success(CommonResult.success(list) );
    }

    /**
     * 根据主键id查询门店信息
     * @param id 主键
     * @return 返回单条门店对象
     */
    @GetMapping("/findById/{id}")
    public CommonResult findById(@PathVariable Serializable id){
        if (StringUtils.isEmpty(id)) {
            return CommonResult.fail(-1, "id不能为空");
        }
        Btmd btmd = btmdMapper.selectByPrimaryKey(id);
        return CommonResult.success(CommonResult.success(btmd) );
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
    @PostMapping("/insert")
    public CommonResult insert(@RequestBody Btmd btmd){
       //TODO 校验实体对象(非空)，数据库表主键id未自增

        btmdMapper.insert(btmd);
        return CommonResult.success(1);
    }

    @PostMapping("/del/{id}")
    public CommonResult delete(@PathVariable Serializable id) {
        if (StringUtils.isEmpty(id)) {
            return CommonResult.fail(-1, "id不能为空");
        }
        btmdMapper.deleteByPrimaryKey(id);
        return CommonResult.success(1);
    }
}
