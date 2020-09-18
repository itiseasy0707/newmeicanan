package com.mt.fpb.mapper;

import com.mt.fpb.common.config.MyMapper;
import com.mt.fpb.model.EventContent;
import com.mt.fpb.model.EventType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventContentMapper extends MyMapper<EventContent> {

    /**
     * 查询出所有的违规内容
     * @return
     */
    List<EventContent> selectAllVio();

    List<EventContent> getByIdLargeId(String id);
}