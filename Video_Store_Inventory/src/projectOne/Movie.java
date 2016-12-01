/** Movie class for movie objects. Contains SKU, Quantity, Price and Title
 * @author Edgar Jaimes & Ryan Felan
 * @version 1.1
 * 
 * */
package projectOne;

import java.io.Serializable;

public class Movie implements Serializable {

	private int SKU;
	private int quantity;
	private float price;
	private String title; 
	
	/** Movie constructor 
	 * @param newSKU takes in the SKU for the movie
	 * @param newQuant takes in the quantity for the movie
	 * @param newPrice for the price of the movie
	 * @param newTitle for the movie title*/
	public Movie(int newSKU, int newQuant, float newPrice, String newTitle){
		
		this.SKU = newSKU;
		this.quantity = newQuant;
		this.price = newPrice;
		this.title = newTitle;
	}
	
	
	/** Special table when displaying movie details*/
	public void displayTableFormat(){
		System.out.println("\nSKU" + "\t" +
							"Quanity" + "\t" +
							"Price" + "\t" +
							"Title");
		System.out.println("---" + "\t" +
							"-------" + "\t" +
							"-----" + "\t" +
							"-----");

	}
	
	/** Special list format for printing to console*/
	public void displayListFormat() {
		System.out.println("\nSKU" + "\t" +
							"Quantity" + "\t" +
							"Price" + "\t" +
							"Title");
		System.out.println("---" + "\t" +
							"-------" + "\t" +
							"-----" + "\t" +
							"-----");
	}
	
	/** Special list display for movie details*/
	public void printMovieDetails(){
			System.out.print(SKU + "\t" + 
					quantity + "\t$");
			System.out.printf("%.2f", price);
			System.out.print("\t" +title);
			System.out.println();
	}
	
	/** Method for getting SKU movie
	 *  @return movie SKU*/
	public int getSKU() {
		return SKU;
	}
	
//	public int getQuantity(){
//		return quantity;
//	}
}
