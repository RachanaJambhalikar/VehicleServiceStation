package com.sunbeam.entities;

public abstract class Service {
     
	protected int id;
	protected String type;
	protected double total_cost;
	protected String desc;
	
	public Service(){
	}
	
	public Service(int id, String type, double total_cost, String desc) {
		this.id=id;
		this.type=type;
		this.total_cost=total_cost;
		this.desc=desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(double total_cost) {
		this.total_cost = total_cost;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", type=" + type + ", total_cost=" + total_cost + ", desc=" + desc + "]";
	}
	
}
