package com.example.redis_mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching // It will enable caching to entire spring-boot project
public class RedisMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisMysqlApplication.class, args);
	}

}
