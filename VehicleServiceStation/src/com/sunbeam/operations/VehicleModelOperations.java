package com.sunbeam.operations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.entitires.VehicleModel;

public class VehicleModelOperations {
	
	public void addVehicleModels() {
		List<VehicleModel> models = new ArrayList<>();
		models.add(new VehicleModel(1,"Honda","cb-unicorn"));
		models.add(new VehicleModel(2,"Hero","splender"));
		models.add(new VehicleModel(3,"Honda","activa"));
		models.add(new VehicleModel(4,"Honda","shine125"));
		models.add(new VehicleModel(5,"Yamaha","FZ160"));
		models.add(new VehicleModel(6,"Hero","karizma"));
		models.add(new VehicleModel(7,"Honda","Hornet"));
		models.add(new VehicleModel(8,"TVS","jupiter"));
		models.add(new VehicleModel(9,"TVS","apache160"));
		models.add(new VehicleModel(10,"Bajaj","pulsar"));
		
		System.out.println("models:" + models);
		
		try (FileOutputStream fileOut = new FileOutputStream("VehicleModels.bin");
	             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
	            out.writeObject(models);
	            System.out.println("Vehicle models have been saved to vehicleModels.bin");
	        } catch (IOException e) {
	            e.printStackTrace();
	    }
		
	}
	
	public void readAllModels() {
		try (FileInputStream fileIn = new FileInputStream("vehicleModels.bin");
	             ObjectInputStream in = new ObjectInputStream(fileIn)) {
	            ArrayList<VehicleModel> modelsList = (ArrayList<VehicleModel>) in.readObject();
	            System.out.println("All Vehicle Models:");
	            for (VehicleModel vehicle : modelsList) {
	                System.out.println(vehicle);
	            }
	            System.out.println("------------End of file--------------\n\n\n");
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }		
	}
}
