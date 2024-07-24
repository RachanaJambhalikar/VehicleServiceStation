package com.sunbeam.entities;

import java.util.HashMap;

public class Customer {

	private String name;
	private String address;
	private String phoneNumber;
	private HashMap<String, Vehicle> vehicles;
	
	public Customer() {
		
	}
	public Customer(String name, String address, String phoneNumber) {

		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
        this.vehicles = new HashMap<>();

	}
	
	public HashMap<String, Vehicle> getVehicles() {
		return vehicles;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer{" + "name='" + name + '\'' + ", address='" + address + '\'' + ", mobileNumber='" + phoneNumber
				+ '\'' +

				'}';
	}
}