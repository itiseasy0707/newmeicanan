package com.mt.fpb.controller;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.github.pagehelper.PageHelper;
import com.mt.fpb.common.util.MyExcelUtil;
import com.mt.fpb.mapper.AreaMapper;
import com.mt.fpb.mapper.ShopMapper;
import com.mt.fpb.model.Shop;
import com.mt.fpb.model.Violation;
import com.mt.fpb.model.dto.BaseQueryParams;
import com.mt.fpb.model.vo.CommonPage;
import com.mt.fpb.model.vo.CommonResult;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Resource
    private ShopMapper shopMapper;

    /**
     * 列表
     *
     * @param queryParams
     * @return
     */
    @GetMapping("list")
    public CommonResult list(BaseQueryParams queryParams) {
        PageHelper.startPage(queryParams.getPage(), queryParams.getPageSize());
//        Example example = new Example(Shop.class);
//        Example.Criteria criteria = example.createCriteria();
//        if (!StringUtils.isEmpty(queryParams.getName())) {
//            criteria.andEqualTo("shopName", queryParams.getName());
//        }
//        List<Shop> list = shopMapper.selectByExample(example);
        List<Shop> list = shopMapper.findList(queryParams);
        return CommonResult.success(CommonPage.restPage(list));
    }

    /**
     * 添加
     *
     * @return
     */
    @PostMapping("add")
    public CommonResult add(@RequestBody Shop shop) {
        if (StringUtils.isEmpty(shop.getPhone())) {
            return CommonResult.fail(-1, "店铺电话不能为空");
        }
        if (StringUtils.isEmpty(shop.getShopName())) {
            return CommonResult.fail(-1, "店铺名称不能为空");
        }
        if (StringUtils.isEmpty(shop.getBusinessTime()) || StringUtils.isEmpty(shop.getQualifiedTime())) {
            return CommonResult.fail(-1, "请输入过期时间");
        }
        shop.setAddTime(new Date());
        shopMapper.insertUseGeneratedKeys(shop);
        return CommonResult.success(1);
    }

    /**
     * 修改
     *
     * @param shop
     * @return
     */
    @PostMapping("update")
    public CommonResult update(@RequestBody Shop shop) {
        if (StringUtils.isEmpty(shop.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        Example example = new Example(Shop.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", shop.getId());
        shopMapper.updateByExample(shop, example);
        return CommonResult.success(1);
    }

    /**
     * 根据id获取
     *
     * @param shop
     * @return
     */
    @GetMapping("getById")
    public CommonResult getById(Shop shop) {
        if (StringUtils.isEmpty(shop.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        return CommonResult.success(shopMapper.selectOne(shop));
    }

    /**
     * 店铺的评级汇总
     *
     * @param
     * @return
     */
    @GetMapping("shopGrade")
    public CommonResult shopGrade(Shop shop) {
        PageHelper.startPage(shop.getPage(), shop.getPageSize());
        List<Shop> list = shopMapper.shopGrade(shop);
        return CommonResult.success(CommonPage.restPage(list));
    }

    /**
     * 删除
     *
     * @param shop
     * @return
     */
    @PostMapping("delete")
    public CommonResult delete(@RequestBody Shop shop) {
        if (StringUtils.isEmpty(shop.getId())) {
            return CommonResult.fail(-1, "id不能为空");
        }
        shopMapper.delete(shop);
        return CommonResult.success(1);
    }

    /**
     * 查询所有店铺
     *
     * @return
     */
    @GetMapping("findAll")
    public CommonResult findAll() {
        return CommonResult.success(shopMapper.selectAll());
    }

    /**
     * 商铺导入
     *
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("import")
    public CommonResult importExcel(@RequestParam("file") MultipartFile file) throws Exception {
        // 读取excel文件内容
        ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
        if (reader.readAll().size() > 0) {  // 返回的是list<map>的数据
            List<Shop> list = init(reader.readAll());

            for (Shop model : list) {
                Example example = new Example(Shop.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("shopName", model.getShopName());
                Shop shop = shopMapper.selectOneByExample(example);
                if (!StringUtils.isEmpty(shop)) {
                    shopMapper.delete(shop);
                }
            }
            if (list.size() > 0) {
                shopMapper.insertList(list);

            }

        }
        return CommonResult.success(1);
    }

    /**
     * 初始化商铺信息
     *
     * @param readAll
     * @return
     */
    private List<Shop> init(List<Map<String, Object>> readAll) {
        List<Shop> list = new ArrayList<>();
        for (Map<String, Object> map : readAll) {
            Shop shop = new Shop();
            if (map.get("店铺名称")!=null && !StringUtils.isEmpty(map.get("店铺名称").toString())) {
                shop.setShopName(map.get("店铺名称").toString());
            }
            if (map.get("店铺地址")!=null&& !StringUtils.isEmpty(map.get("店铺地址").toString())) {
                shop.setAddress(map.get("店铺地址").toString());
            }
            if (map.get("店铺地区")!=null&&!StringUtils.isEmpty(map.get("店铺地区").toString())) {
                shop.setAreaId(map.get("店铺地区").toString());
            }
            if (map.get("商家联系方式")!=null&&!StringUtils.isEmpty(map.get("商家联系方式").toString())) {
                shop.setPhone(map.get("商家联系方式").toString());
            }
            if (map.get("联系人")!=null&&!StringUtils.isEmpty(map.get("联系人").toString())) {
                shop.setContact(map.get("联系人").toString());
            }
            if (map.get("商家简介")!=null&&!StringUtils.isEmpty(map.get("商家简介").toString())) {
                shop.setShopDesc(map.get("商家简介").toString());
            }
            if (map.get("经度")!=null&&!StringUtils.isEmpty(map.get("经度").toString())) {
                shop.setLng(map.get("经度").toString());
            }
            if (map.get("纬度")!=null&&!StringUtils.isEmpty(map.get("纬度").toString())) {
                shop.setLat(map.get("纬度").toString());
            }
            if (map.get("许可证到期时间")!=null&&!StringUtils.isEmpty(map.get("许可证到期时间").toString())) {
                shop.setBusinessTime((Date) map.get("许可证到期时间"));
            }
            if (map.get("上岗证到期时间")!=null&&!StringUtils.isEmpty(map.get("上岗证到期时间").toString())) {
                shop.setQualifiedTime((Date)(map.get("上岗证到期时间")));
            }
            // 默认值
            shop.setAddTime(new Date());
            shop.setStatus(0);
            list.add(shop);
        }
        return list;
    }

    /**
     * 商铺评分汇总接口
     *
     * @return
     */
    @GetMapping("scoreSummary")
    public CommonResult scoreSummary(BaseQueryParams queryParams) {
        PageHelper.startPage(queryParams.getPage(), queryParams.getPageSize());
        List<Map<String, String>> list = shopMapper.scoreSummary();
        return CommonResult.success(CommonPage.restPage(list));
    }

    /**
     * 违规类型汇总接口
     *
     * @return
     */
    @GetMapping("violationSummary")
    public CommonResult violationSummary(BaseQueryParams queryParams) {
        PageHelper.startPage(queryParams.getPage(), queryParams.getPageSize());
        List<Map<String, String>> list = shopMapper.violationSummary();
        return CommonResult.success(CommonPage.restPage(list));
    }

    /**
     * 导出
     *
     * @return
     */
    @GetMapping("testExport")
    public void export(HttpServletResponse response) throws Exception {
        String[] headArr = {"shopName", "deductions", "rate"};
        String[] headArrAlice = {"商铺名称", "累计扣分", "评级判定"};
        List<Shop> list = shopMapper.shopGrade(null);
        MyExcelUtil.getExcel(response, list, "扣分评级.xlsx", headArr, headArrAlice);
    }


    /**
     * 导出
     *
     * @return
     */
    @GetMapping("export")
    public void shopExport(HttpServletResponse response) throws Exception {

        String[] headArr = {"id", "shopName", "address","areaName" ,"contact", "phone","businessTime","qualifiedTime"};
        String[] headArrAlice = {"序号", "店铺名称", "店铺地址","店铺地区", "商家联系人", "商家联系方式","食品经营许可证到期时间","上岗证到期时间"};

        List<Shop> list = shopMapper.findList(null);
        MyExcelUtil.getExcel(response, list, "店铺基本信息.xlsx", headArr, headArrAlice);
    }


    /**
     * 商家总数统计
     *
     * @return
     */
    @GetMapping("findAllShop")
    public CommonResult findAllShop() {
        List<Shop> list = shopMapper.selectAll();
        if (list.size() > 0) {
            return CommonResult.success(list.size());
        }
        return CommonResult.success(null);

    }


        /**
         *   统计  每个等级的商家个数展示
         */
        @GetMapping("findGradeNum")
        public CommonResult findGradeNum(){
          List<Map>  list =  shopMapper.findGradeNum();
            return CommonResult.success(list);
    }




}
