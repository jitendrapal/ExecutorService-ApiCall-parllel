package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service2 {

	@GetMapping("/two")
	public String geMessage()
	{
		return "Service2";
	}
}
