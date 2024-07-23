package com.sunbeam.entitires;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.service.CustomerService;



public class Bill {
	
	private String ServiceStationName;
	private LocalDateTime ServiceDate; 
	private Customer customer ;  
	private double sparePartPrice;
	private double engineOrGearOilPrice;
	private double repairingLaborCharges;
	private double maintenanceLaborCharges;
	private double additivePrice; 
	private double FinalBill;
	
	public Bill() {
		ServiceStationName = "Sunbeam Vehicle Servicing Center ";
		ServiceDate = LocalDateTime.now();
		this.repairingLaborCharges = 100.00;
		this.maintenanceLaborCharges = 150.00;
	}
	
	

	public Bill(Customer customer, double sparePartPrice, double engineOrGearOilPrice, double additivePrice, double finalBill) {
		super();
		ServiceStationName = "Sunbeam Vehicle Servicing Center ";
		ServiceDate = LocalDateTime.now();
		this.customer  = customer;
		this.sparePartPrice = sparePartPrice;
		this.engineOrGearOilPrice = engineOrGearOilPrice;
		this.repairingLaborCharges = 100.00;
		this.maintenanceLaborCharges = 150.00;
		this.additivePrice = additivePrice;
		FinalBill = finalBill;
	}

	
	
	@Override
	public String toString() {
		return "Bill \n [ServiceStationName=" + ServiceStationName + ", \n ServiceDate=" + ServiceDate + ",\n customer="
				+ customer.getName() + 
				", \n SparePartPrice=" + sparePartPrice 
				+ ",\n repairingLaborCharges=" + repairingLaborCharges
				+ ",\n maintenanceLaborCharges=" + maintenanceLaborCharges 
				+ ",\n engineOrGearOilPrice=" + engineOrGearOilPrice
				+ ",\n AdditivePrice=" + additivePrice
				+ ",\n FinalBill with 12% tax=" + FinalBill + "\n\n\n]";
	}

	

	public double getEngineOrGearOilPrice() {
		return engineOrGearOilPrice;
	}



	public void setEngineOrGearOilPrice(double engineOrGearOilPrice) {
		this.engineOrGearOilPrice = engineOrGearOilPrice;
	}



	public String getServiceStationName() {
		return ServiceStationName;
	}

	public void setServiceStationName(String serviceStationName) {
		ServiceStationName = serviceStationName;
	}

	public LocalDateTime getServiceDate() {
		return ServiceDate;
	}

	public void setServiceDate(LocalDateTime serviceDate) {
		ServiceDate = serviceDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getSparePartPrice() {
		return sparePartPrice;
	}

	public void setSparePartPrice(double sparePartPrice) {
		this.sparePartPrice = sparePartPrice;
	}

	public double getRepairingLaborCharges() {
		return repairingLaborCharges;
	}

	public void setRepairingLaborCharges(double repairingLaborCharges) {
		this.repairingLaborCharges = repairingLaborCharges;
	}

	public double getMaintenanceLaborCharges() {
		return maintenanceLaborCharges;
	}

	public void setMaintenanceLaborCharges(double MaintenanceLaborCharges) {
		this.maintenanceLaborCharges = MaintenanceLaborCharges;
	}

	public double getAdditivePrice() {
		return additivePrice;
	}

	public void setAdditivePrice(double additivePrice) {
		this.additivePrice = additivePrice;
	}

	public double getFinalBill() {
		return FinalBill;
	}

	public void setFinalBill(double finalBill) {
		FinalBill = finalBill;
	}

	
}
