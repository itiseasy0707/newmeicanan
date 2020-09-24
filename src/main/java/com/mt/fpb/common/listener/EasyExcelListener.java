package com.mt.fpb.common.listener;


import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.mt.fpb.model.BtmdCarData;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.common.BaseMapper;

public class EasyExcelListener extends AnalysisEventListener<BtmdCarData> {

    private BaseMapper mapper;

    public EasyExcelListener() {

    }
    public EasyExcelListener(BaseMapper mapper) {
        this.mapper=mapper;
    }


    @Override
    public void invoke(BtmdCarData btmdCarData, AnalysisContext analysisContext) {
        //TODO 根据需求将客户信息筛选后添加

        //添加
        mapper.insert(btmdCarData);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
