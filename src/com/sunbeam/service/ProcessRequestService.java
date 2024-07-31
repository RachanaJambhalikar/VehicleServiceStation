package com.sunbeam.service;

import java.util.Scanner;

import com.sunbeam.entities.EngineOrGearOilChange;
import com.sunbeam.entities.MaintenanceOrRepairing;
import com.sunbeam.entities.ServiceRequest;
import com.sunbeam.entities.ServiceStation;

public class ProcessRequestService {
	
	
	public static void existingService(Scanner sc) {
		if (ServiceStation.servicestation == null) {
            return;
        }
        for (ServiceRequest serviceRequsets : ServiceStation.servicestation.getServiceRequests()) {
            System.out.println(serviceRequsets);
        }
    }
	
	public static void maintenance(Scanner sc) {
		MaintenanceOrRepairing maintenance = new MaintenanceOrRepairing();
		System.out.print("Enter labor charges: ");
        double laborCharges = sc.nextDouble();
        maintenance.setLaborCharges(laborCharges);
		
	}

	public static void repairing(Scanner sc) { 
		
		
	}

	public static void oilAdditiveChange(Scanner sc) {
        EngineOrGearOilChange oilChange = new EngineOrGearOilChange();

		System.out.print("Enter cost of oil/additive: ");
        double oilCost = sc.nextDouble();
        oilChange.setOilCost(oilCost);
        System.out.println("Oil/Additive change details: " + oilChange);
		
	}

}
