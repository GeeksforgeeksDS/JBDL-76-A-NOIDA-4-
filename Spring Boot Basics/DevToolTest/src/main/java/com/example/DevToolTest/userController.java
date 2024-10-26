package com.example.DevToolTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class userController {
	
	@GetMapping("/get")
	public String getUser() {
		return "Hello User";
	}

}
