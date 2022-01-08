package com.rest.api.post;

public class User {
	
	private String name;
	private String last_name;
	private String gender;
	private String dob;
	private String email;
	private String phone;
	private String status;
	private String address;
	
	public User(String name, String last_name, String gender, String dob, String email, String phone, String status,
			String address) {
		super();
		this.name = name;
		this.last_name = last_name;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
		this.phone = phone;
		this.status = status;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
	
	

}
