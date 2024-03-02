package com.pratiit.service;

import com.pratiit.entity.UserInfo;
import com.pratiit.request.LoginRequest;
import com.pratiit.request.SignUpRequest;
import com.pratiit.response.LoginResponse;
import com.pratiit.response.SignUpResponse;

public interface UserService {
	
	public SignUpResponse saveUser(SignUpRequest request);
	
	public LoginResponse userLogin(LoginRequest loginRequest);
	
	public UserInfo getUserById(Integer id);
	

}
