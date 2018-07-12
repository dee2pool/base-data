package com.hngd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hngd.dao.DeviceChannelMapper;
import com.hngd.dao.EncodeDeviceInfoMapper;
import com.hngd.dao.EncodeDeviceMapper;
import com.hngd.service.EncodeDeviceService;

@Service
public class EncodeDeviceServiceImpl implements EncodeDeviceService {

	@Autowired
	private EncodeDeviceMapper encodeDeviceDao;
	
	@Autowired
	private EncodeDeviceInfoMapper encodeDeviceInfoDao;
	
	
	@Autowired
	private DeviceChannelMapper deviceChannelDao;
 
}
