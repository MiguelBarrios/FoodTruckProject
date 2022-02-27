package com.skilldistillery.foodtruck;

import java.util.Scanner;

public class FoodTruckApp {
	
	private final int MAX_NUM_TRUCKS = 5;
	
	private FoodTruck[] trucks = new FoodTruck[MAX_NUM_TRUCKS];
	
	private int numberOfTrucks = 0;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		FoodTruckApp app = new FoodTruckApp();
		app.getTruckDataFromUser(scanner);
		
		app.displayTrucks();
		

	}
	
	public void displayTrucks() {
		for(int i = 0; i < this.numberOfTrucks; ++i) {
			System.out.println(this.trucks[i]);
		}
	}
	
	public FoodTruck getFoodTruckInfo(Scanner scanner) {
		System.out.print("Enter name of truck or quit to exit: ");
		String name = scanner.nextLine();
		if(name.equalsIgnoreCase("Quit")){
			return null;
		}
		System.out.print("Enter food type: ");
		String type = scanner.nextLine();
		System.out.print("Enter rating: ");
		int rating = scanner.nextInt();
		scanner.nextLine();
		
		return new FoodTruck(name, type, rating);
	}
	
	public void getTruckDataFromUser(Scanner scanner) {
		for(int i = 0; i < MAX_NUM_TRUCKS; ++i) {
			FoodTruck foodTruck = getFoodTruckInfo(scanner);
			if(foodTruck == null)
				break;
			
			this.trucks[numberOfTrucks] = foodTruck;
			++numberOfTrucks;
		}
		
	}

	

}
