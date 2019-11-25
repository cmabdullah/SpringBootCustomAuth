package com.abdullah.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.abdullah.auth.model.Reader;

public interface ReaderRepository extends JpaRepository<Reader, String> {

	UserDetails findByUsername(String username);
}
