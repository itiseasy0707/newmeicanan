package com.mt.fpb.mapper;

import com.mt.fpb.model.KsInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * 矿山基本信息表(KsInfo)表数据库访问层
 *
 * @author hf
 * @since 2020-09-27 09:43:42
 */
@Repository
public interface KsInfoMapper extends Mapper<KsInfo> {

}