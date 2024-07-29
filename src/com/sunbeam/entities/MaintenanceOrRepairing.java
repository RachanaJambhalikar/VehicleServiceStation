package com.sunbeam.entities;

import java.util.LinkedList;

public class MaintenanceOrRepairing {

	private double laborCharges;
	private LinkedList<SparePart> partlist;
	
	public MaintenanceOrRepairing() {
		this.setLaborCharges(0);
		this.setPartlist(new LinkedList<>());
		}

	public double getLaborCharges() {
		return laborCharges;
	}

	public void setLaborCharges(double laborCharges) {
		this.laborCharges = laborCharges;
	}
	public LinkedList<SparePart> getPartlist() {
		return partlist;
	}

	public void setPartlist(LinkedList<SparePart> partlist) {
		this.partlist = partlist;
	}
}
	
