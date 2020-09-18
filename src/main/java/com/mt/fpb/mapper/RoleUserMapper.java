package com.mt.fpb.mapper;

import com.mt.fpb.common.config.MyMapper;
import com.mt.fpb.model.RoleUser;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleUserMapper extends MyMapper<RoleUser> {

}