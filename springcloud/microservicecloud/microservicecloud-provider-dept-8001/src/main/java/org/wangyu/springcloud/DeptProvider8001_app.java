package org.wangyu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient   //本次服务启动后会自动注入到Eureka服务注册中心去
@EnableDiscoveryClient  //该注解表示该微服务可以提供服务发现功能
public class DeptProvider8001_app {
	
	public static void main(String[] args) {
		SpringApplication.run(DeptProvider8001_app.class, args);
	}

}
