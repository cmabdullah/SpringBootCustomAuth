package com.abdullah.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.abdullah.auth.model.Reader;
import com.abdullah.auth.repository.ReaderRepository;

@Service
public class ReaderServiceImpl implements ReaderService{

	
	@Autowired
	ReaderRepository readerRepository;

	@Cacheable(value= "AllReadersCache", unless= "#result.size() == 0")	
	public List<Reader> getAllReaders(){
		System.out.println("--- Inside getAllArticles() ---");
		List<Reader> list = new ArrayList<>();
		readerRepository.findAll().forEach(e -> list.add(e));
		return list;
	}
}
