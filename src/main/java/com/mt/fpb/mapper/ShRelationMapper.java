package com.mt.fpb.mapper;

import com.mt.fpb.common.config.MyMapper;
import com.mt.fpb.model.ShRelation;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * 老人家属信息(ShRelation)表数据库访问层
 *
 * @author hf
 * @since 2020-10-12 13:36:37
 */
@Repository
public interface ShRelationMapper extends MyMapper<ShRelation> {

}