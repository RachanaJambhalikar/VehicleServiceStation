package com.sunbeam.service;

import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import com.sunbeam.entities.Customer;
import com.sunbeam.entities.ServiceRequest;
import com.sunbeam.entities.ServiceStation;
import com.sunbeam.entities.Vehicle;
import com.sunbeam.entities.VehicleModel;

public class ServiceRequestService {
	
//Display existing list of customers
    public static void displayAllExistingCustomers() {
        if (ServiceStation.servicestation == null) {
            return;
        }
        if (ServiceStation.servicestation.getCustomerList().isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        for (Customer cust : ServiceStation.servicestation.getCustomerList()) {
            System.out.println(cust);
        }
    }
    
//Select customer by customer phone number
    public static Customer selectCustomer(Scanner sc) {
        System.out.print("Enter customer mobile: ");
        String phoneNumber = sc.next();
        Customer customer = CustomerService.findCustomerByPhoneNumber(phoneNumber);
        if (customer == null) {
            System.out.println("Customer not found.");
        }
        return customer;
    }

//Select vehicle or Add new vehicle    
    public static Vehicle selectOrInputNewVehicle(Customer customer, Scanner sc) {
        Map<String, Vehicle> vehicles = customer.getVehicles();

        if (!vehicles.isEmpty()) {
            System.out.println("Select a vehicle by number:");
            for (Map.Entry<String, Vehicle> entry : vehicles.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.print("Enter the vehicle number for a new vehicle: ");
            String input = sc.next();

            if (input.equalsIgnoreCase("new")) {
                return inputNewVehicle(sc, customer);
            } else {
                Vehicle selectedVehicle = vehicles.get(input);
                if (selectedVehicle != null) {
                    return selectedVehicle;
                } else {
                    System.out.println("Vehicle not found.");
                    return null;
                }
            }
        } else {
            System.out.println("No vehicles found for customer.");
            return inputNewVehicle(sc, customer);
        }
    }

//Getting details for new vehicle    
    private static Vehicle inputNewVehicle(Scanner sc, Customer customer) {
        System.out.print("Enter vehicle number: ");
        String vehicleNumber = sc.nextLine();
        System.out.print("Enter vehicle model ID: ");
        int modelId = sc.nextInt();
        System.out.print("Enter vehicle manufacturer: ");
        String manufacturer = sc.nextLine();
        System.out.print("Enter vehicle model name: ");
        String modelName = sc.nextLine();

        VehicleModel model = new VehicleModel(modelId, manufacturer, modelName);
        Vehicle vehicle = new Vehicle(vehicleNumber, model);
        customer.getVehicles().put(vehicleNumber, vehicle);
        System.out.println("Vehicle added successfully.");
        return vehicle;
    }

    
    public static void inputServiceRequest(ServiceRequest serviceRequest, Scanner sc) {
        displayAllExistingCustomers();
        Customer customer = selectCustomer(sc);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        Vehicle vehicle = selectOrInputNewVehicle(customer, sc);
        if (vehicle == null) {
            System.out.println("No vehicle found or selected for the customer.");
            return;
        }

        serviceRequest.setCustomer(customer);
        serviceRequest.setVehicle(vehicle);
        serviceRequest.setServiceDate(new Date());

        System.out.println("Service Request created successfully:" + serviceRequest);
    }
}
