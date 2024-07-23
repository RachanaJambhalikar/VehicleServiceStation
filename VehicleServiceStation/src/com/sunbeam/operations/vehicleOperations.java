package com.sunbeam.operations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.entitires.Vehicle;
import com.sunbeam.entitires.VehicleModel;

public class vehicleOperations {

	private static final int ArrayList = 0;

	public void addAVehicle(Vehicle v) {
		try (FileOutputStream fileOut = new FileOutputStream("Vehicles.bin");
	             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
	            out.writeObject(v);
	            System.out.println(v + " Vehicle has been saved to Vehicles.bin");
	        } catch (IOException e) {
	            e.printStackTrace();
	    }	
	}
	
	public void displayAllVehicles() {
		try (FileInputStream fileIn = new FileInputStream("vehicles.bin");
	             ObjectInputStream in = new ObjectInputStream(fileIn)) {
	            
	            while (true) {
	                try {
	                    Vehicle vehicle = (Vehicle) in.readObject();
	                    System.out.println(vehicle);
	                } catch (IOException e) {
	                    break; 
	                }
	            }
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }				
	}
}
