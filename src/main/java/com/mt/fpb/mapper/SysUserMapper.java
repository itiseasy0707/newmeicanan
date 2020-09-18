package com.mt.fpb.mapper;

import com.mt.fpb.common.config.MyMapper;
import com.mt.fpb.model.SysUser;
import com.mt.fpb.model.dto.BaseQueryParams;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface SysUserMapper extends MyMapper<SysUser> {

    List<Map<String, String>> list(String loginName);

    Map<String, String> getUserInfo(String userId);

    List<Map<String,String>> getUserMenu(String userId);

    /**
     * 根据用户id查询出角色id
     * @param userId
     * @return
     */
    String getRoleIdByUserId(@Param("userId") String userId);

    String getRoleTypeByRoleId(@Param("roleId")String roleId);
}