package com.xiao.entity;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.alibaba.fastjson.JSONObject;

/**
 * Type entity. @author MyEclipse Persistence Tools
 */

public class Type implements java.io.Serializable, ToJsonObject {

	// Fields

	@NotNull(message = "房屋类型不能为空!")
	private Integer typeId;

	private String name;
	private Set houses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Type() {
	}

	/** minimal constructor */
	public Type(Integer typeId) {
		this.typeId = typeId;
	}

	/** full constructor */
	public Type(Integer typeId, String name, Set houses) {
		this.typeId = typeId;
		this.name = name;
		this.houses = houses;
	}

	// Property accessors

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getHouses() {
		return this.houses;
	}

	public void setHouses(Set houses) {
		this.houses = houses;
	}

	@Override
	public String toString() {
		return "Type [typeId=" + typeId + ", name=" + name + "]";
	}

	public JSONObject toJsonObject() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("typeId", typeId);
		jsonObject.put("name", name);
		return jsonObject;
	}

}