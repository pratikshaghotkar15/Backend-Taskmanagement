package com.pratiit.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratiit.entity.UserInfo;
import com.pratiit.repo.UserInfoRepo;
import com.pratiit.request.LoginRequest;
import com.pratiit.request.SignUpRequest;
import com.pratiit.response.DashboardResponse;
import com.pratiit.response.LoginResponse;
import com.pratiit.response.SignUpResponse;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserInfoRepo userInfoRepo;

	@Override
	public SignUpResponse saveUser(SignUpRequest request) {
		SignUpResponse signUpResponse=new SignUpResponse();

		UserInfo userInfo = userInfoRepo.findByEmail(request.getEmail());
		if (userInfo != null) {
			signUpResponse.setErrorMsg("Duplicate Email");
			return signUpResponse;
		}

		UserInfo entity = new UserInfo();
		BeanUtils.copyProperties(request, entity);

	    UserInfo save = userInfoRepo.save(entity);
		
		if(save != null) {
			signUpResponse.setSuccessMsg("Registration Success");
		}else {
			signUpResponse.setErrorMsg("Registration Failed");
		}
		return signUpResponse;
	}

	@Override
	public LoginResponse userLogin(LoginRequest loginRequest) {
		LoginResponse loginResponse = new LoginResponse();
		
		
		UserInfo userInfo = userInfoRepo.findByEmailAndPwd(loginRequest.getEmail(), loginRequest.getPwd());
		if(userInfo != null) {
			loginResponse.setName(userInfo.getName());
			loginResponse.setUserId(userInfo.getUserId());
			loginResponse.setValidLogin(true);
			
			
		}
		else {
			loginResponse.setValidLogin(false);
		}
		
		return loginResponse;
	}

	@Override
	public UserInfo getUserById(Integer id) {
		UserInfo userInfo = userInfoRepo.findById(id).get();
		return userInfo;
	}

}
