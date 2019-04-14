package com.spring.base;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.spring.base.filter.ExampleRecordControlUseTime;

//@Configuration
public class   WebMvcConfig  implements WebMvcConfigurer {
	// @Resource
	//private ExampleRecordControlUseTime recordControlUseTime;
	// @Override public void addInterceptors(InterceptorRegistry registry) { 
	//	 InterceptorRegistration registration = registry.addInterceptor( recordControlUseTime); 
		 // 拦截配置 
		 //registration.addPathPatterns("/api/**"); 
		 // 排除配置
		 //registration.excludePathPatterns("/api/word"); 
		// }
	 }