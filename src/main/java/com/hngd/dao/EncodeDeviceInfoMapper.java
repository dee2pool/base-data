package com.hngd.dao;

import com.hngd.model.EncodeDeviceInfo;
import com.hngd.model.EncodeDeviceInfoExample;
import java.util.List;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.ibatis.annotations.Param;

public interface EncodeDeviceInfoMapper {
    long countByExample(EncodeDeviceInfoExample example);

    int deleteByExample(EncodeDeviceInfoExample example);

    int insert(EncodeDeviceInfo record);

    int insertSelective(EncodeDeviceInfo record);

    List<EncodeDeviceInfo> selectByExample(EncodeDeviceInfoExample example);

    int updateByExampleSelective(@Param("record") EncodeDeviceInfo record, @Param("example") EncodeDeviceInfoExample example);

    int updateByExample(@Param("record") EncodeDeviceInfo record, @Param("example") EncodeDeviceInfoExample example);
}