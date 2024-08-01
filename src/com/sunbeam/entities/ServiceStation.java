package com.sunbeam.entities;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import com.sunbeam.exception.DataIOException;

public class ServiceStation {

    public static ServiceStation servicestation = new ServiceStation();

    public static final String CustomerFilePath = "customer.sun";
    public static final String ServiceRequsetFilePath = "servicerequests.sun";
    public static final String VehicleFilePath = "vehicles.sun";
    public static final String PartFilePath = "Parts.sun";

    private HashSet<Customer> customerList;
    private HashSet<ServiceRequest> serviceRequests;
    private HashSet<VehicleModel> vehicleModelsList;
    private ArrayList<SparePart> partList;

    public ServiceStation() {
        this.customerList = new HashSet<>();
        this.serviceRequests = new HashSet<>();
        this.vehicleModelsList = new HashSet<>();
        this.partList = new ArrayList<>();
    }

    public HashSet<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(HashSet<Customer> customerList) {
        this.customerList = customerList;
    }

    public HashSet<ServiceRequest> getServiceRequests() {
        return serviceRequests;
    }

    public HashSet<VehicleModel> getVehicleModelsList() {
        return vehicleModelsList;
    }

    public void setVehicleModelsList(HashSet<VehicleModel> vehicleModelsList) {
        this.vehicleModelsList = vehicleModelsList;
    }

    public ArrayList<SparePart> getPartList() {
        return partList;
    }

    public void setPartList(ArrayList<SparePart> partList) {
        this.partList = partList;
    }

    public void setServiceRequests(HashSet<ServiceRequest> serviceRequests) {
        this.serviceRequests = serviceRequests;
    }

    public void persistParts() {
        partList.add(new SparePart(1, "clutch", "The clutch is a part of the transmission system next to the crankshaft", 1000));
        partList.add(new SparePart(2, "battery", "The car battery is also an essential component of car as it provides the electricity to car", 4600));
        partList.add(new SparePart(3, "alternator", "It provides energy to the electrical components such as power steering systems, power windows", 3000));
        partList.add(new SparePart(4, "radiator", "Important part of the car engine’s cooling system, helps to drain out the excess heat from the engine", 4000));
        partList.add(new SparePart(5, "propeller shaft", "The power is transferred to the wheels using the propeller shaft. It is also called a driveshaft.", 5000));
        partList.add(new SparePart(6, "axles", "It is nothing but shafts, used to mount the wheels, two types namely, Front Axle and Rear Axle", 8000));
        partList.add(new SparePart(7, "timing belt", "Keeps the engine intake and exhaust valves open and close simultaneously in time with the pistons", 8000));
        partList.add(new SparePart(8, "seat", "Known as the saddle, is the part of the bike that the rider sits on.", 1000));
        storePartDetails();
        loadPartDetails();
    }

    public void storePartDetails() {
    	FileOutputStream fout = null;
    	ObjectOutputStream oout = null;
    	
        try {
        	fout= new FileOutputStream(PartFilePath);
        	oout= new ObjectOutputStream(fout);
            oout.writeObject(partList);
            oout.flush();
        } catch (Exception e) {
            throw new DataIOException("Failed to store part details", e);
        }finally {
        	try {
        		if (oout != null)
        			oout.close();
        		if (fout != null)
        			fout.close();
        		
        	}catch (Exception e2) {
        }
       } 	
    }

    public void loadPartDetails() {
    	FileInputStream fin = null;
    	ObjectInputStream oin = null;
    	
        try {
        	fin= new FileInputStream(PartFilePath);
        	oin= new ObjectInputStream(fin);
        	partList=(ArrayList<SparePart>)oin.readObject();
        	System.out.println("Part details loaded successfully");
        }catch (ClassNotFoundException e) {
        	System.out.println("Parts file not found");
        	System.out.println("Parts list is empty");
        	return;
        } catch (Exception e) {
            throw new DataIOException("Failed to store part details", e);
        }finally {
        	try {
        		if (oin != null)
        			oin.close();
        		if (fin != null)
        			fin.close();
        		
        	}catch (Exception e) {
        }
       } 	
    }
    public void persistVehicles() {
        vehicleModelsList.add(new VehicleModel(1, "Honda", "cb-unicorn"));
        vehicleModelsList.add(new VehicleModel(2, "Hero", "splender"));
        vehicleModelsList.add(new VehicleModel(3, "Honda", "activa"));
        vehicleModelsList.add(new VehicleModel(4, "Honda", "shine125"));
        vehicleModelsList.add(new VehicleModel(5, "Yamaha", "FZ160"));
        vehicleModelsList.add(new VehicleModel(6, "Hero", "karizma"));
        vehicleModelsList.add(new VehicleModel(7, "Honda", "Hornet"));
        vehicleModelsList.add(new VehicleModel(8, "TVS", "jupiter"));
        vehicleModelsList.add(new VehicleModel(9, "TVS", "apache160"));
        vehicleModelsList.add(new VehicleModel(10, "Bajaj", "pulsar"));
        storeVehicleModelDetails();
        loadVehicleModelDetails();
    }

    public void storeVehicleModelDetails() {
        try (FileOutputStream fout = new FileOutputStream(VehicleFilePath);
             ObjectOutputStream oout = new ObjectOutputStream(fout);) {
        	
            oout.writeObject(vehicleModelsList);
            oout.flush();
        } catch (Exception e) {
            throw new DataIOException("Failed to store vehicle model details", e);
        }
    }

    public void loadVehicleModelDetails() {
    	
        try (FileInputStream fin = new FileInputStream(VehicleFilePath);
             ObjectInputStream oin = new ObjectInputStream(fin)) {
        	
            vehicleModelsList = (HashSet<VehicleModel>) oin.readObject();
            System.out.println("Vehicle Model loaded successfully");
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Model not found");
            System.out.println("Vehicle models list is empty");
            return;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataIOException("Failed to load vehicle model details", e);
        }
    }

    public void storeCustomerList() {
        try (FileOutputStream fout = new FileOutputStream(CustomerFilePath);
             ObjectOutputStream oout = new ObjectOutputStream(fout);) {
        	
            oout.writeObject(customerList);
            oout.flush();
        } catch (Exception e) {
            throw new DataIOException("Failed to store customer list", e);
        }
    }

    public void loadCustomerList() {
        try (FileInputStream fin = new FileInputStream(CustomerFilePath);
             ObjectInputStream oin = new ObjectInputStream(fin)) {
        	
            customerList = (HashSet<Customer>) oin.readObject();
            System.out.println("Customer loaded successfully");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Customer list not found");
            System.out.println("Customer list is empty");
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataIOException("Failed to load customer list", e);
        }
    }

    public void storeServiceRequestDetails() {
        try (FileOutputStream fout = new FileOutputStream(ServiceRequsetFilePath);
             ObjectOutputStream oout = new ObjectOutputStream(fout)) {
            oout.writeObject(serviceRequests);
            oout.flush();
        } catch (IOException e) {
            throw new DataIOException("Failed to store service request details", e);
        }
    }

    public void loadServiceRequestDetails() {
        try (FileInputStream fin = new FileInputStream(ServiceRequsetFilePath);
             ObjectInputStream oin = new ObjectInputStream(fin)) {
            serviceRequests = (HashSet<ServiceRequest>) oin.readObject();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Service request details not found");
            System.out.println("Service requests list is empty");
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataIOException("Failed to load service request details", e);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerList);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ServiceStation other = (ServiceStation) obj;
        return Objects.equals(customerList, other.customerList);
    }

    @Override
    public String toString() {
        return "ServiceStation [customerList=" + customerList + "]";
    }
}
