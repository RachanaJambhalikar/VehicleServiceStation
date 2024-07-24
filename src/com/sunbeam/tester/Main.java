package com.sunbeam.tester;

import java.util.Scanner;

import com.sunbeam.entities.Customer;
import com.sunbeam.entities.ServiceStation;
import com.sunbeam.entities.Vehicle;
import com.sunbeam.service.CustomerService;
import com.sunbeam.service.VehicleService;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
	                    Customer customer = new Customer();
	                    CustomerService.inputCustomer(customer, sc);
	                    ServiceStation.servicestation.getCustomerList().add(customer);
	                    System.out.println("Customer added successfully.");
	                    break;

	                case 2:
	                    System.out.println("Displaying all customers...");
	                    CustomerService.displayAllCustomers();
	                    break;

	                case 3:
	                    System.out.print("Enter phone number of customer to display: ");
	                    String phoneNumberToDisplay = sc.next();
	                    CustomerService.findCustomerByMobile(phoneNumberToDisplay);
	                    break;

	                case 4:
	                    System.out.print("Enter phone number of customer to delete: ");
	                    String phoneNumberToDelete = sc.next();
	                    CustomerService.deleteCustomer(phoneNumberToDelete);
	                    break;

	                case 5:
	                    System.out.print("Enter phone number of customer to edit: ");
	                    String phoneNumberToEdit = sc.next();
	                    CustomerService.updateCustomer(phoneNumberToEdit, sc);
	                    break;

	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
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

	private static void serviceRequestMenu(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	private static void vehicleMenu(Scanner sc) {
		// TODO Auto-generated method stub
		
	}}