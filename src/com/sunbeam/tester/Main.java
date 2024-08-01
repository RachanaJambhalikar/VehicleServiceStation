package com.sunbeam.tester;

import java.util.Collection;
import java.util.Scanner;
import com.sunbeam.entities.Customer;
import com.sunbeam.entities.ServiceRequest;
import com.sunbeam.entities.ServiceStation;
import com.sunbeam.entities.Vehicle;
import com.sunbeam.service.CustomerService;
import com.sunbeam.service.ProcessRequestService;
import com.sunbeam.service.ServiceRequestService;
import com.sunbeam.service.SparePartService;
import com.sunbeam.service.VehicleService;

public class Main {
	
	 private static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
               
	      int choice;
	        do {
	            choice = Menu.displayMainMenu(sc);
	            switch (choice) {
	                case 0:
	                    System.out.println("Exiting the application...");
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

	        do {
	            choice = Menu.customerMenu(sc);

	            switch (choice) {
	                case 0:
	                    System.out.println("Returning to main menu...");
	                    break;

	                case 1:
	                	System.out.println("Enter customer mobile number: ");
	                    Customer customer = new Customer();
	                    CustomerService.inputMobileNumber(customer,sc);
	                    CustomerService.inputCustomerDetails(customer, sc);
	                    ServiceStation.servicestation.getCustomerList().add(customer);
	                    System.out.println("Customer added successfully.");
	                    break;

	                case 2:
	                    System.out.println("List of all customers");
	                    CustomerService.displayAllCustomers();
	                    break;

	                case 3:
	                    System.out.print("Enter phone number of customer to display: ");
	                    String mobileNumberToDisplay = sc.next();
	                    CustomerService.findCustomerByMobileNumber(mobileNumberToDisplay);
	                    break;

	                case 4:
	                	System.out.print("Enter phone number of customer to edit: ");
	                    String mobileNumberToEdit = sc.next();
	                    CustomerService.editCustomer(mobileNumberToEdit, sc);
	                    break;

	                case 5:
	                	System.out.print("Enter phone number of customer to delete: ");
	                    String mobileNumberToDelete = sc.next();
	                    CustomerService.deleteCustomer(mobileNumberToDelete);
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
            return;
        }

        do {
        	choice = Menu.vehicleMenu(sc);           
            
            switch (choice) {
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                case 1:
                	System.out.println("Enter the customer mobile number: ");
                    String mobile = sc.next();
                    Vehicle vehicle = new Vehicle();
                    VehicleService.inputVehicle(vehicle, sc);
                    VehicleService.addVehicle(mobile, vehicle, sc);
                    break;
                case 2:
                    break;
                case 3:
                	System.out.print("Enter mobile number of customer: ");
                    break;
                case 4:System.out.print("Enter vehicle number of customer to edit: ");
                    
                    break;
                case 5:
                	System.out.print("Enter vehicle number of customer to delete: ");
                    
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);

    }
		
	private static void serviceRequestMenu(Scanner sc) {

        int choice = 0;        
        ServiceRequest serviceRequest =null;
        Customer customer=null;
        Vehicle vehicle=null;
        do {
            choice = Menu.serviceRequestMenu(sc);

            switch (choice) {
                case 0:
                    System.out.println("Returning to main menu...");
                    break;

                case 1:
                	customer =ServiceRequestService.selectCustomer(sc);
                	vehicle=ServiceRequestService.selectOrInputNewVehicle(customer, sc);
                	
                
                    break;

                case 2:         
                	processRequestMenu(customer,vehicle,sc);              	
                    break;

                case 3:
                    System.out.println("Prepare and display bill: ");
                    
                    break;

                case 4:
                    System.out.println("Get payment from customer: ");
                    
                    break;

                default:
                    System.out.println("Invalid choice.");
                    
                    break;
            }
        } while (choice != 0);

    }
	
	//SubMenu for Service request Menu
	private static void processRequestMenu(Customer cust,Vehicle veh,Scanner sc) {
        int choice;
        ServiceRequest serviceRequest =null;
        do {
            choice = Menu.processRequestMenu(sc);
            switch (choice) {
                case 0:
                    System.out.println("Returning to service request menu...");
                    break;
                case 1:
                	if(serviceRequest==null)
                	{
                		serviceRequest=new ServiceRequest(1,cust,veh);
                		ServiceStation.servicestation.getServiceRequests().add(serviceRequest);
                	}
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
	
	private static void partsMenu(Scanner sc) {
		int choice = 0;

        if (ServiceStation.servicestation == null) {
            return;
        }

        do {
        	choice = Menu.partsMenu(sc);           
            
            switch (choice) {
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                case 1:
                	SparePartService.addPart(sc);
                    break;
                case 2:
                    break;
                case 3:
                	System.out.print(" ");
                    break;
                case 4:System.out.print(" ");
                    
                    break;
                case 5:
                	System.out.print(" ");
                    
                    break;
                default:
                    System.out.println(" ");
                    break;
            }
        } while (choice != 0);

    }

	private static void todaysBusinessMenu(Scanner sc) {
		// TODO Auto-generated method stub
		
	}	
	private static void givenDateBusinessMenu(Scanner sc) {
		// TODO Auto-generated method stub
		
	}


}