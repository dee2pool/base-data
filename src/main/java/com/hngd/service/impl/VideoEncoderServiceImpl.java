package com.hngd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.druid.util.StringUtils;
import com.hngd.common.dao.CodeMapper;
import com.hngd.common.error.ErrorCode;
import com.hngd.common.exception.DBErrorException;
import com.hngd.common.result.Result;
import com.hngd.common.result.Results;
import com.hngd.common.service.CodeUtils;
import com.hngd.common.service.CodeKey;
import com.hngd.common.util.SqlUtils;
import com.hngd.common.util.UuidUtils;
import com.hngd.common.web.page.PageHelper;
import com.hngd.common.web.page.PagedData;
import com.hngd.dao.DeviceChannelMapper;
import com.hngd.dao.OperateInfoViewMapper;
import com.hngd.dao.VideoEncoderInfoMapper;
import com.hngd.dao.VideoEncoderMapper;
import com.hngd.model.DeviceChannel;
import com.hngd.model.VideoEncoder;
import com.hngd.model.VideoEncoderExample;
import com.hngd.model.VideoEncoderInfo;
import com.hngd.model.VideoEncoderInfoExample;
import com.hngd.service.VideoEncoderService;

@Service
public class VideoEncoderServiceImpl implements VideoEncoderService {

	@Autowired
	private VideoEncoderMapper videoEncoderDao;
	@Autowired
	private CodeMapper codeDao;
	
	@Autowired
	private VideoEncoderInfoMapper videoEncoderInfoDao;
	
	
	@Autowired
	private DeviceChannelMapper deviceChannelDao;
 
	private OperateInfoViewMapper oivDao;

	@Transactional(isolation=Isolation.SERIALIZABLE)
	@Override
	public Result<String> addVideoEncoder(@RequestParam("videoEncoder")VideoEncoder videoEncoder) {
		String orgCode=videoEncoder.getOrgCode();
		String resTypeCode=videoEncoder.getTypeCode();
		
		String resName=videoEncoder.getName();
		if(isResNameExist(resName)){
			return Results.newFailResult(ErrorCode.NAME_EXIST, "设备名称已存在");
		}
		String ipAddress=videoEncoder.getIpAddress();
		if(isIpAddressExist(ipAddress)){
			return Results.newFailResult(ErrorCode.DEVICE_IP_EXIST, "设备IP地址已被占用");
		}
		
		String resCode=CodeUtils.generateResCode(orgCode, resTypeCode, this, CodeKey.encodeDevice);
		if(resCode==null){
			return Results.newFailResult(ErrorCode.SERVER_INTERNAL_ERROR, "系统生成设备编码错误");
		}
		videoEncoder.setCode(resCode);
		if(videoEncoderDao.insertSelective(videoEncoder)>0){
			addChannelInfo(resCode,videoEncoder.getChannelCount());
			return Results.newSuccessResult(resCode);
		}else{
		    return Results.newFailResult(ErrorCode.DB_ERROR, "设备数据写入数据库失败");
		}
	}
    private boolean isIpAddressExist(String ipAddress) {
		if(StringUtils.isEmpty(ipAddress)){
			return true;
		}
		VideoEncoderExample example=new VideoEncoderExample();
		example.createCriteria().andIpAddressEqualTo(ipAddress);
		List<VideoEncoder> list=videoEncoderDao.selectByExample(example);
		return list!=null && list.size()>0;
	}
	private boolean isResNameExist(String resName) {
		if(StringUtils.isEmpty(resName)){
			return true;
		}
		VideoEncoderExample example=new VideoEncoderExample();
		example.createCriteria().andNameEqualTo(resName);
		List<VideoEncoder> list=videoEncoderDao.selectByExample(example);
		return list!=null && list.size()>0;
	}
	public static final String DEFAULT_CHANNEL_NAME_PREFIX="通道";
    
    @Transactional(propagation=Propagation.REQUIRED)
	public void addChannelInfo(String resCode, Integer channelCount) {
		for(int i=0;i<channelCount;i++){
			DeviceChannel channel=new DeviceChannel();
			channel.setParentDeviceCode(resCode);
			String id=UuidUtils.uuid();
			channel.setId(id);
			Short orderNo=(short)i;
			String name=DEFAULT_CHANNEL_NAME_PREFIX+orderNo;
			channel.setName(name);
			channel.setOrderNo(orderNo);
			if(deviceChannelDao.insertSelective(channel)<=0){
				throw new DBErrorException("通道数据保存到数据库失败");
			}
		}
		
	}

	@Override
	public Integer deleteVideoEncoderByCode(String videoEncoderCode) {
		if(StringUtils.isEmpty(videoEncoderCode)){
			return ErrorCode.INVALID_PARAMETER;
		}
		if(videoEncoderDao.deleteByPrimaryKey(videoEncoderCode)>0){
			return ErrorCode.NO_ERROR;
		}else{
		    return ErrorCode.TARGET_NOT_FOUND;
		}
	}

	@Override
	public Result<PagedData<VideoEncoderInfo>> getVideoEncoderList(Integer pageNo, Integer pageSize, String resName,
			String ipAddress) {
		VideoEncoderInfoExample example=new VideoEncoderInfoExample();
		VideoEncoderInfoExample.Criteria criteria=example.createCriteria();
		
		if(!StringUtils.isEmpty(ipAddress)){
			criteria.andIpAddressLike(SqlUtils.wrapLike(ipAddress));
		}
		if(!StringUtils.isEmpty(resName)){
			criteria.andNameLike(SqlUtils.wrapLike(resName));
		}
		PagedData<VideoEncoderInfo> videoEncoderDevices=PageHelper.startPage(pageNo, pageSize);
		List<VideoEncoderInfo> list=videoEncoderInfoDao.selectByExample(example);
		videoEncoderDevices.setResultAndEnd(list);
		return Results.newSuccessResult(videoEncoderDevices);
	}

	@Override
	public boolean isCodeExist(String resCode) {
		if(StringUtils.isEmpty(resCode)){
			return true;
		}
		return videoEncoderDao.selectByPrimaryKey(resCode)!=null;
	}

	@Override
	public CodeMapper getCodeMapper() {
		return codeDao;
	}
	@Override
	public Result<List<String>> addDataSyncList() {
		
		return null;
	}
 
	
}
