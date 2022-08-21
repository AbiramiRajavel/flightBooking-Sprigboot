package com.infy.Controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.Dto.UserDetailsDTO;
import com.infy.Service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping("/register")
	public ResponseEntity<String> register(@Valid @RequestBody UserDetailsDTO user){
	     userService.userRegister(user);
	     return new ResponseEntity<String>("Register",HttpStatus.ACCEPTED);
	}
	@PostMapping("/login")
	public ResponseEntity<String> login(@Valid @RequestBody UserDetailsDTO user)
	{
		String result=userService.userLogin(user);
		return new ResponseEntity<String>(result,HttpStatus.ACCEPTED);    
	}

}
