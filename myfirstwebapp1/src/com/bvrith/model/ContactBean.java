package com.bvrith.model;

public class ContactBean {
	String id;
	String name;
	String email;
	String phone;
	String user;
	
	public ContactBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ContactBean(String id, String name, String email, String phone,
			String user) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.user = user;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

}
