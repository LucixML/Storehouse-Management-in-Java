package store;

import java.util.Scanner;
public class StoreManager { 
	private String name;
	private int stockCost;
	private int stockBenefit;
	// ProductList stock = new ProductList();
	
	//Constructores:
	public StoreManager(String name, int stockCost, int stockBenefit){
		setName(name);
		setStockCost(stockCost);
		setStockBenefit(stockBenefit);
		// setStock(stock);
	}	
	public StoreManager(){
	}	
	
	//Setters y getters:
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStockCost() {
		return stockCost;
	}
	public void setStockCost(int stockCost) {
		this.stockCost = stockCost;
	}
	public int getStockBenefit() {
		return stockBenefit;
	}
	public void setStockBenefit(int stockBenefit) {
		this.stockBenefit = stockBenefit;
	}
	// public ProductList getStock() {
		// return stock;
	// }
	// public void setStock(ProductList stock) {
		// this.stock = stock;
	// }
	
	//toString y print
	public String toString() {
		return name + "|" + stockCost + "|" + stockBenefit + "|";	
	}
	public void print(){
		System.out.println(this);
	}
	
	//Menu:
	Scanner sn = new Scanner(System.in);
	boolean done2 = false;
	int opcion2;
	
	public void manage(String instruction){
		while(!done2){
			System.out.println();
			System.out.println("--------Manage " +instruction+ " Menu--------");
			System.out.println();
			System.out.println( "1.-Insert "+instruction);
			System.out.println( "2.-Remove "+instruction);
			System.out.println( "3.-Modify "+instruction);
			System.out.println( "4.-Search "+instruction);
			System.out.println( "5.-Print "+instruction);
			System.out.println( "0.-Exit application");    
			System.out.println("opcion>");  
			opcion2 = sn.nextInt();
		
			while(opcion2<0 || opcion2>4){
				System.out.println();
				System.out.println("--------Manage " +instruction+ " Menu--------");
				System.out.println();
				System.out.println( "1.-Insert "+instruction);
				System.out.println( "2.-Remove "+instruction);
				System.out.println( "3.-Modify "+instruction);
				System.out.println( "4.-Search "+instruction);
				System.out.println( "5.-Print "+instruction);				
				System.out.println( "0.-Exit application");    
				System.out.println("opcion>");  
				opcion2 = sn.nextInt();
			}
		
		
			switch (opcion2) {
				case 1:
					System.out.println("--------Manage " +instruction+ " Menu--------");
					System.out.println();
					sm.insert(instruction);
					
				break;
				
				case 2:
					System.out.println("--------Manage " +instruction+ " Menu--------");
					System.out.println();
					sm.remove(instruction);
				break;
				
				case 3:
					System.out.println("--------Manage " +instruction+ " Menu--------");
					System.out.println();
					sm.modify(instruction);
				break;
				
				case 4:
					System.out.println("--------Manage " +instruction+ " Menu--------");
					System.out.println();
					sm.search(instruction);
				break;
				
				case 5:
					System.out.println("--------Manage " +instruction+ " Menu--------");
					System.out.println();
					System.out.println("Printing " + instruction);
				break;
				
				case 0:
					done2 = true;
				break;
			}
		}
	}
}