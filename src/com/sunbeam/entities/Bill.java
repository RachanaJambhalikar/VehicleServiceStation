package com.sunbeam.entities;

import java.time.LocalDate;

public class Bill
{
	private LocalDate date;
	private String customerName;
	private String billID;
	private ServiceRequest serviceRequest;
	private String paidAmount;
	private String totalAmount;
	
	public Bill(LocalDate date, String customerName, String billID, ServiceRequest serviceRequest, String paidAmount, String totalAmount) {

		this.date = date;
		this.customerName = customerName;
		this.billID = billID;
		this.serviceRequest = serviceRequest;
		this.paidAmount = paidAmount;
		this.totalAmount = totalAmount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getbillID() {
		return billID;
	}

	public void setbillID(String billID) {
		this.billID = billID;
	}

	public ServiceRequest getserviceRequest() {
		return serviceRequest;
	}

	public void setserviceRequest(ServiceRequest serviceRequest) {
		this.serviceRequest = serviceRequest;
	}

	public String getpaidAmount() {
		return paidAmount;
	}

	public void setpaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Bill [date=" + date + ", customerName=" + customerName + ", billID=" + billID
				+ ", serviceRequest=" + serviceRequest + ", paidAmount=" + paidAmount + ", totalAmount=" + totalAmount + "]";
	}
	
}
