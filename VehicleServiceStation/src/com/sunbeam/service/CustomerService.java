package com.sunbeam.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import com.sunbeam.entitires.Customer;
import com.sunbeam.entitires.ServiceStation;
import com.sunbeam.entitires.Vehicle;
import com.sunbeam.entitires.VehicleModel;
import com.sunbeam.operations.CustomerOperations;

public class CustomerService {
	
	public static void inputCustomer(Customer customer,Scanner sc)
	{
		int option = 99;
		
		System.out.println("Enter Name ::");
		customer.setName(sc.next());
		System.out.println("Enter address ::");
		customer.setAddress(sc.next());
		System.out.println("Enter mobile ::");
		customer.setMobile(sc.nextInt());
		System.out.println("Enter Email ::");
		customer.setEmail(sc.next());
		while(option != 0) {
			System.out.println("Press 0 to exit. Press 1 to add a vehicle. ::");
			option = sc.nextInt();
			if(option == 0) {
				break;
			}
			
			System.out.println("Enter vehicle information ::");
			customer.inputVehicle(sc);
		}
	}
	
	public static void addNewVehicle(Customer customer,Scanner sc) {
		int option = 99;
		Customer updatedCustomer = customer;
		while(option != 0) {
			System.out.println("Press 0 to exit. Press 1 to add a vehicle. ::");
			option = sc.nextInt();
			if(option == 0) {
				deleteCustomer(customer.getMobile());
			}
			
			System.out.println("Enter vehicle information ::");
			updatedCustomer.inputVehicle(sc);
			System.out.println("Vehicle info updated  " + updatedCustomer );
			HashSet<Customer> customers = ServiceStation.serviceStation.getCustomers();
			customers.add(updatedCustomer);
			ServiceStation.serviceStation.writeCustomersToFile(customers);
			
		}		
	}
	
	/*public static void displayAllCustomers()
	{
		HashSet<Customer> customers = ServiceStation.serviceStation.getCustomers();
		for(Customer customer: customers)
			System.out.println(customer);
	}*/
	
	public static Customer selectCustomerByMobile(int mobile) {
		//HashSet<Customer> customers = ServiceStation.serviceStation.getCustomers();
		HashSet<Customer> customers = ServiceStation.serviceStation.loadCustomersFromFile();
		for(Customer customer : customers) {
			if(customer.getMobile() == mobile) {
				System.out.println("Customer found: " + customer);
				return customer;
			}
		}
		System.out.println("Customer with this mobile number is not found");
		return null;
	}
	
	public static void deleteCustomer(int mobile) {
		try {
			HashSet<Customer> customersToKeep = new HashSet<>();
			HashSet<Customer> customers = ServiceStation.serviceStation.loadCustomersFromFile();
			
			Customer customer = selectCustomerByMobile(mobile);
			
			//boolean removed = customers.remove(customer);
			
			for (Customer customerToKeep : customers) {
				if(customerToKeep.getMobile() != customer.getMobile())
					customersToKeep.add(customerToKeep);
				
			}
			System.out.println("Customer removed: " + customer);
			
			ServiceStation.serviceStation.setCustomers(customersToKeep);
			
			ServiceStation.serviceStation.writeCustomersToFile(customersToKeep);
			
			System.out.println("Remaining customers: " + customersToKeep);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static HashMap<String, Vehicle> getAllVehiclesOfaCustomer(int mobile) {
		 try {
			 Customer customer = new Customer();
			 customer = selectCustomerByMobile(mobile);
			 if(customer != null) {
				 System.out.println("All vehicles belonging to " + customer.getName() + "::" + customer.getVehicles());
				 
				 return customer.getVehicles();
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 return null;
	 }
	
	public static void editVehicle(int mobile, Scanner scanner) {
		try {
			Customer customer = selectCustomerByMobile(mobile);
			HashMap<String, Vehicle> vehicleList =  getAllVehiclesOfaCustomer(mobile);
			System.out.println("Enter vehicle number to edit::");
			String vnum = scanner.next();
			VehicleModel newVM = new VehicleModel(6,"Hero","karizma");
			Vehicle updatedVehicle = new Vehicle(vnum, newVM);
			
			for (String key : vehicleList.keySet()) {
	            if (key.equals(vnum)) {
	                vehicleList.put(key, updatedVehicle);
	                System.out.println("Vehicle with number " + key + " updated.");
	                break; 
	            }
	        }
			customer.setVehicles(vehicleList);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
