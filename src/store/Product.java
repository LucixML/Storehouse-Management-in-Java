
import java.util.Scanner;
import java.io.*;
public class Product {
	private String name;
	private String brand;
	private String category;
	private boolean isCountable;
	private String measurementUnity;
	
	private static final String FOOD = "f";
	private static final String SUPPLIES = "s";
	private static final String EQUIPMENTS = "e";
	private static final String MISCELLANY = "m";
	
	//Constructores:
	public Product(String name, String brand, String category, boolean isCountable, String measurementUnity){
		setName(name);
		setBrand(brand);
		setCategory(category);
		setIsCountable(isCountable);
		setMeasurementUnity(measurementUnity);
	}
	public Product(){
		this("name", "brand", "category", false, "measurementUnity"); //El valor por defecto del boolean es false. En category a pesar de haber puesto ? se imprira m pues es su establecido valor por defecto en el set
	}
	
	//Setters y getters:
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		if(category == FOOD || category == SUPPLIES || category == EQUIPMENTS || category == MISCELLANY){
			this.category = category;}
		else{
			this.category = MISCELLANY;  //En un email como respues a si era necesaria una excepción aqui se establecio que este era el valor por defecto
		}
	}
	public boolean getIsCountable() {
		return isCountable;
	}
	public void setIsCountable(boolean isCountable) {
		this.isCountable = isCountable;
	}
	public String getMeasurementUnity() {
		return measurementUnity;
	}
	public void setMeasurementUnity(String measurementUnity) {
		this.measurementUnity = measurementUnity;
	}
	public void set (String[] productData){
	    setName(productData[0]);
		setBrand(productData[1]);
	    setCategory(productData[2]);
	    setIsCountable(Boolean.parseBoolean(productData[3]));
	    setMeasurementUnity(productData[4]);	
	}
	
	//toString y print
	public String toString() {
		return name + "|" + brand + "|" + category + "|" + isCountable + "|" + measurementUnity + "|";
	}
	public void print(){
	  System.out.println(this);	  
	}
	
	//Lectura y escritura:
	public static Product readFromStdio() {
		System.out.println("Setting new Product");
		Product result = new Product();
		Scanner userInput = new Scanner(System.in);
		System.out.print("name:");
        result.setName(userInput.next());
		System.out.print("Brand:");
		result.setBrand(userInput.next());	
        System.out.print("Category:");
        result.setCategory(userInput.next());
        System.out.print("Is Countable:");
        result.setIsCountable(Boolean.parseBoolean(userInput.next()));
		System.out.print("Measurement Unit:");
		result.setMeasurementUnity(userInput.next());
			
	  
	  return result;
	}
	
	public static Product readFromFile(String file){
	  Product result = new Product();
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