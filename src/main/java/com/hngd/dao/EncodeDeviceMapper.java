package com.hngd.dao;

import com.hngd.model.EncodeDevice;
import com.hngd.model.EncodeDeviceExample;
import java.util.List;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.ibatis.annotations.Param;

public interface EncodeDeviceMapper {
    long countByExample(EncodeDeviceExample example);

    int deleteByExample(EncodeDeviceExample example);

    int deleteByPrimaryKey(String code);

    int insert(EncodeDevice record);

    int insertSelective(EncodeDevice record);

    List<EncodeDevice> selectByExample(EncodeDeviceExample example);

    EncodeDevice selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") EncodeDevice record, @Param("example") EncodeDeviceExample example);

    int updateByExample(@Param("record") EncodeDevice record, @Param("example") EncodeDeviceExample example);

    int updateByPrimaryKeySelective(EncodeDevice record);

    int updateByPrimaryKey(EncodeDevice record);
}