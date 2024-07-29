package com.sunbeam.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Scanner;
import com.sunbeam.entities.Customer;
import com.sunbeam.entities.ServiceStation;


public class CustomerService {
	private static final String CUSTOMER_FILE = "customers.dat";
	
	public static void inputCustomerMobile(Customer customer,Scanner sc) {
    	System.out.println("Enter mobile number of customer: ");
    	customer.setPhoneNumber(sc.next());
	}
	
    public static void inputCustomer(Customer customer,Scanner sc) {
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
        for (Customer cust : ServiceStation.servicestation.getCustomerList()) {
            System.out.println(cust);
        }
    }
    public static Customer findCustomerByPhoneNumber(String phoneNumber) {
        for (Customer customer : ServiceStation.servicestation.getCustomerList()) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Customer found :" + customer);

                return customer;
            }
        }
        System.out.println("Customer not found.");
        return null; 
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
    public static void deleteCustomer(String phoneNumber) {
   	 boolean found = false;
        for (Customer customer : ServiceStation.servicestation.getCustomerList()) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
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

    public static void saveCustomersToFile() {
        File file = new File(CUSTOMER_FILE);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(ServiceStation.servicestation.getCustomerList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void loadCustomersFromFile() {
        File file = new File(CUSTOMER_FILE);
        if (!file.exists()) {
            System.out.println("No existing customer file found.");
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            ServiceStation.servicestation.setCustomerList((HashSet<Customer>) ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}