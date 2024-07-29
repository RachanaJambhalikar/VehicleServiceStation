package com.sunbeam.tester;

import java.util.HashSet;
import java.util.Scanner;
import com.sunbeam.entities.Customer;
import com.sunbeam.entities.ServiceRequest;
import com.sunbeam.entities.ServiceStation;
import com.sunbeam.entities.Vehicle;
import com.sunbeam.service.CustomerService;
import com.sunbeam.service.ProcessRequestService;
import com.sunbeam.service.ServiceRequestService;
import com.sunbeam.service.VehicleService;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (ServiceStation.servicestation == null) {
            ServiceStation.servicestation = new ServiceStation();
            ServiceStation.servicestation.setCustomerList(new HashSet<>());
        }
        CustomerService.loadCustomersFromFile();
	      int choice;
	        do {
	            choice = Menu.displayMainMenu(sc);
	            switch (choice) {
	                case 0:
	                    System.out.println("Exiting the application...");
	                    CustomerService.saveCustomersToFile();
	                    break;
	                case 1:
	                	customerMenu(sc);
	                    break;
	                case 2:
	                	vehicleMenu(sc);
	                    break;
	                case 3:
	                	serviceRequestMenu(sc);
	                    break;
	                case 4:
	                	partsMenu(sc);
	                    break;
	                case 5:
	                	todaysBusinessMenu(sc);
	                    break;
	                case 6:
	                    givenDateBusinessMenu(sc);
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        } while (choice != 0);
	        sc.close();
	}

	private static void customerMenu(Scanner sc) {
	        int choice = 0;

	        if (ServiceStation.servicestation == null) {
	            System.out.println("Service Station is not initialized.");
	            return;
	        }

	        do {
	            choice = Menu.customerMenu(sc);

	            switch (choice) {
	                case 0:
	                    System.out.println("Returning to main menu...");
	                    break;

	                case 1:
	                	System.out.println("Enter details for adding customer ");
	                    Customer customer = new Customer();
	                    CustomerService.inputCustomer(customer, sc);
	                    ServiceStation.servicestation.getCustomerList().add(customer);
	                    CustomerService.saveCustomersToFile();
	                    System.out.println("Customer added successfully.");
	                    break;

	                case 2:
	                    System.out.println("List of all customers");
	                    CustomerService.displayAllCustomers();
	                    break;

	                case 3:
	                    System.out.print("Enter phone number of customer to display: ");
	                    String mobileNumberToDisplay = sc.next();
	                    CustomerService.findCustomerByPhoneNumber(mobileNumberToDisplay);
	                    break;

	                case 4:
	                	System.out.print("Enter phone number of customer to edit: ");
	                    String mobileNumberToEdit = sc.next();
	                    CustomerService.updateCustomer(mobileNumberToEdit, sc);
	                    CustomerService.saveCustomersToFile(); 
	                    break;

	                case 5:
	                	System.out.print("Enter phone number of customer to delete: ");
	                    String mobileNumberToDelete = sc.next();
	                    CustomerService.deleteCustomer(mobileNumberToDelete);
	                    CustomerService.saveCustomersToFile(); 
	                    break;

	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }
	        } while (choice != 0);
	    }
	private static void vehicleMenu(Scanner sc) {
        int choice = 0;

        if (ServiceStation.servicestation == null) {
            System.out.println("Service Station is not initialized.");
            return;
        }

        do {
        	choice = Menu.vehicleMenu(sc);           
            
            switch (choice) {
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                case 1:
                	Vehicle vehicle = new Vehicle();
                	VehicleService.inputVehicle(vehicle, sc);
                	 System.out.println("Customer added successfully.");
                    break;
                case 2:
                    System.out.println("Displaying all vehicles...");
                    VehicleService.displayAllVehicles();
                    break;
                case 3:
                	System.out.print("Enter vehicle number of customer to edit: ");
                    String vehicleNumberToEdit = sc.next();
                    VehicleService.editVehicle(vehicleNumberToEdit, sc);
                    break;
                case 4:
                	System.out.print("Enter vehicle number of customer to delete: ");
                    String vehicleNumberToDelete = sc.next();
                    VehicleService.deleteVehicle(vehicleNumberToDelete);
                    break;
                case 5:
                	System.out.print("Enter vehicle number of customer to display: ");
                    String vehicleNumberToDisplay = sc.next();
                    VehicleService.findVehicleByVNumber(vehicleNumberToDisplay);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);
    }
		
	private static void serviceRequestMenu(Scanner sc) {
        int choice = 0;        
        ServiceRequest serviceRequest = new ServiceRequest();
        do {
            choice = Menu.serviceRequestMenu(sc);

            switch (choice) {
                case 0:
                    System.out.println("Returning to main menu...");
                    break;

                case 1:
                	ServiceRequestService.inputServiceRequest(serviceRequest, sc);
                    break;

                case 2:
                    System.out.println("Process service request...");
                    
                    break;

                case 3:
                    System.out.println("Prepare and display bill...");
                    
                    break;

                case 4:
                    System.out.println("Get payment from customer...");
                    
                    break;

                case 5:
                    System.out.println("Oil/Additive change...");

                    break;

                default:
                    System.out.println("Invalid choice.");
                    
                    break;
            }
        } while (choice != 0);
    }
	private static void processRequestMenu(Scanner sc) {
        int choice;
        do {
            choice = Menu.processRequestMenu(sc);
            switch (choice) {
                case 0:
                    System.out.println("Returning to service request menu...");
                    break;
                case 1:
                	ProcessRequestService.newService(sc);
                    break;
                case 2:
                	ProcessRequestService.existingService(sc);
                    break;
                case 3:
                	ProcessRequestService.maintenance(sc);
                    break;
                case 4:
                	ProcessRequestService.repairing(sc);
                    break;
                case 5:
                	ProcessRequestService.oilAdditiveChange(sc);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
	private static void givenDateBusinessMenu(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	private static void todaysBusinessMenu(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	private static void partsMenu(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

}