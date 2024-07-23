package com.sunbeam.entitires;

import java.util.Scanner;

import com.sunbeam.service.CustomerService;

public class ServiceRequest {
	
	
	
	public static Bill createRepairingBill(Scanner scanner) {
		Bill bill = new Bill();
		System.out.println("Enter mobile number of a customer:");
		int mobile = scanner.nextInt();
		bill.setCustomer(CustomerService.selectCustomerByMobile(mobile));
		if(bill.getCustomer() == null) {
			return null;
		}
		System.out.println("Enter spare part price::");
		bill.setSparePartPrice ( scanner.nextDouble());
		bill.setMaintenanceLaborCharges(0);
		
		bill.setFinalBill( (bill.getSparePartPrice() + bill.getRepairingLaborCharges())*0.12 +
				bill.getSparePartPrice() + bill.getRepairingLaborCharges()) ;
		
		System.out.println("New bill=" + bill);
		
		return bill;
	}
	
	public static Bill createMaintenanceBill(Scanner scanner) {
		Bill bill = new Bill();
		System.out.println("Enter mobile number of a customer:");
		int mobile = scanner.nextInt();
		bill.setCustomer(CustomerService.selectCustomerByMobile(mobile));
		if(bill.getCustomer() == null) {
			return null;
		}
		
		bill.setRepairingLaborCharges(0);
		
		bill.setFinalBill( bill.getMaintenanceLaborCharges() *0.12 +
				           bill.getMaintenanceLaborCharges()) ;
		
		System.out.println("New bill=" + bill);
		
		return bill;
	}
	
	public static Bill engineOrGearOilBill(Scanner scanner) {
		Bill bill = new Bill();
		System.out.println("Enter mobile number of a customer:");
		int mobile = scanner.nextInt();
		bill.setCustomer(CustomerService.selectCustomerByMobile(mobile));
		if(bill.getCustomer() == null) {
			return null;
		}
		
		bill.setRepairingLaborCharges(0);
		bill.setMaintenanceLaborCharges(0);
		System.out.println("Enter engine or gear oil price::");
		bill.setEngineOrGearOilPrice ( scanner.nextDouble());
		System.out.println("Enter additive price::");
		bill.setAdditivePrice( scanner.nextDouble());
		
		bill.setFinalBill( bill.getEngineOrGearOilPrice() + bill.getAdditivePrice() +
				           (bill.getEngineOrGearOilPrice() + bill.getAdditivePrice()) * 0.12);
		
		System.out.println("New bill=" + bill);
		
		return bill;
	}

}
