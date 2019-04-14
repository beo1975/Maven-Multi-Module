package com.benito.user.dto;

public class User {

	private static String lineSeparator = System.getProperty("line.separator");

	private final int id;
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

	private String printId() {
		return "ID:        " + id + lineSeparator;
	}

	private String printFullName() {
		return "Full name: " + name + lineSeparator;
	}

	private String printMail() {
		return "Mail:      " + mail + lineSeparator;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("User:").append(lineSeparator);
		sb.append("-----").append(lineSeparator);
		sb.append(printFullName());
		sb.append(printId());
		sb.append(printMail());
		return sb.toString();
	}
}
