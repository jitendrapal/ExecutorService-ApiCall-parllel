package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service4 {
	
	@GetMapping("/four")
	public String geMessage()
	{
		return "Service4";
	}

}
