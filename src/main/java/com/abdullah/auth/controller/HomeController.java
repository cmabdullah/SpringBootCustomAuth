package com.abdullah.auth.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abdullah.auth.model.Reader;
import com.abdullah.auth.repository.ReaderRepository;
import com.abdullah.auth.service.ReaderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
//@RestController
@RequestMapping("/rest/auth")
public class HomeController {
	/// http://localhost:8080/rest/auth/process
	
	@Autowired
	ReaderService readerService;
	
	@ResponseBody
	@GetMapping("/process")
	public String process() {
		List<Reader> list = readerService.getAllReaders();
		list.forEach(n -> System.out.println(n.toString()));
		//@Cacheable(value= "allArticlesCache", unless= "#result.size() == 0")	

		log.trace("A TRACE Message");
		log.debug("A DEBUG Message");
		log.info("An INFO Message");
		log.warn("A WARN Message");
		log.error("An ERROR Message");

		return "processing..";
	}
	
	
	
	
	

}
