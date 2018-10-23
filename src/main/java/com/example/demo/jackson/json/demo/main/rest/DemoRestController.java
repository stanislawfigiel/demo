package com.example.demo.jackson.json.demo.main.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class DemoRestController {

	@GetMapping("/hello")
	public String sayHello(){
		return "hello world";

	}



}
