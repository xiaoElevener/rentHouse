package com.xiao.service;

import java.util.Set;

import com.xiao.entity.Users;

public interface UserService {
	public Users login(Users user);

	public void register(Users user);
	
	public Set<String> findRolesByUsername(String username);
}
