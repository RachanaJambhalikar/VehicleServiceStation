package com.sunbeam.operations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.entitires.Customer;
import com.sunbeam.entitires.Vehicle;
import com.sunbeam.entitires.VehicleModel;

public class CustomerOperations {

	/*public static void persistCustomerInFile(Customer newCustomer) {       
         
		try (FileOutputStream fileOut = new FileOutputStream("Customers.bin");
				ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
			out.writeObject(newCustomer);
			System.out.println(newCustomer + " is added to Customers.bin");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("new customer added" + newCustomer);
	}


	public static HashSet<Customer> loadCustomersFromFile() {
		try (FileInputStream fileIn = new FileInputStream("Customers.bin");
				ObjectInputStream in = new ObjectInputStream(fileIn)) {
			
			HashSet <Customer> customers = (HashSet <Customer>) in.readObject();
			/*for (Customer customer : customers)	
				System.out.println(customer);
			System.out.println("------------End of file--------------\n\n\n");
			
			return customers;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}*/

}
