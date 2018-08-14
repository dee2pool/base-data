package com.hngd.web.config;
 

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.hngd.common.util.GsonUtils;
import com.hngd.common.web.parameter.RequestBodyConverter;
import com.hngd.web.interceptor.HttpRequestInterceptor;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HttpRequestInterceptor());
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		GsonHttpMessageConverter gmc=new GsonHttpMessageConverter();
		gmc.setGson(GsonUtils.getGson());
		converters.add(gmc);
	}
	
	@Bean
    public RequestBodyConverter getConversionService() {  
        return new RequestBodyConverter();  
    } 
}
