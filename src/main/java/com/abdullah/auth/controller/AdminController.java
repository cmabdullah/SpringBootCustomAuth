package com.abdullah.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abdullah.auth.model.User;
//http://localhost:8080/secure/auth/admin/add
//@Controller
@RestController
@RequestMapping("/secure/auth/")
public class AdminController {
	
	@ResponseBody
	@PostMapping("/admin/add")
	public String addUserByAdmin(
			
			@RequestBody User user
			) {
		return "admin post method called user added successfully..."+ user.toString();
	}

	@ResponseBody
	@GetMapping("/admin/add")
	public String securedHello() {
		return "Admin Get method called";
	}

}
