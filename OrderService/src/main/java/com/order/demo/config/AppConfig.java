package com.order.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Value("${orderservice.orderType}")
	public String orderServiceUrl;
}
