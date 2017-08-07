package com.xiao.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiao.dao.UserDao;
import com.xiao.entity.Role;
import com.xiao.entity.Users;
import com.xiao.service.UserService;
import com.xiao.util.GeneratorPasswordUtil;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public Users login(Users user) {
		Users u = userDao.findUserByUsername(user.getUsername());
		return u;
	}

	@Override
	public void register(Users user) {
		// 设置角色
		Role role = new Role();
		role.setRoleId(1);
		user.setRole(role);
		user.setUserId(userDao.findUserCount() + 1);
		user.setPassword(GeneratorPasswordUtil.getHashPassword(
				user.getPassword(), user.getUserId().toString()));
		userDao.createUser(user);
	}

	@Override
	public Set<String> findRolesByUsername(String username) {
		return userDao.findRolesByUsername(username);
	}

}
