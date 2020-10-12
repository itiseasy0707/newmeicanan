package com.mt.fpb.common.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.mt.fpb.common.exception.GlobalException;
import com.mt.fpb.mapper.ShHealthMapper;
import com.mt.fpb.model.ShHealth;
import com.mt.fpb.model.vo.CommonResult;
import tk.mybatis.mapper.entity.Example;

public class ShHealthExcelListener extends AnalysisEventListener<ShHealth> {
    private ShHealthMapper mapper;

    public ShHealthExcelListener() {

    }

    public ShHealthExcelListener(ShHealthMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void invoke(ShHealth shHealth, AnalysisContext analysisContext) {
        //排查该老人健康信息是否存在
        //根据身份证号查询
        Example example = new Example(ShHealth.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("idCard", shHealth.getIdCard());
        //存在即返回
        if (mapper.selectCountByExample(example) > 0) {
//            throw new GlobalException("该身份证:"+shHealth.getIdCard()+"对应老人健康数据已存在,请重新核查",-1);
            return;
        }
        //添加
        mapper.insert(shHealth);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
