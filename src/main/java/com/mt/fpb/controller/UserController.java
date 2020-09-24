package com.mt.fpb.controller;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mt.fpb.common.util.HttpUtils;
import com.mt.fpb.common.util.RedisUtil;
import com.mt.fpb.mapper.UserMapper;
import com.mt.fpb.model.User;
import com.mt.fpb.model.vo.CommonResult;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/wx")
public class UserController {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisUtil redis;

    /**
     * 小程序登录
     * @return
     */
    @GetMapping("login")
    public CommonResult login(String code, String session) throws Exception {
        String result = HttpUtils.get("https://api.weixin.qq.com/sns/jscode2session?appid=wx1e6ddb1c821803b1&secret=1466715dd9586d026105000cbac8541c&js_code=" + code + "&grant_type=authorization_code");
        System.err.println("login登录接口" + "---------------" + result);
        if (!StringUtils.isEmpty(result)) {
            JSONObject json = JSON.parseObject(result);
            if (json.get("errcode") != null) {
                return CommonResult.fail(-1, json.get("errmsg").toString());
            }
            //会话密钥
//            String sessionKey = json.getString("session_key");
            //openId
            String openId = json.getString("openid");
            Example example = new Example(User.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("openId", openId);
            User user = userMapper.selectOneByExample(example);
            UUID token = UUID.randomUUID();
            JSONObject object = new JSONObject();
            if (user == null) {
                //为空做新增操作
                String id = IdUtil.simpleUUID();
                User model = new User();
                model.setAddTime(new Date());
                model.setOpenId(openId);
                model.setId(id);
                userMapper.insert(model);
                redis.set(token.toString(), openId);
                object.put("token", token);
            } else {
                redis.set(token.toString(), openId);
                object.put("token", token);
            }
            return CommonResult.success(object);
        }
        return CommonResult.fail(-1, "登录失败");
    }

}
