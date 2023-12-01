package com.book.securityConfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableMethodSecurity
public class MySecurityCOnfig {
	
	@Autowired
	private JwtAuthentiationEntryPoint point;
	
	@Autowired
	private JwtAuthenticationFilter filter;
	
	@Bean
	  public UserDetailsService getUserDetailService() { 
		UserDetails normalUser = User.withUsername("sunil")
				.password(passwordEncoder().encode("123"))
				.roles("Normal")
				.build();
		UserDetails adminUser = User.withUsername("admin")
				.password(passwordEncoder().encode("123"))
				.roles("Admin")
				.build();
		
		
		   return new InMemoryUserDetailsManager(normalUser, adminUser);
		  }
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() { 		
		return new   BCryptPasswordEncoder(); 
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.csrf(csrf-> csrf.disable())
				.cors(cors -> cors.disable())
				.authorizeHttpRequests(auth ->auth.requestMatchers("/home/**")
						.authenticated()
						.requestMatchers("/generate-token/", "/user/")
						.permitAll()
						.anyRequest().authenticated()
						)
				.exceptionHandling(ex -> ex.authenticationEntryPoint(point))
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				
				;
		
			httpSecurity.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);		
		
		
		return httpSecurity.build();

	}

	
	 @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
	        return builder.getAuthenticationManager();
	    }
}
