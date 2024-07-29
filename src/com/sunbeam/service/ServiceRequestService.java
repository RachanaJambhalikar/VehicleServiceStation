package com.sunbeam.service;

import java.util.Map;
import java.util.Scanner;
import com.sunbeam.entities.Customer;
import com.sunbeam.entities.Vehicle;

public class ServiceRequestService {

    public static Customer selectCustomer(Scanner sc) {
        System.out.print("Enter customer mobile: ");
        String phoneNumber = sc.next();
        Customer customer = CustomerService.findCustomerByPhoneNumber(phoneNumber);
        if (customer == null) {
            System.out.println("Customer not found.");
        }
        return customer;
    }
    
    public static Vehicle selectOrInputNewVehicle(Customer customer, Scanner sc) {
        Map<String, Vehicle> vehicles = customer.getVehicles();
        Vehicle selectedVehicle=null;
        if (!vehicles.isEmpty()) {
            for (Map.Entry<String, Vehicle> entry : vehicles.entrySet()) {
            }
            System.out.print("Enter the vehicle number or press 0 for a new vehicle: ");
              String input = sc.next(); 

            if (input.trim().equals("0")) {
            	selectedVehicle=new Vehicle();
                VehicleService.inputVehicle(selectedVehicle, sc);
                return selectedVehicle;
            } else {
            	selectedVehicle = vehicles.get(input);
            	
                    return selectedVehicle;  
            }
        } 
        return selectedVehicle;
    }


}
