package com.sunbeam.service;

public class CustomerService {
	private String newService;
	private String existingService;
	
	public CustomerService(String newService, String existingService) {
		this.newService = newService;
		this.existingService = existingService;
	}

	public String getNewService() {
		return newService;
	}

	public void setNewService(String newService) {
		this.newService = newService;
	}

	public String getExistingService() {
		return existingService;
	}

	public void setExistingService(String existingService) {
		this.existingService = existingService;
	}

	@Override
	public String toString() {
		return "CustomerService [newService=" + newService + ", existingService=" + existingService + "]";
	}

}