package com.sunbeam.entitires;

import java.io.Serializable;
import java.util.Objects;

public class Vehicle implements Serializable {
	 
	 private String vehicleNumber;
	 private VehicleModel vehicleModel;
	
	 
	 public Vehicle( String vehicleNumber,VehicleModel vehicleModel) {
		
		this.vehicleNumber = vehicleNumber;
		this.vehicleModel=vehicleModel;
	 }


	 
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}



	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	
	

	public VehicleModel getVehicleModel() {
		return vehicleModel;
	}



	public void setVehicleModel(VehicleModel vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	
	


	@Override
	public int hashCode() {
		return Objects.hash(vehicleNumber);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(vehicleNumber, other.vehicleNumber);
	}



	@Override
	public String toString() {
		return "Vehicle  [vehicleNumber=" + vehicleNumber+ " " +vehicleModel.toString()+ "]";
	}
	 
	 
}
