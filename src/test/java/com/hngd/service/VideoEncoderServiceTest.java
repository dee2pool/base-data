package com.hngd.service;

import static org.mockito.Mockito.doThrow;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.hngd.common.exception.DBErrorException;
import com.hngd.dao.DeviceChannelMapper;
import com.hngd.model.VideoEncoder;
import com.hngd.service.impl.VideoEncoderServiceImpl;
import com.hngd.vmns.data.HnvmnsBaseDataApplication;
@SpringBootTest(classes=HnvmnsBaseDataApplication.class)
@RunWith(SpringRunner.class)
public class VideoEncoderServiceTest {

	@SpyBean
	private VideoEncoderService videoEncoderService;
	
	@MockBean
	DeviceChannelMapper deviceChannelDao;
	 
	@Test
	public void testAddVideoEncoder(){
		Mockito.when(deviceChannelDao.insertSelective(null)).thenReturn(0);
		VideoEncoder v=new VideoEncoder();
		v.setChannelCount(1);
		v.setIpAddress("192.168.0.156");
		v.setLoginName("admin");
		v.setLastModifyTime(new Date());
		v.setLoginPassword("12345");
		v.setName("测试");
		v.setOrgCode("00000000000000000000");
		v.setStreamPort(1234);
		v.setTypeCode("132");
		v.setVendorId("xxx");
		videoEncoderService.addVideoEncoder(v);
	}
	
}
