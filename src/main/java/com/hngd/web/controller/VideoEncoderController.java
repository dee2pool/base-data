package com.hngd.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hngd.common.error.ErrorCode;
import com.hngd.common.result.Result;
import com.hngd.common.web.RestResponses;
import com.hngd.common.web.page.PagedData;
import com.hngd.common.web.parameter.GsonEditor;
import com.hngd.common.web.result.RestResponse;
import com.hngd.model.VideoEncoder;
import com.hngd.model.VideoEncoderInfo;
import com.hngd.service.VideoEncoderService;

/**
 * 视频编码设备管理
 * @author 
 */
@RestController
@RequestMapping("/video/encoder")
public class VideoEncoderController {

	@InitBinder
	public void onBinderInit(WebDataBinder binder){
		binder.registerCustomEditor(VideoEncoder.class,new GsonEditor(VideoEncoder.class));
	}
	@Autowired
	private VideoEncoderService videoEncoderService;
	/**
	 * 添加视频编码器设备
	 * @param videoEncoder
	 * @return
	 * @author 
	 * @since 1.0.0
	 * @time 2018年7月13日 下午3:28:53
	 */
	@PostMapping("/add")
	public RestResponse<String> addVideoEncoder(@RequestBody @RequestParam("videoEncoder")VideoEncoder videoEncoder){
		Result<String> result=videoEncoderService.addVideoEncoder(videoEncoder);
		if(result.isSuccess()){
			return RestResponses.newSuccessResponse("",1,result.getData());
		}else{
			return RestResponses.newFailResponse(result.getErrorCode(), result.getDescription());
		}
	}
	
	/**
	 * 删除视频编码器设备
	 * @param 待删除视频编码器设备的编码
	 * @return
	 * @author 
	 * @since 1.0.0
	 * @time 2018年7月13日 下午3:28:53
	 */
	@DeleteMapping("/delete")
	public RestResponse<Void> deleteVideoEncoder(@RequestBody @RequestParam("videoEncoderCode")String videoEncoderCode){
		Integer result=videoEncoderService.deleteVideoEncoderByCode(videoEncoderCode);
		if(ErrorCode.NO_ERROR.equals(result)){
			return RestResponses.newSuccessResponse("");
		}else{
			return RestResponses.newFailResponse(result,"删除编码器失败");
		}
	}
	
 
	/**
	 * 查询视频编码器设备列表
	 * @param pageNo 分页查询页号
	 * @param pageSize 分页大小
	 * @param resName 设备名称，可选查询参数
	 * @param ipAddress 设备Ip地址，可选查询参数
	 * @return
	 * @author 
	 * @since 1.0.0
	 * @time 2018年7月16日 上午8:17:22
	 */
	@DeleteMapping("/list")
	public RestResponse<List<VideoEncoderInfo>> getVideoEncoderList(@RequestParam("pageNo")Integer pageNo,
			@RequestParam("pageSize")Integer pageSize,
			@RequestParam(value="resName",required=false)String resName,
			@RequestParam(value="ipAddress",required=false)String ipAddress){
		Result<PagedData<VideoEncoderInfo>> result=videoEncoderService.getVideoEncoderList(pageNo,pageSize,resName,ipAddress);
		if(result.isSuccess()){
			PagedData<VideoEncoderInfo> encoderInfos=result.getData();
			return RestResponses.newSuccessResponse("",encoderInfos.getResult().size(),encoderInfos.getResult(),encoderInfos.getTotal());
		}else{
			return RestResponses.newFailResponse(result.getErrorCode(),result.getDescription());
		}
	}
	
	
}
