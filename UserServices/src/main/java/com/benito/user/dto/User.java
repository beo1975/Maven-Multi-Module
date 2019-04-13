package com.benito.user.dto;

public class User {

	private int id;
	private String name;
	private String mail;

	public User(int id, String name) {
		this.id = id;
		this.name = name;
		this.mail = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
