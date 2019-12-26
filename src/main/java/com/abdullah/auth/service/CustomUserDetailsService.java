package com.abdullah.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abdullah.auth.repository.ReaderRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private ReaderRepository readerRepository;
	
	@Cacheable(value = "UserDetails" ,key = "#username")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails = readerRepository.findByUsername(username);

		if (userDetails==null) {
		throw new UsernameNotFoundException("Username not exist : "+ username);
		}else {
			return userDetails;
		}
	}

}