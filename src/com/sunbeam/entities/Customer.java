package com.sunbeam.entities;

import java.io.Serializable;
import java.util.HashMap;

public class Customer implements Serializable{

	private String name;
	private String address;
	private String mobileNumber;
	private HashMap<String, Vehicle> vehicles;
	
	public Customer() {
		 vehicles = new HashMap<>();
	                  }
	public Customer(String name, String address, String mobileNumber) 
	{
		this.name = name;
		this.address = address;
		this.mobileNumber = mobileNumber;
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

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [name:" + name + ", address:" + address + ", mobileNumber:" + mobileNumber + "\n" + "vehicles:"
				+ vehicles + "]";
    }
}