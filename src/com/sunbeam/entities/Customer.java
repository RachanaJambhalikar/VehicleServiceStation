package com.sunbeam.entities;

import java.util.HashMap;

public class Customer {

	private String name;
	private String address;
	private String phoneNumber;
	private HashMap<String, Vehicle> vehicles;
	
	public Customer(String name, String address, String phoneNumber) {

		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	// Getters and setters

	public String getName() {
		return name;
	}

	public HashMap<String, Vehicle> getVehicles() {
		return vehicles;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	

	@Override
	public String toString() {
		return "Customer{" + "name='" + name + '\'' + ", address='" + address + '\'' + ", mobileNumber='" + phoneNumber
				+ '\'' +

				'}';
	}
}