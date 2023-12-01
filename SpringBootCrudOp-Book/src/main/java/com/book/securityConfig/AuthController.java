package com.book.securityConfig;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;


    @Autowired
    private JwtUtils jwtutils;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);


    //generate tokens
    @PostMapping("/generate-token")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) throws Exception {
    	
    	try {
    		 this.doAuthenticate(request.getEmail(), request.getPassword());
    	}
    	catch(UsernameNotFoundException e) {
    		e.printStackTrace();
    		throw new Exception("User not found");
    	}

       


        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = this.jwtutils.generateToken(userDetails);

        return  ResponseEntity.ok(new JwtResponse(token));
    }

    private void doAuthenticate(String username, String password) throws Exception {
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(username, password);
        try {
            manager.authenticate(authentication);
        }catch(DisabledException e) {
        	throw new Exception("User disable");
        }
        
        catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }
    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }
}
