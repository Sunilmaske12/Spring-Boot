package com.book.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.book.service.CustomeUserDetailServiceImpl;


@Configuration
public class SecurityConfig {
	
	@Autowired
	private JwtAuthentiationEntryPoint point;
	
	@Autowired
	private JwtAuthenticationFilter filter;
	
	@Autowired
	private UserDetailsService userDetailService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		 http.csrf(csrf-> csrf.disable())
			.cors(cors -> cors.disable())
			.authorizeHttpRequests(auth ->auth.requestMatchers("/home/**")
					.authenticated()
					.requestMatchers("/auth/login")
					.permitAll()
					.requestMatchers("/auth/addUser")
					.permitAll()
					.anyRequest().authenticated()
					)
			.exceptionHandling(ex -> ex.authenticationEntryPoint(point))
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			
			;
	
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);		
	
	
	return http.build();
	    }
	 
	 
	 @Bean
	 public DaoAuthenticationProvider daoAuthenticationProvider() {
		 DaoAuthenticationProvider dap=new DaoAuthenticationProvider();
		 dap.setUserDetailsService(userDetailService);
		 dap.setPasswordEncoder(passwordEncoder);
		 return dap;
	 }
	 
	

}
