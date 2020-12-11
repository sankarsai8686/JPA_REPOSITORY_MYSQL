package com.sankar.tech.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping(value= {"/","/welcome","/index","/dashboard","/index"})
	public String welcome()
	{
		return "<h1>Project Started Successfully...</h1>";
	}

}
