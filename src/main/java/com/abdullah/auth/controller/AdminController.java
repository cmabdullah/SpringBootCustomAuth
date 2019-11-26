package com.abdullah.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abdullah.auth.model.Reader;
import com.abdullah.auth.model.User;
import com.abdullah.auth.repository.ReaderRepository;
//http://localhost:8080/secure/auth/admin/add
//@Controller
@RestController
@RequestMapping("/secure/auth/")
public class AdminController {
	
	@Autowired
	private ReaderRepository readerRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
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
//		Reader reader = new Reader();
//		reader.setUsername("zxcv");
//		reader.setUserRole("ROLE_USER");
//		reader.setPassword(bCryptPasswordEncoder.encode("1234"));
//		readerRepository.save(reader);
		
		return "Admin Get method called";
	}

}
