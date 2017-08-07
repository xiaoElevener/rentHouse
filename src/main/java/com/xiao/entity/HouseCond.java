package com.xiao.entity;

public class HouseCond {
	private String id;
	private String title;
	private String price;
	private String street_id;
	private String type_id;
	private String user_id;
	private String floorage;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStreet_id() {
		return street_id;
	}

	public void setStreet_id(String street_id) {
		this.street_id = street_id;
	}

	public String getType_id() {
		return type_id;
	}

	public void setType_id(String type_id) {
		this.type_id = type_id;
	}

	public String getFloorage() {
		return floorage;
	}

	public void setFloorage(String floorage) {
		this.floorage = floorage;
	}

	@Override
	public String toString() {
		return "HouseCond [title=" + title + ", price=" + price
				+ ", street_id=" + street_id + ", type_id=" + type_id
				+ ", floorage=" + floorage + "]";
	}

}
