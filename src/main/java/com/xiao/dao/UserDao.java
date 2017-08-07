package com.xiao.dao;

import java.util.Set;

import com.xiao.entity.Users;

public interface UserDao {
	public Users findUserByUsername(String username);

	public Set<String> findRolesByUsername(String username);

	public Set<String> findPermissionsByUsername(String username);

	public void createUser(Users users);

	public Integer findUserCount();

}
