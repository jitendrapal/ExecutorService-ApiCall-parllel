package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service5 {

	
	@GetMapping("/five")
	public String geMessage()
	{
		return "Service5";
	}
}
