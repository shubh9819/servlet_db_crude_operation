package com.basic;

public class minipojo {
	String Id;
	String Name;
	String Password;
	String Email;
	String Country;
	
	
	public minipojo() {
		super();
	}
//	public minipojo(String id, String name, String password, String email, String country) {
//		super();
//		Id = id;
//		Name = name;
//		Password = password;
//		Email = email;
//		Country = country;
//	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	//@Override
//	public String toString() {
//		return "minipojo [Id=" + Id + ", Name=" + Name + ", Password=" + Password + ", Email=" + Email + ", Country="
//				+ Country + "]";
//	}

	
}
