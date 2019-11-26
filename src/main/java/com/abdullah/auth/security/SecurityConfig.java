package com.abdullah.auth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.abdullah.auth.repository.ReaderRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private ReaderRepository readerRepository;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		
		.antMatchers("/rest/**")
		.access("hasRole('ROLE_USER')")
		
		.antMatchers("/secure/**")
		//.permitAll()
		.access("hasRole('ROLE_ADMIN')")
		//.access("hasRole('READER')")
		.antMatchers("/**").permitAll().and()
				.formLogin()
				
				//.loginPage("/login").failureUrl("/login?error=true")
				
				;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		
		.userDetailsService(new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				UserDetails userDetails = readerRepository.findByUsername(username);
				
//				System.out.println(userDetails.getPassword());
//				System.out.println(userDetails.getAuthorities());
				return userDetails;

			}
		}).passwordEncoder(encodePWD());

	}
	
	
	@Bean
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
}
