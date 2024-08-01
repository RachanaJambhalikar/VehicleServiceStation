package com.sunbeam.service;

import com.sunbeam.entities.Customer;
import com.sunbeam.entities.ServiceStation;
import com.sunbeam.entities.Vehicle;
import com.sunbeam.entities.VehicleModel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class VehicleService {
	
    public static void inputVehicle(Vehicle vehicle, Scanner sc) {
    	ServiceStation.servicestation.loadVehicleModelDetails();
    	
        System.out.println("Enter Vehicle Number: ");
        vehicle.setVehicleNumber(sc.next());
  
        System.out.println("Select Vehicle model and manufacturer: ");
        
        HashSet<VehicleModel>vehicleModelsList=ServiceStation.servicestation.getVehicleModelsList();
        VehicleModel[] vehicleModels = vehicleModelsList.toArray(new VehicleModel[vehicleModelsList.size()]);
        
        for (int i = 0; i < vehicleModels.length; i++) {
            System.out.println((i + 1) + " " + vehicleModels[i]);
        }
        
        System.out.print("Enter your choice : ");
        int modelIndex = sc.nextInt() - 1;

        if (modelIndex >= 0 && modelIndex < vehicleModels.length) {
            vehicle.setVehicleModel(vehicleModels[modelIndex]);
        
        }
    }
    
    public static void addVehicle(String mobileNumber, Vehicle vehicle, Scanner sc) {
        CustomerService customerService = new CustomerService();
        Customer customer = customerService.findCustomerByMobileNumber(mobileNumber);

        if (customer != null) {
            customer.getVehicles().put(vehicle.getVehicleNumber(), vehicle);
            ServiceStation.servicestation.storeVehicleModelDetails();

            System.out.println("Vehicle added successfully.");
        } else {
           
        }
    }

    public static HashMap<String, Vehicle> getVehicles(String mobileNumber) {
        CustomerService customerService = new CustomerService();
        Customer customer = customerService.findCustomerByMobileNumber(mobileNumber);
        return customer != null ? customer.getVehicles() : null;
    }

    public static void displayAllVehicles() {

    }

    public static void editVehicle(Customer customer, String vehicleNumber, Scanner sc) {
      
    }

    public static void deleteVehicle(Customer customer, String vehicleNumber) {
        if (customer != null && customer.getVehicles().remove(vehicleNumber) != null) {
            System.out.println("Vehicle removed successfully.");
        } else {
            System.out.println("Vehicle not found.");
        }
    }
}