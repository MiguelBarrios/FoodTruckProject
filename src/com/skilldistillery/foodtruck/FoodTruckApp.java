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
		
		int userSelection;
		do{
			app.displayMenu();
			System.out.print("Selection: ");
			userSelection = scanner.nextInt();
			System.out.println();
			
			if(userSelection == 1) {
				app.listFoodTrucks();
			}
			else if(userSelection == 2) {
				app.displayAverageFoodTruckRating();
			}
			else if(userSelection == 3) {
				app.displayHighestRatedTruck();
			}
			else if(userSelection == 4) {
				System.out.println("GoodBye!");
				break;
			}
			else {
				System.out.println("Invalid selction");
			}
			
		}while(userSelection != 4);

	}

	public void getTruckDataFromUser(Scanner scanner) {
		for (int i = 0; i < MAX_NUM_TRUCKS; ++i) {
			FoodTruck foodTruck = getFoodTruckInfo(scanner);
			if (foodTruck == null)
				break;

			this.trucks[numberOfTrucks] = foodTruck;
			++numberOfTrucks;
		}
	}
	
	public FoodTruck getFoodTruckInfo(Scanner scanner) {
		System.out.print("Enter name of truck or quit to exit: ");
		String name = scanner.nextLine();
		if (name.equalsIgnoreCase("Quit")) {
			return null;
		}
		System.out.print("Enter food type: ");
		String type = scanner.nextLine();
		System.out.print("Enter rating: ");
		double rating = scanner.nextDouble();
		scanner.nextLine();

		return new FoodTruck(name, type, rating);
	}
	
	public void displayMenu() {
		System.out.println("\nSelect from the following");
		System.out.println("1) List all existing food trucks");
		System.out.println("2) Show average food truck rating");
		System.out.println("3) Show highest-rated food truck");
		System.out.println("4) Quit");
	}
	
	public void listFoodTrucks() {
		System.out.println("Existing Food Trucks");
		for (int i = 0; i < this.numberOfTrucks; ++i) {
			System.out.println(trucks[i]);
		}
	}
	
	public void displayAverageFoodTruckRating() {
		double sum = 0;
		for (int i = 0; i < this.numberOfTrucks; ++i) {
			sum += this.trucks[i].getRating();
		}
		double average = sum / this.numberOfTrucks;
		System.out.println("Average Rating: " + average);
	}

	public void displayHighestRatedTruck() {
		double highestRating = 0;
		// Find highest Rating
		for (int i = 0; i < this.numberOfTrucks; ++i) {
			if (this.trucks[i].getRating() > highestRating) {
				highestRating = this.trucks[i].getRating();
			}
		}

		// show trucks with highest rating
		System.out.println("Highest Rated Trucks");
		for (int i = 0; i < this.numberOfTrucks; ++i) {
			if (trucks[i].getRating() == highestRating) {
				System.out.println(trucks[i]);
			}
		}

	}
}
