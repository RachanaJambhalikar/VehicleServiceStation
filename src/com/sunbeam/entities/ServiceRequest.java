package com.sunbeam.entities;

import java.util.Date;
import java.util.LinkedList;

public class ServiceRequest {
	private String requestId;
	private Date serviceDate;
    private LinkedList<Service> services;
    private Customer customer;
    private Vehicle vehicle;

		public ServiceRequest() {
	    }
				
		public ServiceRequest(String requestId, Date serviceDate) {
			this.requestId = requestId;
			this.serviceDate = serviceDate;
			this.services = new LinkedList<>();
		}

		public String getRequestId() {
			return requestId;
		}

		public void setRequestId(String requestId) {
			this.requestId = requestId;
		}

		public Date getServiceDate() {
			return serviceDate;
		}

		public void setServiceDate(Date serviceDate) {
			this.serviceDate = serviceDate;
		}

		public LinkedList<Service> getServices() {
			return services;
		}

		public void setServices(LinkedList<Service> services) {
			this.services = services;
		}
		 public Customer getCustomer() {
				return customer;
			}

			public void setCustomer(Customer customer) {
				this.customer = customer;
			}

			public Vehicle getVehicle() {
				return vehicle;
			}

			public void setVehicle(Vehicle vehicle) {
				this.vehicle = vehicle;
			}

			@Override
			public String toString() {
				return "ServiceRequest [requestId=" + requestId + ", serviceDate=" + serviceDate + ", services="
						+ services + ", customer=" + customer + ", vehicle=" + vehicle + "]";
			}
 }
