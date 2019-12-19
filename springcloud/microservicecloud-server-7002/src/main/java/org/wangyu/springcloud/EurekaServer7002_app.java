package org.wangyu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // 表示该服务是EurekaServer服务端，接受其他的微服务注入进来
public class EurekaServer7002_app {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServer7002_app.class, args);
	}

}
