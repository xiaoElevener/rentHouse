package com.xiao.entity;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.alibaba.fastjson.JSONObject;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Integer userId;

	private Role role;

	@Size(min = 2, max = 20, message = "请输入2-10位长度姓名")
	private String name;

	@Size(min = 6, max = 16, message = "请输入6-10位密码")
	private String password;

	@Pattern(regexp = "1[34578][0-9]{9}", message = "请输入正确的手机号码")
	private String telephone;

	@Size(min = 4, max = 10, message = "请输入4-10为用户名")
	private String username;

	private Set houses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(Integer userId) {
		this.userId = userId;
	}

	/** full constructor */
	public Users(Integer userId, Role role, String name, String password,
			String telephone, String username, Set houses) {
		this.userId = userId;
		this.role = role;
		this.name = name;
		this.password = password;
		this.telephone = telephone;
		this.username = username;
		this.houses = houses;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set getHouses() {
		return this.houses;
	}

	public void setHouses(Set houses) {
		this.houses = houses;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", name=" + name + ", password="
				+ password + ", telephone=" + telephone + ", username="
				+ username + "]";
	}

	public JSONObject toJsonObject() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("userId", this.userId);
		jsonObject.put("name", this.name);
		jsonObject.put("password", this.password);
		jsonObject.put("telephone", this.telephone);
		jsonObject.put("username", this.username);
		return jsonObject;
	}

}