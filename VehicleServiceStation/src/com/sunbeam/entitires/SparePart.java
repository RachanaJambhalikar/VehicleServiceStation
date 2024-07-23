package com.sunbeam.entitires;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;

public class SparePart  implements Serializable{
	
	private int id;
	private String sparePartName;
	private String sparePartDescription;
	private double sparePartPrice;
	
	public SparePart(){
		
	}
	
	public SparePart(int id, String sparePartName, String sparePartDescription, double sparePartPrice) {
		super();
		this.id = id;
		this.sparePartName = sparePartName;
		this.sparePartDescription = sparePartDescription;
		this.sparePartPrice = sparePartPrice;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSparePartName() {
		return sparePartName;
	}
	public void setSparePartName(String sparePartName) {
		this.sparePartName = sparePartName;
	}
	public String getSparePartDescription() {
		return sparePartDescription;
	}
	public void setSparePartDescription(String sparePartDescription) {
		this.sparePartDescription = sparePartDescription;
	}
	public double getSparePartPrice() {
		return sparePartPrice;
	}
	public void setSparePartPrice(double sparePartPrice) {
		this.sparePartPrice = sparePartPrice;
	}
	
	@Override
	public String toString() {
		return "SparePart [id=" + id + ", sparePartName=" + sparePartName + ", sparePartDescription="
				+ sparePartDescription + ", sparePartPrice=" + sparePartPrice + "]";
	}
	
	public static void writeSparePartsToFile( ) {
		HashSet<SparePart> parts = new HashSet<>();
		parts.add(new SparePart(1,"clutch","The clutch is a part of the transmission system next to the crankshaft",1000.00));
		parts.add(new SparePart(2,"battery","The car battery is also an essential component of car as it provides the electricity to car",4600));
		parts.add(new SparePart(3,"alternator","It provides energy the electrical components such as power steering systems,power windows",3000));
		parts.add(new SparePart(4,"radiator","important part of the car engine’s cooling system,helps to drain out the excess heat from the engine",4000));

		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SpareParts.bin"))) {
            oos.writeObject(parts);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
