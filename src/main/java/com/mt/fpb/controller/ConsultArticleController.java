package com.mt.fpb.controller;

import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.mt.fpb.common.util.FileUtil;
import com.mt.fpb.mapper.ConsultArticleMapper;
import com.mt.fpb.model.ConsultArticle;
import com.mt.fpb.model.ConsultArticle;
import com.mt.fpb.model.dto.BaseQueryParams;
import com.mt.fpb.model.vo.CommonPage;
import com.mt.fpb.model.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 咨询文章管理
 */
@RestController
@RequestMapping("/consultArticle")
public class ConsultArticleController {

    @Autowired
    private ConsultArticleMapper consultArticleMapper;


    /**
     * 文章列表
     * @param queryParams 分页参数
     * @return
     */
    @GetMapping("/list")
    public CommonResult list(BaseQueryParams queryParams){
        PageHelper.startPage(queryParams.getPage(),queryParams.getPageSize());
        List<ConsultArticle> list = consultArticleMapper.selectAll();
        return CommonResult.success(CommonPage.restPage(list));
    }

    /**
     * 查询单个文章
     * @param consultArticle
     * @return
     */
    @GetMapping("/getById")
    public CommonResult getById(ConsultArticle consultArticle){
        if (StringUtils.isEmpty(consultArticle.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        ConsultArticle ca = consultArticleMapper.selectOne(consultArticle);
        return CommonResult.success(ca);
    }

    /**
     * 修改文章
     * @param consultArticle
     * @return
     */
    @PostMapping("/update")
    public CommonResult update(@RequestBody ConsultArticle consultArticle){
        if (StringUtils.isEmpty(consultArticle.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        Example example = new Example(ConsultArticle.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", consultArticle.getId());
        consultArticleMapper.updateByExample(consultArticle, example);
        return CommonResult.success(1);
    }

    /**
     * 添加文章
     * @param consultArticle 文章实体数据
     * @return
     */
    @PostMapping("/add")
    public CommonResult add(@RequestBody ConsultArticle consultArticle){
        consultArticleMapper.insert(consultArticle);
        return CommonResult.success(1);
    }

    /**
     * 删除文章
     * @param consultArticle
     * @return
     */
    @DeleteMapping("/delete")
    public CommonResult delete(@RequestBody ConsultArticle consultArticle) {
        if (StringUtils.isEmpty(consultArticle.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        consultArticleMapper.delete(consultArticle);
        return CommonResult.success(1);
    }

}
