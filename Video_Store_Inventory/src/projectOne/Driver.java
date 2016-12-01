/**
 * Java program that simulates an inventory of movie
 * @author Edgar Jaimes & Ryan Felan
 * @version 1.1
 * 
 * 
 * *
 */

package projectOne;

import java.io.*;
import java.util.*;

public class Driver {
	
	public static void main(String[] args){
		
		//Constant User Choices for Menu
		final int ONE = 1;
		final int TWO = 2; 
		final int THREE = 3;
		final int FOUR = 4;
		final int FIVE = 5;
		
		//The program will run until the user inputs 5
		boolean run = true;
		
		
		//creating new scanner
		Scanner in = new Scanner(System.in);
				
		//Create a new inventory object 
		Inventory inventory = new Inventory();
		
		//Deserialize the object file
		inventory.deserialization();
		
		//Variables required for movie object
		int SKU = 0 , quanity = 0, sku = 0;//duplicate = 0;
		float price = 0;
		String title = " ";
		
		//Variables required for user input
		int input = 0;
		//char dupAns = 'n'; 
		
		while(run) {
			
			//Menu
			System.out.println("\nVideo Store Inventory Menu\n");			
			System.out.println("1. Add Movie");
			System.out.println("2. Remove Movie");
			System.out.println("3. Find Movie by SKU");
			System.out.println("4. Display inventory");
			System.out.println("5. Quit the Program\n");
			System.out.print("Enter your choice: ");
			
			try {
				
				//Read input from the user
				input = in.nextInt();
				
				//If the user entered an invalid choice, ask to try again
				while (input > 5 || input <= 0){
					System.out.println("\nInvalid Input\n");
					System.out.println("-------------------------"
										+ "-------------------");
					System.out.println("\nVideo Store Inventory Menu\n");			
					System.out.println("1. Add Movie");
					System.out.println("2. Remove Movie");
					System.out.println("3. Find Movie by SKU");
					System.out.println("4. Display inventory");
					System.out.println("5. Quit the Program\n");
					System.out.print("Enter your choice: ");
					in.nextLine();
					
					//Read the new choice
					input = in.nextInt();
				}
				
				//Menu selection 1
				if (input == ONE){
					System.out.print("Enter the SKU: ");
					SKU = in.nextInt();
					
					//Check that the SKU is not in the inventory
					//duplicate = inventory.duplicateChecker(SKU);
					
					
					if (inventory.duplicateChecker(SKU)){
						System.out.println("Warning, movie with duplicate SKU already in inventory.");
//						System.out.print("Please Enter 'Y' or 'y' to replace old"
//								+ " SKU with new, or 'N' or 'n' to cancel: ");
//						dupAns = in.next().charAt(0);
//						
//						
//						while (dupAns != 'y' && dupAns != 'Y' && 
//								dupAns != 'n' && dupAns != 'N'){
//							System.out.println("\nInvalid input!\n");
//							System.out.print("Please Enter Y to replace old"
//									+ " SKU with new, or N to cancel: ");
//							dupAns = in.next().charAt(0);
//						}
//						if (dupAns == 'n'){
//							throw new IOException("\nInventory input canceled");
//						}
					} else {
							System.out.print("Enter the quantity: ");
							quanity = in.nextInt();
							if (quanity < 0){
								throw new IOException("\nError: quantity must be >= 0\n");
							}
							
							System.out.print("Enter the price: ");
							price = in.nextFloat();
							if (price < 0){
								throw new IOException("\nError: price must be >= 0\n");
							}
							
							in.nextLine();
							System.out.print("Enter the title: ");
							title = in.nextLine();
							
							inventory.addMovie(new Movie(SKU, quanity, price, title));
						}
					
					}
					//Menu Selection 2
					if (input == TWO){
						System.out.print("Enter the sku of the Movie to remove:");
						sku = in.nextInt();
						inventory.removeMovie(sku);
					}
					
					//Menu Selection 3
					if (input == THREE){
						System.out.print("Enter the sku of the Movie to find:" );
						sku = in.nextInt();
						inventory.findMovie(sku);
					}
					
					//Menu Selection 4
					if(input == FOUR){
						
						inventory.displayContentsOfInventory();
					}	
					
					//Menu Selection 5
					if(input == FIVE) {
						System.out.println("Exit Selected");
						run = false;
				}
			}
			catch(IOException a){
				System.out.println(a.getMessage());
			}
			catch (InputMismatchException e){
				System.out.println("\nError: Invalid input\n");
				in.nextLine();
			}
			
			System.out.println("--------------------------------------------");
		}
		
		inventory.serialization(); // serialize the inventory 
		in.close(); // close the scanner
	}
}

