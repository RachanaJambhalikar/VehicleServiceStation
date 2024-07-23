package com.sunbeam.entitires;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

import com.sunbeam.operations.VehicleModelOperations;

public class Customer implements Serializable{
	private String name;
	private String address;
	private int mobile;
	private String email;
	private HashMap<String, Vehicle> vehicles;
	
	public Customer() {
		vehicles = new HashMap<>();
	}
	
	
	public Customer(String name, String address, int mobile, String email ,HashMap<String, Vehicle> vehicles) {
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.vehicles = vehicles;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
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


	public int getMobile() {
		return mobile;
	}


	public void setMobile(int mobile) {
		this.mobile = mobile;
	}


	public HashMap<String, Vehicle> getVehicles() {
		return vehicles;
	}


	public void setVehicles(HashMap<String, Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", mobile=" + mobile + ", email=" + email
				+ ", vehicles=" + vehicles + "]";
	}
	
	 @Override
	 public int hashCode() {
	        return this.mobile; // hash code based on id
	 }
	 
	 public void inputVehicle(Scanner scanner) {
			try {
	        	System.out.println("Add vehicle number to add a vehicle");
	        	String vehicleNumber = scanner.next();
	        	
	        	VehicleModelOperations vmobj = new VehicleModelOperations();
	        	vmobj.readAllModels();
	        	
	        	System.out.println("Enter vehicle model details: id, Manufacturer, Model");
	        	VehicleModel vmToPass = new VehicleModel(scanner.nextInt(), scanner.next(),scanner.next());
	        	Vehicle v= new Vehicle(vehicleNumber,vmToPass);
	        	
	        //	System.out.println("Vehicle added" + v);
	        	this.vehicles.put(vehicleNumber, v);
	        	
	        	System.out.println("All vehicles: " + vehicles);
	        	
	          	} catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	
			
		}
	
}
