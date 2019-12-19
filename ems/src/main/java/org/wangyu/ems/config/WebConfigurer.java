package org.wangyu.ems.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.wangyu.ems.intercepors.LoginInterceptor;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {
	
	@Autowired
	private LoginInterceptor loginInterceptor;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/public/**");
	}
	
	/**
	 * 添加拦截器，拦截所有不包含会话的指定的某一会话属性的url，设置白名单允许访问
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor).addPathPatterns("/**").
		excludePathPatterns("/login","/","/js/**","/editor/**","/images/**","/css/**");
		//"/","/js/**","/editor/**","/images/**","/css/**"
	}

}
