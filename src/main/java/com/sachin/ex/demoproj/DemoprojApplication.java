package com.sachin.ex.demoproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableHystrix
@EnableFeignClients
@EnableCaching
public class DemoprojApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoprojApplication.class, args);
	}

}
