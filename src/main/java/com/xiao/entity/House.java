package com.xiao.entity;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.JSONObject;

/**
 * House entity. @author MyEclipse Persistence Tools
 */

public class House implements java.io.Serializable, ToJsonObject {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8638839534032366986L;

	private Integer id;

	@Valid
	private Type type;

	private Users users;

	@Valid
	private Street street;

	@Length(min = 2, max = 12, message = "标题为2-12个字!")
	private String title;

	@Size(max = 300, message = "描述不能超过300个字!")
	private String description;

	@NotNull(message = "价格不能为空!")
	private Integer price;

	@NotNull(message = "日期不能为空")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past(message = "日期错误!不能超过今天!")
	private Date pubdate;

	@NotNull(message = "面积不能为空!")
	@Range(min = 1, max = 5000, message = "面积范围1-5000平米!")
	private Integer floorage;

	@Length(min = 2, max = 12, message = "联系方式为2-12个字!")
	private String contact;

	// Constructors

	/** default constructor */
	public House() {
	}

	/** minimal constructor */
	public House(Integer id, Type type) {
		this.id = id;
		this.type = type;
	}

	/** full constructor */
	public House(Integer id, Type type, Users users, Street street,
			String title, String description, Integer price, Date pubdate,
			Integer floorage, String contact) {
		this.id = id;
		this.type = type;
		this.users = users;
		this.street = street;
		this.title = title;
		this.description = description;
		this.price = price;
		this.pubdate = pubdate;
		this.floorage = floorage;
		this.contact = contact;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Street getStreet() {
		return this.street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getPubdate() {
		return this.pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	public Integer getFloorage() {
		return this.floorage;
	}

	public void setFloorage(Integer floorage) {
		this.floorage = floorage;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "House [id=" + id + ", type=" + type + ", users=" + users
				+ ", street=" + street + ", title=" + title + ", description="
				+ description + ", price=" + price + ", pubdate=" + pubdate
				+ ", floorage=" + floorage + ", contact=" + contact + "]";
	}

	public JSONObject toJsonObject() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", id);
		jsonObject.put("type", type.toJsonObject());
		jsonObject.put("users", users.toJsonObject());
		jsonObject.put("street", street.toJsonObject());
		jsonObject.put("title", title);
		jsonObject.put("description", description);
		jsonObject.put("price", price);
		jsonObject.put("pubdate", pubdate);
		jsonObject.put("floorage", floorage);
		jsonObject.put("contact", contact);
		return jsonObject;
	}

}