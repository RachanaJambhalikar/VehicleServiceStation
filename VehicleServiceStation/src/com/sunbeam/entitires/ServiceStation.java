package com.sunbeam.entitires;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.LinkedList;

import com.sunbeam.operations.CustomerOperations;

public class ServiceStation {
	
	private static final String FILE_NAME = "Customers.bin";
	
	public static ServiceStation serviceStation=new ServiceStation();
	private HashSet<Customer> customers;
	private LinkedList<Bill> bills;
	private double  repairingLaborCharges;
	private double  servicingLaborCharges;

    private ServiceStation() {
        customers = new HashSet<>();
        bills = new LinkedList<>();
        repairingLaborCharges = 100.00;
        servicingLaborCharges = 150.00;
    }
    
    
    public double getRepairingLaborCharges() {
		return repairingLaborCharges;
	}


	public void setRepairingLaborCharges(double repairingLaborCharges) {
		this.repairingLaborCharges = repairingLaborCharges;
	}


	public double getServicingLaborCharges() {
		return servicingLaborCharges;
	}


	public void setServicingLaborCharges(double servicingLaborCharges) {
		this.servicingLaborCharges = servicingLaborCharges;
	}


	public void addCustomer(Customer customer)
    {
    	 File file = new File(FILE_NAME);
         if (file.exists()) {
             // Read existing customers from the file
             try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            	 this.customers = (HashSet<Customer>) ois.readObject();
             } catch (IOException | ClassNotFoundException e) {
                 e.printStackTrace();
             }
         }
         
    	if(customer!=null) 
    		this.customers.add(customer);
    	
    	try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(customers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

	public HashSet<Customer> loadCustomersFromFile() {
		try (FileInputStream fileIn = new FileInputStream("Customers.bin");
				ObjectInputStream in = new ObjectInputStream(fileIn)) {
			
			HashSet <Customer> customers = (HashSet <Customer>) in.readObject();
			/*for (Customer customer : customers)	
				System.out.println(customer);
			System.out.println("------------End of file--------------\n\n\n");*/
			
			return customers;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public HashSet<SparePart> loadSparePartsFromFile() {
		try (FileInputStream fileIn = new FileInputStream("SpareParts.bin");
				ObjectInputStream in = new ObjectInputStream(fileIn)) {
			
			HashSet <SparePart> parts = (HashSet <SparePart>) in.readObject();
			
			return parts;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public HashSet<Customer> getCustomers() {
		return customers;
	}

	public LinkedList<Bill> getBills() {
		return bills;
	}
	
	public void setCustomers(HashSet<Customer> customers) {
			this.customers = customers;
	}
    
	public void writeCustomersToFile(HashSet<Customer> customers ) {
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Customers.bin"))) {
            oos.writeObject(customers);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
    
}
