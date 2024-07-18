package com.sunbeam.entities;

import java.util.HashSet;
import java.util.Objects;

public class ServiceStation {
	
	public static ServiceStation servicestation=new ServiceStation();
	
	private HashSet<Customer> customerList;

	public HashSet<Customer> getCustomerList() {
		return customerList;
	}


	public void setCustomerList(HashSet<Customer> customerList) {
		this.customerList = customerList;
	}


	@Override
	public int hashCode() {
		return Objects.hash(customerList);
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
