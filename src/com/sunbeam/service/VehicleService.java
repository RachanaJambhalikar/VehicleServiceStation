package com.sunbeam.service;

import com.sunbeam.entities.Customer;
import com.sunbeam.entities.ServiceStation;
import com.sunbeam.entities.Vehicle;
import com.sunbeam.entities.VehicleModel;
import java.util.Scanner;

public class VehicleService {
	public static void inputVehicle(Vehicle vehicle, Scanner sc)
	{
		System.out.println("Enter customer mobile:");
		String mobile = sc.next();
		Customer c = CustomerService.findCustomerByMobile(mobile);
	if(c !=null) {	
		System.out.println("Enter Vehicle Number: ");
		vehicle.setVehicleNumber(sc.next());
		System.out.println("Enter Vehicle Model: ");
		vehicle.setVehicleModel(new VehicleModel(1, "Honda", "activa"));
		c.getVehicles().put(vehicle.getVehicleNumber(), vehicle);
	}
}
	
	public static void displayAllVehicles() 
	{
	    for (Customer cust : ServiceStation.servicestation.getCustomerList()) {
	        for (Vehicle vehicle : cust.getVehicles().values()) {
	           System.out.println(vehicle);
	        }
	    }
	}
	public static void deleteVehicle(String vehicleNumber) {
		boolean found = false;
		for (Customer customer : ServiceStation.servicestation.getCustomerList())
			for (Vehicle vehicle : customer.getVehicles().values()) {
				if (vehicle.getVehicleNumber().equals(vehicleNumber)) {
					customer.getVehicles().remove(vehicleNumber);
					System.out.println("Vehicle removed successfully.");
					found = true;
					break;
				}
			}
	}

    public static void editVehicle(String vehicleNumber, Scanner sc) {
       {        boolean found = false;
                Vehicle vehicleToEdit = null;

            for (Customer customer : ServiceStation.servicestation.getCustomerList()) {
                vehicleToEdit = customer.getVehicles().get(vehicleNumber);
                if (vehicleToEdit != null) {
                    found = true;
                	break;
                }
            }
            if (found) {
                System.out.print("New Vehicle Number: ");
                String newVehicleNumber = sc.nextLine();

                vehicleToEdit.setVehicleNumber(newVehicleNumber);

                System.out.println("Vehicle edited successfully.");
            
            }
       }
      }
       public static Vehicle findVehicleByVNumber(String vehicleNumber) {
    	    for (Customer customer : ServiceStation.servicestation.getCustomerList()) {
    	        Vehicle vehicle = customer.getVehicles().get(vehicleNumber);
    	        if (vehicle != null) {
    	            System.out.println("Vehicle found : " + vehicle);
    	        	return vehicle;
    	        }
    	    }
            System.out.println("Vehicle not found.");
    	    return null;
    	}
 




}