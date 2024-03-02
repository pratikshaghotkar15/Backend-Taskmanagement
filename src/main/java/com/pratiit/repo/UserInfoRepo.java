package com.pratiit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pratiit.entity.UserInfo;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo, Integer> {

	public UserInfo findByEmailAndPwd(String email, String pwd);

	public UserInfo findByEmail(String email);

}
