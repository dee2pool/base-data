package com.hngd.web.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.stereotype.Component;

import com.hngd.common.web.page.PageHelper;


@Component
public class MyConfigurationCustomizer implements ConfigurationCustomizer {

	@Override
	public void customize(Configuration configuration) {
		configuration.addInterceptor(new PageHelper());

	}

}
