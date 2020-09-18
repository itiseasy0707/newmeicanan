package com.mt.fpb.controller;

import com.github.pagehelper.PageHelper;
import com.mt.fpb.common.util.MyExcelUtil;
import com.mt.fpb.mapper.ViolationMapper;
import com.mt.fpb.model.Shop;
import com.mt.fpb.model.Violation;
import com.mt.fpb.model.dto.BaseQueryParams;
import com.mt.fpb.model.vo.CommonPage;
import com.mt.fpb.model.vo.CommonResult;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/violation")
public class ViolationController {

    @Resource
    private ViolationMapper violationMapper;

    /**
     * 列表
     *
     * @param queryParams
     * @return
     */
    @GetMapping("list")
    public CommonResult list(BaseQueryParams queryParams) {
        PageHelper.startPage(queryParams.getPage(), queryParams.getPageSize());
        return CommonResult.success(CommonPage.restPage(violationMapper.findAll(queryParams.getShopName())));
    }

    /**
     * 添加
     *
     * @param violation
     * @return
     */
    @PostMapping("add")
    public CommonResult add(@RequestBody Violation violation) {
        if (StringUtils.isEmpty(violation.getShopId())) {
            return CommonResult.fail(-1, "店铺id不能为空");
        }
        if (StringUtils.isEmpty(violation.getVioDesc())) {
            return CommonResult.fail(-1, "描述不能为空");
        }
        violation.setAddTime(new Date());
        violationMapper.insertUseGeneratedKeys(violation);
        return CommonResult.success(1);
    }

    /**
     * 修改
     *
     * @param violation
     * @return
     */
    @PostMapping("update")
    public CommonResult update(@RequestBody Violation violation) {
        if (StringUtils.isEmpty(violation.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        Example example = new Example(Violation.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", violation.getId());
        violationMapper.updateByExample(violation, example);
        return CommonResult.success(1);
    }

    /**
     * 删除
     *
     * @param violation
     * @return
     */
    @PostMapping("delete")
    public CommonResult delete(@RequestBody Violation violation) {
        if (StringUtils.isEmpty(violation.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        violationMapper.delete(violation);
        return CommonResult.success(1);
    }

    /**
     * 根据ID获取信息
     *
     * @param violation
     * @return
     */
    @GetMapping("getById")
    public CommonResult getById(Violation violation) {
        if (StringUtils.isEmpty(violation.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        return CommonResult.success(violationMapper.findOne(violation.getId()));
    }

    /**
     * 导出
     *
     * @return
     */
    @GetMapping("export")
    public void export(HttpServletResponse response) throws Exception {
        String[] headArr = {"id", "shopName", "vioDesc", "addTime", "deductions"};
        String[] headArrAlice = {"序号", "店铺名称", "违规描述", "违规时间", "所扣分值"};
        List<Map<String, String>> list = violationMapper.findAll(null);
        MyExcelUtil.getExcel(response, list, "违规记录.xlsx", headArr, headArrAlice);
    }

    /**
     * 次数预警
     *
     * @return
     */
    @GetMapping("warning")
    public CommonResult warning(BaseQueryParams queryParams) {
        PageHelper.startPage(queryParams.getPage(),queryParams.getPageSize());
        return CommonResult.success(CommonPage.restPage((violationMapper.warning())));
    }

    /**
     * 次数预警list
     *
     * @return
     */
    @GetMapping("warningList")
    public CommonResult warningList(BaseQueryParams queryParams) {
        PageHelper.startPage(queryParams.getPage(),queryParams.getPageSize());
        return CommonResult.success(CommonPage.restPage((violationMapper.warningList())));
    }

    /**
     * 时间预警
     *
     * @return
     */
    @GetMapping("expire")
    public CommonResult expire(BaseQueryParams queryParams) {
        PageHelper.startPage(queryParams.getPage(),queryParams.getPageSize());
        return CommonResult.success(CommonPage.restPage((violationMapper.expire())));

    }

    /**
     * 时间预警导出
     *
     * @return
     */
    @GetMapping("expireExport")
    public void expireExport(HttpServletResponse response) throws Exception {
        String[] headArr = {"id", "shopName", "address", "contact", "phone","businessTime","qualifiedTime"};
        String[] headArrAlice = {"序号", "店铺名称", "店铺地址", "商家联系人", "商家联系方式","食品经营许可证到期时间","上岗证到期时间"};
        List<Shop> list = violationMapper.expire();
        MyExcelUtil.getExcel(response, list, "证件即将过期.xlsx", headArr, headArrAlice);
    }


    /**
     * 违规总数统计
     *
     * @return
     */
    @GetMapping("findAllVios")
    public CommonResult findAllVios() {
        List<Violation> list = violationMapper.selectAll();
        if (list.size() > 0) {
            return CommonResult.success(list.size());
        }
        return CommonResult.success(null);


    }

    /**
     *  违规类型（每种违规类型的个数统计）
     * @return
     */
    @GetMapping("/findAllVioTypeNum")
    public CommonResult findAllVioTypeNum(){
        List<Map> list =  violationMapper.findAllVioTypeNum();
        return CommonResult.success(list);
    }

    /**
     * 四季度统计（每个季度的违规数量） 当前年的季度汇总
     * @return
     */
    @GetMapping("/findQuarterNum")
    public CommonResult findQuarterNum(){
        List<Map> list =  violationMapper.findQuarterNum();
        return CommonResult.success(list);
    }

    /**
     * 今日违规记录数量统计
     * @return
     */
    @GetMapping("/findDayVioNum")
    public CommonResult findDayVioNum(){
        int nums =  violationMapper.findDayVioNum();
        return CommonResult.success(nums);
    }



    public static void main(String[] args) {
        int i,j;
        for(i = 2;i<100;i++){
            for(j = 2;j<=(i/j);j++)
                if((i%j == 0)) break;
            if(j>(i/j))
                System.out.println(i+"是质数");
        }
    }
}
