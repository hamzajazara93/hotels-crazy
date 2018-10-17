package com.hamzajazara.hotels.crazy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class CrazyHotelsApplication {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(CrazyHotelsApplication.class, args);
	}
}
