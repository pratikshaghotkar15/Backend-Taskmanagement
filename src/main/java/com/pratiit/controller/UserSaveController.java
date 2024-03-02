package com.pratiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pratiit.entity.Mytask;
import com.pratiit.entity.UserInfo;
import com.pratiit.request.LoginRequest;
import com.pratiit.request.SignUpRequest;
import com.pratiit.response.LoginResponse;
import com.pratiit.response.SignUpResponse;
import com.pratiit.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "usersavecontroller", description = "users registration")
@CrossOrigin
public class UserSaveController {

	@Autowired
	private UserService service;

	@PostMapping("/register")
	public ResponseEntity<SignUpResponse> saveUser(@RequestBody SignUpRequest request) {

		SignUpResponse response = service.saveUser(request);
		if (response.getSuccessMsg() != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);

		} else if (response.getErrorMsg().contains("Duplicate Email")) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

		} else {
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/login")
	public  ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
		System.out.println(loginRequest.getEmail()+loginRequest.getPwd());
		LoginResponse response= service.userLogin(loginRequest);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<UserInfo> getUserById(@PathVariable Integer id){
		UserInfo userById = service.getUserById(id);
		return new ResponseEntity<>(userById,HttpStatus.OK);
	}
	
	

}
