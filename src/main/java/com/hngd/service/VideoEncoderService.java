package com.hngd.service;

import com.hngd.common.result.Result;
import com.hngd.model.VideoEncoder;

public interface VideoEncoderService {

	Result<String> addVideoEncoder(VideoEncoder videoEncoder);

}
