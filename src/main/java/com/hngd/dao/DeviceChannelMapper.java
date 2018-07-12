package com.hngd.dao;

import com.hngd.model.DeviceChannel;
import com.hngd.model.DeviceChannelExample;
import java.util.List;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.ibatis.annotations.Param;

public interface DeviceChannelMapper {
    long countByExample(DeviceChannelExample example);

    int deleteByExample(DeviceChannelExample example);

    int deleteByPrimaryKey(String id);

    int insert(DeviceChannel record);

    int insertSelective(DeviceChannel record);

    List<DeviceChannel> selectByExample(DeviceChannelExample example);

    DeviceChannel selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DeviceChannel record, @Param("example") DeviceChannelExample example);

    int updateByExample(@Param("record") DeviceChannel record, @Param("example") DeviceChannelExample example);

    int updateByPrimaryKeySelective(DeviceChannel record);

    int updateByPrimaryKey(DeviceChannel record);
}