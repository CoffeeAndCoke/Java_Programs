/**
 * Inventory class that will hold Movie Objects
 * @author Edgar Jaimes
 * @version 1.1
 * 
 * */

package projectOne;

import java.io.*;
import java.util.*;

public class Inventory {

	/** ArrayList that will contain movie objects*/
	private ArrayList<Movie> inventory = new ArrayList<Movie>();
	
	/**Checks that there are no duplicates in the SKU
	 * @param SKU from a movie
	 * @return true if there is already a duplicate SKU, false otherwise*/
	public boolean duplicateChecker(int SKU){
		boolean sameSKU = false;
		
		for(int i = 0; i< inventory.size(); i++){
			if (SKU == inventory.get(i).getSKU()){
				sameSKU = true;
			}
		}
		
		return sameSKU;
	}
	
	/** Method to add an item to the ArrayList inventory
	 * @param Movie object to add to the ArrayList */
	public void addMovie(Movie movie){
		inventory.add(movie);	
	}
	
	/** Method that prints the details of the movies in the inventory.
	 *  Checks that there are elements on the list first*/
	public void displayContentsOfInventory(){
		
		//Check that the inventory is not empty
		if(inventory.size() == 0) {
			System.out.println("The inventory is empty. Please add an item first.");
		} else {
			int FIRST = 0;
			inventory.get(FIRST).displayTableFormat(); // Call a special display function
			
			for(int i = 0; i < inventory.size(); i++){
				inventory.get(i).printMovieDetails(); //display the contents of the Inventory
			}
		}
		
	}
	
	/** Method that removes a movie from the inventory 
	 * @param SKU to find movie in the inventory */
	public void removeMovie(int sku){
		boolean found = false;
		for(int i = 0; i< inventory.size(); i++){
			if (sku == inventory.get(i).getSKU()){
				inventory.remove(i);
				found = true;
				System.out.println("\nMovie successfully removed\n");
			}
		}
		if (found == false){
			System.out.println("\nError: invalid sku code!\n");
		}
	}
	
	/** Method that finds a movie to display the details
	 * @param SKU to find the movie in the inventory*/
	public void findMovie(int sku){
		boolean found = false;
		
		for(int i = 0; i < inventory.size(); i++){
			if (sku == inventory.get(i).getSKU()){
				int FIRST = 0;
				inventory.get(FIRST).displayTableFormat();
				inventory.get(i).printMovieDetails();
				found = true;
			}
		}
		if (found == false){
			System.out.println("\nError: No movie with that SKU found!\n");
		}
	}
	
	/** Method to serialize the inventory*/
	public void serialization(){
		try{			 
			FileOutputStream fOut = new FileOutputStream("movieInventory");
			ObjectOutputStream objectOut = new ObjectOutputStream(fOut);
			objectOut.writeObject(inventory);
			fOut.close();
		} 
		catch (IOException e) {
			 System.out.println("Problem with file output");
		}
	}
	
	
	/** Method to deserialize the inventory */
	public void deserialization(){
		try{
			FileInputStream fin = new FileInputStream("movieInventory");
			ObjectInputStream objectIn  = new ObjectInputStream(fin);
			@SuppressWarnings("unchecked")
			ArrayList<Movie> temp = (ArrayList<Movie>)objectIn.readObject();
			for (int i = 0; i < temp.size(); i++){
				inventory.add(temp.get(i));	
			}
			fin.close();
		
		}
		catch (FileNotFoundException e) {
			 System.out.println("Cannot find datafile.");
		} 
		catch (IOException e) {
			 System.out.println("Problem with file input.");
		} 
		catch (ClassNotFoundException e) {
			 System.out.println("Class not found on input from file.");
		}
	}
}
	

	

