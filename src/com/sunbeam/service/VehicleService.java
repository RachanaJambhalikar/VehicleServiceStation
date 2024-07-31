package com.sunbeam.service;

import com.sunbeam.entities.Customer;
import com.sunbeam.entities.ServiceStation;
import com.sunbeam.entities.Vehicle;
import com.sunbeam.entities.VehicleModel;
import java.util.HashSet;
import java.util.Scanner;

public class VehicleService {
	
    public static void inputVehicle(Vehicle vehicle, Scanner sc) {
    	
        System.out.println("Enter Vehicle Number: ");
        vehicle.setVehicleNumber(sc.next());
  
        System.out.println("Select Vehicle model and manufacturer: ");
        HashSet<VehicleModel>vehicleModels=ServiceStation.servicestation.getVehicleModelsList();
        for(VehicleModel vehicleModel:vehicleModels) 
        {
        	System.out.println(vehicleModel);
        }
        
        VehicleModel[] vehicleModel = vehicleModels.toArray(new VehicleModel[vehicleModels.size()]);
      for(VehicleModel vm1: vehicleModel)
    	  System.out.println(vm1);
      vehicle.setVehicleModel(vehicleModel[sc.nextInt()-1]);
    }
    
    public static void addVehicleToCustomer(String mobileNumber, Vehicle vehicle, Scanner sc) {
      CustomerService customerService = new CustomerService();
      Customer customer=customerService.findCustomerByMobileNumber(mobileNumber);
      
      System.out.println("Enter Vehicle number: ");
      vehicle.setVehicleNumber(sc.next());
      
      
      
      
      
      
      
      
    }
      
    public static void displayAllVehicles(Customer customer) {
        if (customer != null) {
            HashSet<Vehicle> vehicles = new HashSet<>(customer.getVehicles().values());
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        } else {
            System.out.println("No vehicles found.");
        }
    }

    public static Vehicle findVehicleByVNumber(Customer customer, String vehicleNumber) {
        if (customer != null) {
            return customer.getVehicles().get(vehicleNumber);
        }
        return null;
    }

    public static void editVehicle(Customer customer, String vehicleNumber, Scanner sc) {
        Vehicle vehicle = findVehicleByVNumber(customer, vehicleNumber);
        if (vehicle != null) {
            System.out.println("Editing vehicle: " + vehicle);
            inputVehicle(vehicle, sc);
            customer.getVehicles().put(vehicleNumber, vehicle);
            System.out.println("Vehicle updated successfully.");
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    public static void deleteVehicle(Customer customer, String vehicleNumber) {
        if (customer != null && customer.getVehicles().remove(vehicleNumber) != null) {
            System.out.println("Vehicle removed successfully.");
        } else {
            System.out.println("Vehicle not found.");
        }
    }
}