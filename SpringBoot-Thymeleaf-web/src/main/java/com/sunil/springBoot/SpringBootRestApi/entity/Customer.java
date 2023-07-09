package com.sunil.springBoot.SpringBootRestApi.entity;

public class Customer {
	int id;
	String name;
	String village;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int id, String name, String village) {
		super();
		this.id = id;
		this.name = name;
		this.village = village;
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
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	
}
