package com.sunbeam.entities;

public class Part {
	    private int partId;
	    private String name;
	    private double price;

	    public Part(int partId, String name, double price) {

			this.partId = partId;
			this.name = name;
			this.price = price;
}

		public int getPartId() {
			return partId;
		}

		public void setPartId(int partId) {
			this.partId = partId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "Part [partId=" + partId + ", name=" + name + ", price=" + price + "]";
		}
}
