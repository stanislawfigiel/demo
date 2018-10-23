package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@EntityScan({"com.example.demo.entity"})
@ComponentScan({"com.example.demo.*", "com.example.demo.controller" })
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
		for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println("BEAN:" + name);
		}
	}
}
