package com.sunbeam.tester;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import com.sunbeam.entitires.Customer;
import com.sunbeam.entitires.ServiceStation;
import com.sunbeam.entitires.Vehicle;
import com.sunbeam.entitires.VehicleModel;
import com.sunbeam.operations.CustomerOperations;
import com.sunbeam.operations.VehicleModelOperations;
import com.sunbeam.operations.vehicleOperations;
import com.sunbeam.service.CustomerService;
import com.sunbeam.service.VehicleService;

public class Menu {
	
	public Menu() {}
	
	public static Scanner scanner = new Scanner(System.in);
	public static void menuList1() {
				
		while(true) {
			System.out.println("----------Main Menu:-------");
            System.out.println("1. Customer");
            System.out.println("2. Vehicle");
            System.out.println("3. Vehicle Info");
            System.out.println("4. Service Request");
            System.out.println("0. Exit\n\n");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            if (choice==0){
            	System.exit(0);
            	break;
            }
            
            switch (choice) {
            case 0:
            	System.exit(0);
            	break;
            case 1:
                customerMenu(scanner);
                break;
            case 2:
                vehicleMenu(scanner);
                break;
            case 3:
                vehicleModelMenu(scanner);
                break;
            case 4:
            	serviceRequest(scanner);
            	break;
            default:
                System.out.println("Invalid choice. Please try again.");
            }
		}
	}
	
	public static void serviceRequest(Scanner scanner) {
		while(true) {
		 System.out.println("1. Selec customer from existing list of customers.");
		 System.out.println("2. Display customer's vehicle details.");
		 System.out.println("3. Input details of new vehicle and store it for future reference.");
		 System.out.println("0. Return to main menu");
		 
		 int choice = scanner.nextInt();
         
     	 int mobile = 0;
     	 if(choice == 0) {
     		 break;
     	 }
     	 
         switch(choice) {
         case 1:
        	 System.out.println("Enter mobile number of a customer:");
         	 mobile = scanner.nextInt();
         	 CustomerService.selectCustomerByMobile(mobile);
        	 break;
         case 2:
        	 System.out.println("Enter mobile number of customer to see his/her vehicles:");
         	 mobile = scanner.nextInt();
         	 CustomerService.getAllVehiclesOfaCustomer(mobile);
        	 break;
         case 3:
        	 System.out.println("Enter mobile number of customer to add new vehicles:");
         	 mobile = scanner.nextInt();
         	 CustomerService.addNewVehicle(CustomerService.selectCustomerByMobile(mobile), scanner);
        	 break;
         case 0:
        	 break;
         }
		}
	}
	
	public static void customerMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n\nCustomer Menu:");
            System.out.println("1. Add Customer");
            System.out.println("2. Display All Customers");
            System.out.println("3. Display Specific Customer Details");
            System.out.println("4. Edit Customer  ");
            System.out.println("5. Delete Customer  ");
            System.out.println("0. Return to main menu\n\n");
            System.out.println("Enter option: ");
            
            int choice = scanner.nextInt();
           
        	int mobile = 0;
        	
            switch(choice) {
            case 0:
            	menuList1();
            	break;
            case 1:
            	Customer customer=new Customer();
            	CustomerService.inputCustomer(customer,scanner);
            	ServiceStation.serviceStation.addCustomer(customer);
            	//CustomerOperations.persistCustomerInFile(customer);
            	
            	break;
            case 2: 
            	//CustomerService.displayAllCustomers();
            	//HashSet<Customer> customers = CustomerOperations.loadCustomersFromFile();
            	HashSet<Customer> customers = ServiceStation.serviceStation.loadCustomersFromFile();
            	for(Customer savedCustomer : customers){
            		System.out.println(savedCustomer);
            	}
            	break;
            	
            case 3:
            	System.out.println("Enter mobile number of a customer:");
            	mobile = scanner.nextInt();
            	CustomerService.selectCustomerByMobile(mobile);
            	break;
            case 4:
            	System.out.println("Enter mobile number of a customer:");
            	mobile = scanner.nextInt();
            	System.out.println("Enter new address:");
            	String newAddress = scanner.next();
            	Customer updateCustomer = CustomerService.selectCustomerByMobile(mobile);
            	updateCustomer.setAddress(newAddress);
            	break;
            case 5:
            	System.out.println("Enter mobile number of a customer to delete:");
            	mobile = scanner.nextInt();
            	CustomerService.deleteCustomer(mobile);
            	
            }
            
            if(choice == 0) {
            	break;
            }
        }
    }
	
	public static void vehicleMenu(Scanner scanner) {
		 while (true) {
	            System.out.println("\n\nVehicle Menu:");
	            //System.out.println("1. Add Vehicle");
	            //System.out.println("2. Display All Vehicles");
	            System.out.println("3. Display all the vehicles of a specific customer");
	            System.out.println("4. Edit Vehicle  ");
	            System.out.println("5. Delete Vehicle  ");
	            System.out.println("0. Return to main menu\n\n");
	            System.out.println("Enter option: ");
	            int choice = scanner.nextInt();
	            
	            int mobile = 0;
	            
	            switch(choice) {
	            case 0:
	            	menuList1();
	            	break;
	            	
	           /* case 1:
	            	Customer customer=new Customer();
	            	CustomerService.inputCustomer(customer,scanner);
	            	customer.inputVehicle(scanner);
	            	break;
	            case 2:
	            	vehicleOperations  op = new vehicleOperations();
	            	op.displayAllVehicles();
	            	break;*/
	            	
	            case 3:
	            	System.out.println("Enter mobile number of customer to see his/her vehicles:");
	            	mobile = scanner.nextInt();
	            	CustomerService.getAllVehiclesOfaCustomer(mobile);
	            	break;
	            case 4:
	            	System.out.println("Enter mobile number of customer to edit vehicles:");
	            	mobile = scanner.nextInt();
	            	CustomerService.editVehicle(mobile,  scanner);
	            	break;	
	            
	            }
	        }
	}
	
	public static void vehicleModelMenu(Scanner scanner) {
		 while (true) {
			 
			 	VehicleModelOperations obj = new VehicleModelOperations();
			 
	            System.out.println("Vehicle Model Menu:");
	            System.out.println("1. Add Vehicle Model");
	            System.out.println("2. Display All Vehicle models");
	            System.out.println("0. Exit");
	            System.out.println("Enter option: ");
	            int choice = scanner.nextInt();
	            
	            switch(choice) {
	            case 0:
	            	menuList1();
	            	break;
	            case 1:
	            	obj.addVehicleModels();
	            	break;
	            case 2:
	            	obj.readAllModels();
	            	break;
	            }
	            if(choice == 0) {
	            	break;
	            }
	        }
	}

}
