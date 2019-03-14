package cn.gyj.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
	@Value("${user.name}")
	private String username;
	@Value("${user.password}")
	private String password;
	
	@RequestMapping("/test")
	public String test() {
		return this.username + " -- " + this.password;
	}
}
