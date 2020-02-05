package com.tlswn.C71S3Tlswndemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.tlswn.C71S3Tlswndemo")
public class C71S3TlswnDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(C71S3TlswnDemoApplication.class, args);
	}

}
