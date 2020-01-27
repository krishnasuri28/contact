package com.contact;

public class Contact {

	@Override
	public String toString() {
		return "Contact [contact_id=" + contact_id + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", phone=" + phone + "]";
	}
	
	public Contact () {
		
	}

	private Integer contact_id;

	private String name;

	private String email;

	private String address;

	private String phone;
	
	public Contact( int contact_id ,String name, String email, String address, String phone) {
		super();
		this.contact_id = contact_id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}

	public Contact( String name, String email, String address, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}

	public Integer getContact_id() {
		return contact_id;
	}

	public void setContact_id(Integer contact_id) {
		this.contact_id = contact_id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
