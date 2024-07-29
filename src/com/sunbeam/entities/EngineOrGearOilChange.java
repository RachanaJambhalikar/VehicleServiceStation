package com.sunbeam.entities;

public class EngineOrGearOilChange {

	private double oilCost;

	public double getOilCost() {
		return oilCost;
	}

	public void setOilCost(double oilCost) {
		this.oilCost = oilCost;
	}

	@Override
	public String toString() {
		return "EngineOrGearOilChange [oilCost=" + oilCost + "]";
	}
}
