package com.sunbeam.entities;

import java.io.Serializable;
import java.util.Objects;

public class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;
	private String vehicleNumber;
	private VehicleModel vehicleModel;

	public Vehicle() {
	}

	public Vehicle(String vehicleNumber, VehicleModel vehicleModel) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.vehicleModel = vehicleModel;
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
	public String toString() {
		return "[vehicleNumber:" + vehicleNumber + ", vehicleModel:" + vehicleModel + "]";
	}
}
