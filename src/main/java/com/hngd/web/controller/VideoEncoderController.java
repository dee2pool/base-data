package com.hngd.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hngd.common.result.Result;
import com.hngd.common.web.RestResponses;
import com.hngd.common.web.parameter.GsonEditor;
import com.hngd.common.web.result.RestResponse;
import com.hngd.model.VideoEncoder;
import com.hngd.service.VideoEncoderService;

@RestController
@RequestMapping("/video/encoder")
public class VideoEncoderController {

	@InitBinder
	public void onBinderInit(WebDataBinder binder){
		binder.registerCustomEditor(VideoEncoder.class,new GsonEditor(VideoEncoder.class));
	}
	@Autowired
	private VideoEncoderService videoEncoderService;
	
	
	@PostMapping("/add")
	public RestResponse<String> addVideoEncoder(@RequestBody @RequestParam("videoEncoder")VideoEncoder videoEncoder){
		Result<String> result=videoEncoderService.addVideoEncoder(videoEncoder);
		if(result.isSuccess()){
			return RestResponses.newSuccessResponse("",1,result.getData());
		}else{
			return RestResponses.newFailResponse(result.getErrorCode(), result.getDescription());
		}
	}
	
	
}
