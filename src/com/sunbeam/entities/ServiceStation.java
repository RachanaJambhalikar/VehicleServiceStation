package com.sunbeam.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;

public class ServiceStation implements Serializable {
    private static final long serialVersionUID = 1L;
	
	public static ServiceStation servicestation=new ServiceStation();
	private HashSet<Customer> customerList;
	private LinkedList<Bill> bills;
	private HashSet<ServiceRequest> serviceRequests;
	
	public ServiceStation() {
        customerList = new HashSet<>();
        bills = new LinkedList<>();
        this.serviceRequests=new HashSet<ServiceRequest>();
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
	@Override
	public int hashCode() {
		return Objects.hash(customerList);
	}


	public void setServiceRequests(HashSet<ServiceRequest> serviceRequests) {
		this.serviceRequests = serviceRequests;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceStation other = (ServiceStation) obj;
		return Objects.equals(customerList, other.customerList);
	}


	@Override
	public String toString() {
		return "ServiceStation [customerList=" + customerList + "]";
	}
	
	
	

}
