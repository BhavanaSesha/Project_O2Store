package com.mindtree.Project_O2Store.core.entity;

public class Plants {
	private int plantId;
	private String plantName;
	private String plantDisplayName;
	private int price;
	public Plants() {
		super();
		
	}

	public Plants(int plantId, String plantDisplayName, int price) {
		super();
		this.plantId = plantId;
		this.plantDisplayName = plantDisplayName;
		this.price = price;
	}

	public Plants(int plantId, String plantName, String plantDisplayName, int price) {
		super();
		this.plantId = plantId;
		this.plantName = plantName;
		this.plantDisplayName = plantDisplayName;
		this.price = price;
	}
	public int getPlantId() {
		return plantId;
	}
	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}
	public String getPlantName() {
		return plantName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	public String getPlantDisplayName() {
		return plantDisplayName;
	}
	public void setPlantDisplayName(String plantDisplayName) {
		this.plantDisplayName = plantDisplayName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Plants [plantId=" + plantId + ", plantName=" + plantName + ", plantDisplayName=" + plantDisplayName
				+ ", price=" + price + "]";
	}

}


