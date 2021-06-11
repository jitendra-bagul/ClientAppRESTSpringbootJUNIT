package com.exazeit.entity;

public class Client {

	
	private String firstName;
	private String lastName;
	private Long mobNum;
	private Long idNum;
	private Address address;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
		
	public Long getMobNum() {
		return mobNum;
	}
	public void setMobNum(Long mobNum) {
		this.mobNum = mobNum;
	}
	public Long getIdNum() {
		return idNum;
	}
	public void setIdNum(Long idNum) {
		this.idNum = idNum;
	}
	public Client() {
		super();
	}
	public Client(String firstName, String lastName, Long mobNum, Long idNum, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobNum = mobNum;
		this.idNum = idNum;
		this.address = address;
	}

	
	
	
	
}
