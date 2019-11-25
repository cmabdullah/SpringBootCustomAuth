//package com.abdullah.auth.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//	@Autowired
//	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//
//		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		auth.inMemoryAuthentication().withUser("cmaa").password(encoder.encode("1234")).roles( "ADMIN", "USER")
//		.and()
//		.withUser("abcd").password(encoder.encode("1234")).roles("USER");
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/login", "/h2-console/**").permitAll()
//		.antMatchers("/home", "/rest/**").access("hasRole('USER')")
//		.antMatchers("/secure/**").access("hasRole('ADMIN')")
//		//.antMatchers("/", "/*todo*/**").access("hasRole('USER')")
//		
//		.and().formLogin()
//		;
//
//		http.csrf().disable();
//		http.headers().frameOptions().disable();
//	}
//}
