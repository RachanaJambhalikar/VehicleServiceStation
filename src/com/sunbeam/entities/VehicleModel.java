package com.sunbeam.entities;

import java.io.Serializable;

public class VehicleModel implements Serializable {
    private static final long serialVersionUID = 1L;
	private int id;
	private String manufacturer;
    private String model;
    
    public VehicleModel() {
	}

	public VehicleModel(int id, String manufacturer, String model) {
		super();
		this.id = id;
		this.manufacturer = manufacturer;
		this.model = model;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "VehicleModel [id=" + id + ", manufacturer=" + manufacturer + ", model=" + model + "]";
	}

}
