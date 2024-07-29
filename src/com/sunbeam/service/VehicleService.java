package com.sunbeam.service;

import com.sunbeam.entities.Customer;
import com.sunbeam.entities.ServiceStation;
import com.sunbeam.entities.Vehicle;
import com.sunbeam.entities.VehicleModel;
import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class VehicleService {
    private static final String VEHICLE_FILE = "vehicles.dat";

    public static void inputVehicle(Vehicle vehicle, Scanner sc) {
 
        System.out.println("Enter customer mobile:");
        String phoneNumber = sc.next();
        Customer customer = CustomerService.findCustomerByPhoneNumber(phoneNumber);
        
        if (customer != null) {
            System.out.println("Enter Vehicle Number: ");
            vehicle.setVehicleNumber(sc.next());
            System.out.println("Enter Vehicle Model ID: ");
            int modelId = sc.nextInt();
            System.out.println("Enter Vehicle Manufacturer: ");
            String manufacturer = sc.next();
            System.out.println("Enter Vehicle Model Name: ");
            String modelName = sc.next();
            VehicleModel vehicleModel = new VehicleModel(modelId, manufacturer, modelName);
            vehicle.setVehicleModel(vehicleModel);

            customer.getVehicles().put(vehicle.getVehicleNumber(), vehicle);
            System.out.println("Vehicle added successfully.");
        } else {
            System.out.println("Customer not found.");
        }
    }
    
    public static void displayAllVehicles() {
        for (Customer cust : ServiceStation.servicestation.getCustomerList()) {
            System.out.println("Customer: " + cust.getName());
            for (Vehicle vehicle : cust.getVehicles().values()) {
                System.out.println(vehicle);
            }
        }
    }

    public static Vehicle findVehicleByVNumber(String vehicleNumber) {
        for (Customer customer : ServiceStation.servicestation.getCustomerList()) {
            Vehicle vehicle = customer.getVehicles().get(vehicleNumber);
            if (vehicle != null) {
                System.out.println("Vehicle found: " + vehicle);
                return vehicle;
            }
        }
        System.out.println("Vehicle not found.");
        return null;
    }

    public static void saveVehiclesToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(VEHICLE_FILE))) {
            oos.writeObject(ServiceStation.servicestation.getCustomerList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void editVehicle(String vehicleNumber, Scanner sc) {
        boolean found = false;
        for (Customer customer : ServiceStation.servicestation.getCustomerList()) {
            Vehicle vehicleToEdit = customer.getVehicles().get(vehicleNumber);
            if (vehicleToEdit != null) {
                System.out.print("Enter new Vehicle Number: ");
                String newVehicleNumber = sc.next();
                vehicleToEdit.setVehicleNumber(newVehicleNumber);
                System.out.print("Enter new Vehicle Model ID: ");
                int modelId = sc.nextInt();
                System.out.print("Enter new Vehicle Manufacturer: ");
                String manufacturer = sc.next();
                System.out.print("Enter new Vehicle Model Name: ");
                String modelName = sc.next();
                VehicleModel newModel = new VehicleModel(modelId, manufacturer, modelName);
                vehicleToEdit.setVehicleModel(newModel);

                System.out.println("Vehicle updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Vehicle not found.");
        }
    }
    public static void deleteVehicle(String vehicleNumber) {
        boolean found = false;
        for (Customer customer : ServiceStation.servicestation.getCustomerList()) {
            if (customer.getVehicles().remove(vehicleNumber) != null) {
                System.out.println("Vehicle removed successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Vehicle not found.");
        }
    }

    @SuppressWarnings("unchecked")
    public static void loadVehiclesFromFile() {
        File file = new File(VEHICLE_FILE);
        if (!file.exists()) {
            System.out.println("No existing vehicle file found.");
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            HashSet<Customer> loadedCustomers = (HashSet<Customer>) ois.readObject();
            ServiceStation.servicestation.setCustomerList(loadedCustomers);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
