
import java.util.Scanner;
import java.io.*;
public class StockableProduct extends Product {
	private static int contador = 0;
	private int productID; 
	private int numUnits;
	private double costPerUnit;
	private double pricePerUnit;
	
	//Contructores:
	public StockableProduct(String name, String brand, String category, boolean isCountable, String measurementUnity, int numUnits, double costPerUnit, double pricePerUnit){
		super(name, brand, category, isCountable, measurementUnity);
		setNumUnits(numUnits);
		setCostPerUnit(costPerUnit);
		setPricePerUnit(pricePerUnit);
		productID = contador;
		contador++;
	}	
	public StockableProduct(){
		this("name", "brand", "category", false, "measurementUnity", 0, 0.0, 0.0);
		productID = contador;
		contador++;
	}
	
	//Setters y getters:
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getNumUnits() {
		return numUnits;
	}
	public void setNumUnits(int numUnits) {
		this.numUnits = numUnits;
	}
	public double getCostPerUnit() {
		return costPerUnit;
	}
	public void setCostPerUnit(double costPerUnit) {
		this.costPerUnit = costPerUnit;
	}
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	public void set (String[] StockableProductData){
	    setProductID(Integer.parseInt(StockableProductData[0]));
		setNumUnits(Integer.parseInt(StockableProductData[1]));
	    setCostPerUnit(Double.parseDouble(StockableProductData[2]));
	    setPricePerUnit(Double.parseDouble(StockableProductData[3]));	
	}
	
	//toString y print
	public String toString() {
		return productID + "|" + super.toString() + "|" +  numUnits + "|" + costPerUnit + "|" + pricePerUnit + "|" ;
	}
	public void print(){
	  System.out.println(this);	  
	}
	
	//Entrada y salida:
	public static StockableProduct readFromStdio() {
		System.out.println("Setting new Stockable Product");
		StockableProduct result = new StockableProduct();
		Scanner userInput = new Scanner(System.in);
        System.out.print("Product ID:");
        result.setProductID(Integer.parseInt(userInput.next()));
        System.out.print("Num units:");
        result.setNumUnits(Integer.parseInt(userInput.next()));
		System.out.print("Cost unit:");
		result.setCostPerUnit(Double.parseDouble(userInput.next()));
		System.out.print("Price Unit");
		result.setPricePerUnit(Double.parseDouble(userInput.next()));		
	  
	  return result;
	}
	
	public static StockableProduct readFromFile(String file){
	  StockableProduct result = new StockableProduct();
	  BufferedReader in = null;
	  String line = null;
	  if(file!=null){
	    try{
		  in = new BufferedReader(new FileReader(file));
	      if((line=in.readLine())!= null){
	        String[] data = line.split("\\|");
		    result.set(data);
			return result;
		  }
	    }
		catch(IOException ioe){
		  ioe.printStackTrace(); 
		  System.exit(1);
		}
	  }
	  return result;
 	}
	
	public void writeToFile(String file){
	  BufferedWriter out = null;
      try{
	    if(file!=null){
		  out = new BufferedWriter(new FileWriter(file, true));
		  out.write(toString());
		  out.flush();
		  out.close();
		}
      }catch(IOException ioe){
		ioe.printStackTrace(); //to debug
		System.exit(1);
      }	  
	}
	
}