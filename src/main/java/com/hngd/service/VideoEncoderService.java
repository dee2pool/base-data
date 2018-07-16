package com.hngd.service;

import com.hngd.common.result.Result;
import com.hngd.common.service.ICodeValidator;
import com.hngd.common.web.page.PagedData;
import com.hngd.model.VideoEncoder;
import com.hngd.model.VideoEncoderInfo;

public interface VideoEncoderService extends ICodeValidator{

	Result<String> addVideoEncoder(VideoEncoder videoEncoder);

	Integer deleteVideoEncoderByCode(String videoEncoderCode);

	Result<PagedData<VideoEncoderInfo>> getVideoEncoderList(Integer pageNo, Integer pageSize, String resName,
			String ipAddress);
	
	

}
