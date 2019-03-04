package com.itemservice.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ItemServiceApplication {

	public static void main(String[] args) {
	        System.out.println("Hello Worlds");
		SpringApplication.run(ItemServiceApplication.class, args);
	}
}
