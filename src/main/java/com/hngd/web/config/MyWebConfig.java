package com.hngd.web.config;
 

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.hngd.common.web.parameter.RequestBodyConverter;
import com.hngd.common.web.result.GsonHttpMessageConverter;
import com.hngd.web.interceptor.HttpRequestInterceptor;

@Configuration
public class MyWebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HttpRequestInterceptor());
		super.addInterceptors(registry);
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new GsonHttpMessageConverter());
		super.configureMessageConverters(converters);
	}
	
	@Bean
    public RequestBodyConverter getConversionService() {  
        return new RequestBodyConverter();  
    } 
}
