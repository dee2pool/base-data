package com.hngd.dao;

import com.hngd.model.VideoEncoderInfo;
import com.hngd.model.VideoEncoderInfoExample;
import java.util.List;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.ibatis.annotations.Param;

public interface VideoEncoderInfoMapper {
    long countByExample(VideoEncoderInfoExample example);

    int deleteByExample(VideoEncoderInfoExample example);

    int insert(VideoEncoderInfo record);

    int insertSelective(VideoEncoderInfo record);

    List<VideoEncoderInfo> selectByExample(VideoEncoderInfoExample example);

    int updateByExampleSelective(@Param("record") VideoEncoderInfo record, @Param("example") VideoEncoderInfoExample example);

    int updateByExample(@Param("record") VideoEncoderInfo record, @Param("example") VideoEncoderInfoExample example);
}