package org.wangyu.springcloud.cfgbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration//applicationcontext.xml==@Configuration 配置注解版的xml文件
public class ConfigBean {
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
