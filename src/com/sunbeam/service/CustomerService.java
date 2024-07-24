package com.sunbeam.service;

import java.util.Scanner;
import com.sunbeam.entities.Customer;
import com.sunbeam.entities.ServiceStation;


public class CustomerService {
	
    public static void inputCustomer(Customer customer,Scanner sc) {
    	System.out.println("Enter name ::");
    	customer.setName(sc.next());
    	System.out.println("Enter address ::");
    	customer.setAddress(sc.next());
    	System.out.println("Enter mobile ::");
    	customer.setPhoneNumber(sc.next());
    }
    public static void displayAllCustomers()
    {
    	for(Customer cust:ServiceStation.servicestation.getCustomerList())
    		System.out.println(cust);
    }

    public static void deleteCustomer(String phoneNumber) {
    	 boolean found = false;
         for (Customer customer : ServiceStation.servicestation.getCustomerList()) {
             if (customer.getPhoneNumber().equals(phoneNumber)) {
                 ServiceStation.servicestation.getCustomerList().remove(customer);
                 System.out.println("Customer removed successfully.");
                 found = true;
                 break;
             }
         }
         if (!found) {
             System.out.println("Customer not found.");
         }
     }
    public static void updateCustomer(String phoneNumber, Scanner sc) {
        Customer customerToUpdate = null;
        for (Customer customer : ServiceStation.servicestation.getCustomerList()) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                customerToUpdate = customer;
                break;
            }
        }
        if (customerToUpdate != null) {
            inputCustomer(customerToUpdate, sc);
            System.out.println("Customer updated successfully.");
        } else {
            System.out.println("Customer not found.");
        }
    }
    public static Customer findCustomerByMobile(String mobile) {
        for (Customer customer : ServiceStation.servicestation.getCustomerList()) {
            if (customer.getPhoneNumber().equals(mobile)) {
                System.out.println("Customer found :" + customer);

                return customer;
            }
        }
        System.out.println("Customer not found.");
        return null; 
    }
}