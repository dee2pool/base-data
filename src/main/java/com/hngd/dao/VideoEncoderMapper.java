package com.hngd.dao;

import com.hngd.model.VideoEncoder;
import com.hngd.model.VideoEncoderExample;
import java.util.List;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.ibatis.annotations.Param;

public interface VideoEncoderMapper {
    long countByExample(VideoEncoderExample example);

    int deleteByExample(VideoEncoderExample example);

    int insert(VideoEncoder record);

    int insertSelective(VideoEncoder record);

    List<VideoEncoder> selectByExample(VideoEncoderExample example);

    int updateByExampleSelective(@Param("record") VideoEncoder record, @Param("example") VideoEncoderExample example);

    int updateByExample(@Param("record") VideoEncoder record, @Param("example") VideoEncoderExample example);
}