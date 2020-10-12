package com.mt.fpb.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.mt.fpb.model.MtApi;
import com.mt.fpb.mapper.MtApiMapper;
import com.mt.fpb.model.dto.BaseQueryParams;
import com.mt.fpb.model.vo.CommonPage;
import com.mt.fpb.model.vo.CommonResult;
import io.swagger.annotations.Api;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "告警推送接口")
@RestController
@RequestMapping("/mtApiController")
public class MtApiController {

    @Resource
    private MtApiMapper mtApiMapper;

    @PostMapping("/getData")
    public CommonResult getData(String data, String msgType){
        if(StringUtils.isEmpty(data)){
            return CommonResult.fail(-1,"data为空异常");
        }
        JSONObject jsonObject=new JSONObject();
        JSONObject result = JSONObject.parseObject(data);
        MtApi mtApi = new MtApi();
        mtApi.setAddress(result.get("address").toString());
        mtApi.setImei(result.get("imei").toString());
        mtApi.setAlarmtype(result.get("alarmType").toString());
        mtApi.setDevicename(result.get("deviceName").toString());
        mtApi.setLat(result.get("lat").toString());
        mtApi.setLng(result.get("lng").toString());
        mtApi.setAlarmtime(result.get("alarmTime").toString());
        mtApiMapper.insert(mtApi);
        return CommonResult.success(1);
    }

    @GetMapping("/list")
    public CommonResult list(BaseQueryParams queryParams){
        List<MtApi> list;
        if (!StringUtils.isEmpty(queryParams.getPageSize())){
            PageHelper.startPage(queryParams.getPage(),queryParams.getPageSize());
            list = mtApiMapper.selectAll();
            return CommonResult.success(CommonPage.restPage(list));
        }
        list=mtApiMapper.selectAll();
        return CommonResult.success(list);
    }
}
