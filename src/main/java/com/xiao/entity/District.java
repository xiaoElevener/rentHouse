package com.xiao.entity;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * District entity. @author MyEclipse Persistence Tools
 */

public class District implements java.io.Serializable, ToJsonObject {

	// Fields
	@NotNull(message = "区县不能为空!")
	private Integer districtId;

	private String name;
	@JSONField(serialize = false)
	private Set streets = new HashSet(0);

	// Constructors

	/** default constructor */
	public District() {
	}

	/** minimal constructor */
	public District(Integer districtId) {
		this.districtId = districtId;
	}

	/** full constructor */
	public District(Integer districtId, String name, Set streets) {
		this.districtId = districtId;
		this.name = name;
		this.streets = streets;
	}

	// Property accessors

	public Integer getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getStreets() {
		return this.streets;
	}

	public void setStreets(Set streets) {
		this.streets = streets;
	}

	@Override
	public String toString() {
		return "District [districtId=" + districtId + ", name=" + name + "]";
	}

	public JSONObject toJsonObject() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("districtId", districtId);
		jsonObject.put("name", name);
		return jsonObject;
	}

}