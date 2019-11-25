package com.abdullah.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RestController
@RequestMapping("/rest/auth")
public class HomeController {
	///http://localhost:8080/rest/auth/process
	@ResponseBody
	@GetMapping("/process")
	public String process() {
		return "processing..";
	}

}
