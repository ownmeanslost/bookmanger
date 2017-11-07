package com.bookmanger.homepage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
	@RequestMapping("/Login")
	public String Login(){
		
		return "/homepage/HomePage";
	}
	@RequestMapping("/erroPage")
	public String erroPage(){
		
		return "/homepage/erroPage";
	}
}
