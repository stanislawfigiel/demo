package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController {
	@RequestMapping("/jaja")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}
