package com.mt.fpb.mapper;

import com.mt.fpb.common.config.MyMapper;
import com.mt.fpb.model.BtmdLandry;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BtmdLandryMapper extends MyMapper<BtmdLandry> {

    int selectNums(@Param("statusTmep") String statusTmep);

    int getOwnLocation(BtmdLandry btmdLandry);

    List<BtmdLandry> getCarList(BtmdLandry btmdLandry);

    int find(BtmdLandry btmdLandry);

    String getOwnTime(BtmdLandry btmdLandry);

    int getOwnNumber(BtmdLandry btmdLandry);

    String getOwnStatus(BtmdLandry btmdLandry);
}