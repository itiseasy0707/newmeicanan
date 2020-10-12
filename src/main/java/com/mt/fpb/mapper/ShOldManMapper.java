package com.mt.fpb.mapper;

import com.mt.fpb.common.config.MyMapper;
import com.mt.fpb.model.ShOldMan;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;

/**
 * 水西颐养之家老人档案(ShOldMan)表数据库访问层
 *
 * @author hf
 * @since 2020-10-12 13:36:33
 */
@Repository
public interface ShOldManMapper extends MyMapper<ShOldMan> {

}