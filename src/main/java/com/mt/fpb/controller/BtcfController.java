package com.mt.fpb.controller;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.mt.fpb.mapper.BtmdLandryMapper;
import com.mt.fpb.mapper.BtmdMapper;
import com.mt.fpb.model.Btmd;
import com.mt.fpb.model.BtmdLandry;
import com.mt.fpb.model.Shop;
import com.mt.fpb.model.SysRole;
import com.mt.fpb.model.dto.BaseQueryParams;
import com.mt.fpb.model.vo.CommonPage;
import com.mt.fpb.model.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/btcf")
public class BtcfController {

    @Autowired
    private BtmdMapper btmdMapper;

    @Autowired
    private BtmdLandryMapper btmdLandryMapper;



    /**
     * 下拉  门店
     *
     * @param
     * @return
     */
    @GetMapping("select")
    public CommonResult select() {
        List<Btmd> list = btmdMapper.selectAll();
        return CommonResult.success(list);
    }

    /**
     *
     *
     * @return
     */
    @GetMapping("find")
    public CommonResult find(BtmdLandry btmdLandry) {

        String ownTime = null;


        int i = btmdLandryMapper.find(btmdLandry);  // 判断此车牌是否已经预约  >0 ==>已经预约
        if(i > 0){ // 此车牌号已经预约
            btmdLandry.setStatus("0"); // 没有洗车的
            ownTime = getOwnTime(btmdLandry);
            btmdLandry.setOwnTime(ownTime);
            int location = getOwnLocation(btmdLandry);
            int ownNumber = getOwnNumber(btmdLandry);
            String status = btmdLandryMapper.getOwnStatus(btmdLandry);
            JSONObject json = new JSONObject();
            json.put("location",location);
            json.put("ownNumber",ownNumber);
            json.put("status",status);
            return CommonResult.success(json);
        }


        if(ownTime == null){ // 今天没有来过洗车  可能之前洗过车
            return CommonResult.success(-1);
        }
            return CommonResult.success(-1);
    }



    /**
     * 添加
     *
     * @return
     */
    @PostMapping("add")
    public CommonResult add(@RequestBody BtmdLandry btmdLandry) {

        // 主键
        String id = IdUtil.simpleUUID();
        btmdLandry.setId(id);
        // add_time
       btmdLandry.setAddTime(new Date());

       // status
        btmdLandry.setStatus("0");

       btmdLandryMapper.insert(btmdLandry);
        String ownTime = getOwnTime(btmdLandry);
        btmdLandry.setOwnTime(ownTime);
        int location = getOwnLocation(btmdLandry);
        int ownNumber = getOwnNumber(btmdLandry);
        JSONObject json = new JSONObject();
        json.put("location",location);
        json.put("ownNumber",ownNumber);
        return CommonResult.success(json);
    }




    /**
     * 查询    需要等待的位数
     *
     * @return
     */
    public int getOwnLocation(BtmdLandry btmdLandry) {
        // 根据门店名称，未洗车  查询出前面还有多少位
        int location = btmdLandryMapper.getOwnLocation(btmdLandry);

        //获取 自己位置
//        location = 1 + location;
        return location;
    }

    /**
     * 查询 时间
     *
     * @return
     */
    public String getOwnTime(BtmdLandry btmdLandry) {
        // 根据门店名称，未洗车  查询出前面还有多少位
        String time = btmdLandryMapper.getOwnTime(btmdLandry);
        return time;
    }


    /**
     * 查询 排号  固定不变的
     *
     * @return
     */
    public int getOwnNumber(BtmdLandry btmdLandry) {
        // 根据门店名称，未洗车  查询出前面还有多少位
        String ownTime = getOwnTime(btmdLandry);
        btmdLandry.setOwnTime(ownTime);
        int ownNumber = btmdLandryMapper.getOwnNumber(btmdLandry);
        ownNumber +=1;
        return ownNumber;
    }

    /**
     * 后台查询     根据车牌号 ，时间段
     *
     * @return
     */
    @GetMapping("getCarList")
    public CommonResult getCarList(BtmdLandry btmdLandry) {
        PageHelper.startPage(btmdLandry.getPage(), btmdLandry.getPageSize());

        List<BtmdLandry> list = btmdLandryMapper.getCarList(btmdLandry);

        return CommonResult.success(CommonPage.restPage(list));
    }

    /**
     * 洗完车 改变状态值     根据车牌号 ，时间段
     *
     * @return
     */
    @PostMapping("updateCarStatus")
    public CommonResult updateCarStatus(@RequestBody BtmdLandry btmdLandry) {
        Example example = new Example(BtmdLandry.class);
        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("carNumber",btmdLandry.getCarNumber());
//        criteria.andEqualTo("type",btmdLandry.getType());
        criteria.andEqualTo("id",btmdLandry.getId());
        btmdLandry.setStatus("1"); // 洗完车  控制只查询未洗车记录
        btmdLandryMapper.updateByExampleSelective(btmdLandry,example);

        return CommonResult.success(1);
    }


    /**
     * 洗完车 改变状态值     根据车牌号 ，时间段
     *
     * @return
     */
    @PostMapping("updateCarStatus02")
    public CommonResult updateCarStatus02(@RequestBody BtmdLandry btmdLandry) {
        Example example = new Example(BtmdLandry.class);
        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("carNumber",btmdLandry.getCarNumber());
//        criteria.andEqualTo("type",btmdLandry.getType());
        criteria.andEqualTo("id",btmdLandry.getId());
        btmdLandry.setStatus("-1"); // 作废
        btmdLandryMapper.updateByExampleSelective(btmdLandry,example);

        return CommonResult.success(1);
    }

    /**
     * 洗完车 改变状态值     根据车牌号 ，时间段
     *
     * @return
     */
    @PostMapping("ceshi")
    public CommonResult temp02(@RequestBody BtmdLandry btmdLandry) {
        int a = 1;
        return CommonResult.success(a);
    }


}
