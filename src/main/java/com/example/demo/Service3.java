package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service3 {

	@GetMapping("/three")
	public String geMessage()
	{
		return "Service3";
	}
}
