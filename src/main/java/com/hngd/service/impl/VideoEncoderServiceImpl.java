package com.hngd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hngd.common.result.Result;
import com.hngd.dao.DeviceChannelMapper;
import com.hngd.dao.VideoEncoderInfoMapper;
import com.hngd.dao.VideoEncoderMapper;
import com.hngd.model.VideoEncoder;
import com.hngd.service.VideoEncoderService;

@Service
public class VideoEncoderServiceImpl implements VideoEncoderService {

	@Autowired
	private VideoEncoderMapper VideoEncoderDao;
	
	@Autowired
	private VideoEncoderInfoMapper VideoEncoderInfoDao;
	
	
	@Autowired
	private DeviceChannelMapper deviceChannelDao;


	@Override
	public Result<String> addVideoEncoder(VideoEncoder videoEncoder) {
		// TODO Auto-generated method stub
		return null;
	}
 
}
