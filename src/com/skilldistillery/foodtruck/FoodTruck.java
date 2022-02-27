package com.skilldistillery.foodtruck;

public class FoodTruck {
	
	private static int lastIssuedId = 0;
	
	private int id;
	
	private String name;
	
	private String type;
	
	private int rating;
	
	public FoodTruck(String name, String type, int rating) {
		this.name = name;
		this.type = type;
		this.rating = rating;
		this.id = this.lastIssuedId + 1;
		this.lastIssuedId++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
