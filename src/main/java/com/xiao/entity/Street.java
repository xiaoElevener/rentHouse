package com.xiao.entity;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.alibaba.fastjson.JSONObject;

/**
 * Street entity. @author MyEclipse Persistence Tools
 */

public class Street implements java.io.Serializable ,ToJsonObject{

	// Fields

	@NotNull(message="街道不能为空!")
	private Integer streetId;
	
	@Valid
	private District district;
	
	private String name;
	private Set houses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Street() {
	}

	/** minimal constructor */
	public Street(Integer streetId) {
		this.streetId = streetId;
	}

	/** full constructor */
	public Street(Integer streetId, District district, String name, Set houses) {
		this.streetId = streetId;
		this.district = district;
		this.name = name;
		this.houses = houses;
	}

	// Property accessors

	public Integer getStreetId() {
		return this.streetId;
	}

	public void setStreetId(Integer streetId) {
		this.streetId = streetId;
	}

	public District getDistrict() {
		return this.district;
	}

	public void setDistrict(District district) {
		this.district = district;
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
		return "Street [streetId=" + streetId + ", district=" + district
				+ ", name=" + name + "]";
	}

	public JSONObject toJsonObject() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("streetId", streetId);
		jsonObject.put("name", name);
		jsonObject.put("district", district.toJsonObject());
		return jsonObject;
	}
}