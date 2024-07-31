package com.sunbeam.service;

import java.util.Scanner;
import com.sunbeam.entities.Customer;
import com.sunbeam.entities.ServiceStation;


public class CustomerService {
	public static void inputMobileNumber(Customer customer,Scanner sc) {
    	System.out.println("Enter mobile number of customer: ");
    	customer.setMobileNumber(sc.next());
	}
	
    public static void inputCustomerDetails(Customer customer,Scanner sc) {
    	System.out.println("Enter name of customer: ");
    	customer.setName(sc.next());
    	System.out.println("Enter address of customer: ");
    	customer.setAddress(sc.next());
    }
    public static void displayAllCustomers() {
        if (ServiceStation.servicestation == null) {
            System.out.println("Service Station is not initialized.");
            return;
        }
        for (Customer customer : ServiceStation.servicestation.getCustomerList()) {
            System.out.println(customer);
        }
    }
    public static Customer findCustomerByMobileNumber(String mobileNumber) {
        for (Customer customer : ServiceStation.servicestation.getCustomerList()) {
            if (customer.getMobileNumber().equals(mobileNumber)) {
                System.out.println("Customer found :" + customer);

                return customer;
            }
        }
        System.out.println("Customer not found.");
        return null; 
    }

    public static void editCustomer(String mobileNumber, Scanner sc) {
        Customer customerToEdit = null;
        for (Customer customer : ServiceStation.servicestation.getCustomerList()) {
            if (customer.getMobileNumber().equals(mobileNumber)) {
                customerToEdit = customer;
                break;
            }
        }
        if (customerToEdit != null) {
            inputCustomerDetails(customerToEdit, sc);
            inputMobileNumber(customerToEdit, sc);
            System.out.println("Customer edited successfully.");
        } else {
            System.out.println("Customer not found.");
        }
    }
    public static void deleteCustomer(String mobileNumber) {
   	 boolean found = false;
        for (Customer customer : ServiceStation.servicestation.getCustomerList()) {
            if (customer.getMobileNumber().equals(mobileNumber)) {
                ServiceStation.servicestation.getCustomerList().remove(customer);
                System.out.println("Customer deleted successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Customer not found.");
        }
    }

}