package com.mt.fpb.common.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mt.fpb.mapper.SysRoleMapper;
import com.mt.fpb.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 获取用户角色信息
 */
@Component
public class DataUtil {


    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

//    private static final DataUtil INSTANCE = new DataUtil();

    /**
     * 私有化构造器
     */
//    private DataUtil(){
//
//    }

//    public static DataUtil getInstance(){
//        return INSTANCE;
//    }

    /**
     *  根据用户id查询出角色id
     * @param userId 用户id
     * @return
     */
    public  String getRoleIdByUserId(String userId){ // 根据用户id查询出角色id
        String roleId  = sysUserMapper.getRoleIdByUserId(userId);
        if(roleId != null){ // 不为空
            return roleId;
        }
        return  "此用户的角色不存在";
    }


    /**
     *  根据角色id查询出角色类型  0-系统管理员  1-学校用户
     * @param roleId 角色id
     * @return
     */
    public String getRoleTypeByRoleId(String roleId){ // 根据用户id查询出角色id
        String roleType  = sysUserMapper.getRoleTypeByRoleId(roleId);
        if(roleType != null){ // 不为空
            return roleType;
        }
        return  "此用户的角色类型不存在";
    }

    /**
     * 获取txt文件中的josn数据 ，并实现输出指定数据
     * @param file
     */
    public static void readStudentTxt(File file,File dest) {
        try {

            StringBuffer requestBuffer = new StringBuffer("");
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
            OutputStreamWriter osr = new OutputStreamWriter(new FileOutputStream(dest), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            BufferedWriter bw = new BufferedWriter(osr);
            StringBuffer resposeBuffer = new StringBuffer("");
            String lineTxt = null;
            while ((lineTxt = br.readLine()) != null) {
              resposeBuffer.append("\r\n"+lineTxt);
            }

            JSONObject jsonObject = JSONObject.parseObject(resposeBuffer.toString());
           Map map =  ((Map)jsonObject.get("data"));
            List<Map> list = (List<Map>)map.get("con");
            for (int i = 0; i < list.size(); i++) {
                String email = (String)list.get(i).get("email");
                requestBuffer.append("\r\n"+email);
//                System.out.println("这是第"+i+"个====>"+email);
            }
            // 写入到文件中  (输出到文件中)
            osr.write(requestBuffer.toString());


            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File file = new File("E:\\mtkj\\zhengshi\\choujiang\\src\\main\\resources\\新建文本文档 (2).txt");
        File dest = new File("E:\\mtkj\\zhengshi\\choujiang\\src\\main\\resources\\新建文本文档 (3).txt");
        readStudentTxt(file,dest);
    }


}
