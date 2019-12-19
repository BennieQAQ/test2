package org.wangyu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "org.wangyu.springcloud")
@ComponentScan("org.wangyu.springcloud")
public class DeptConcumerApp_8003 {

	public static void main(String[] args) {
			SpringApplication.run(DeptConcumerApp_8003.class, args);
	}

}
