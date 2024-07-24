package com.sunbeam.entities;

import java.util.Date;

public class ServiceRequest {
	private String requestId;
    private Date serviceDate;
    
		public ServiceRequest() {
	    }
				
		public ServiceRequest(String requestId, Date serviceDate) {
			this.requestId = requestId;
			this.serviceDate = serviceDate;
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
 }
