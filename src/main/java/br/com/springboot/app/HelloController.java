package br.com.springboot.app;

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
	
	@GetMapping("/say/{name}")
	@ResponseBody
	public String hello(@PathVariable String name) {
		return "Hello World "+name;
	}
	
	@PostMapping("/say")
	@ResponseBody
	public String sayPost(@RequestParam String name) {
		return "Method POST "+name;
	}
}
