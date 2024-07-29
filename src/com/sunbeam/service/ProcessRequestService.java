package com.sunbeam.service;

import java.util.Scanner;
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
		
		
	}

	public static void repairing(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	public static void oilAdditiveChange(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

}
