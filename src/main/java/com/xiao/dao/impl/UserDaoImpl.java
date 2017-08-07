package com.xiao.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xiao.dao.UserDao;
import com.xiao.entity.Users;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Users findUserByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Users where username =:username";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		Users user = (Users) query.uniqueResult();
		System.out.println("dao:" + user);
		return user;
	}

	public void createUser(Users user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}

	public Set<String> findRolesByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select role.roleName from Users users,Role role where users.role.roleId=role.roleId and users.username=:username";
		Query query = session.createQuery(hql);
		query.setString("username", username);
		@SuppressWarnings("unchecked")
		List<String> list = query.list();
		return new HashSet<String>(list);
	}

	public Set<String> findPermissionsByUsername(String username) {
		return null;
	}

	public Integer findUserCount() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(*) from Users";
		Integer count = ((Long)(session.createQuery(hql).uniqueResult())).intValue();
		return count;
	}
}
