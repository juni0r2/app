package com.schoolofnet.spring_app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@GetMapping("/")
	@ResponseBody
	public String say() {
		return "This is my first project with Spring boot and GitHub";
	}
	
	@GetMapping("/say/{name}")
	@ResponseBody
	public String sayParameter(@PathVariable String name) {
		return "My name is "+ name;
	}
	
	@PostMapping("/say")
	@ResponseBody
	public String sayPost(@RequestParam String name) {
		return "Return by POST with "+name;
	}
}
