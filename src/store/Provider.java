
import java.util.Scanner;
import java.io.*;
public class Provider{
	private int vat;
	private String name;
	private String taxAddress;
	private String contactProvider;
	
	//Constructores:
	public Provider(int vat, String name, String taxAddress, String contactProvider){
		setVat(vat);
		setName(name);
		setTaxAddress(taxAddress);
		setContactProvider(contactProvider);
	}
	public Provider(){
		this(0, "name", "taxAddress", "contactProvider");
	}
	
	//Setters y getters:
	public int getVat() {
		return vat;
	}
	public void setVat(int vat) {
		this.vat = vat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTaxAddress() {
		return taxAddress;
	}
	public void setTaxAddress(String taxAddress) {
		this.taxAddress = taxAddress;
	}
	public String getContactProvider() {
		return contactProvider;
	}
	public void setContactProvider(String contactProvider) {
		this.contactProvider = contactProvider;
	}
	public void set (String[] providerData){
	    setVat(Integer.parseInt(providerData[0]));
	    setName(providerData[1]);
	    setTaxAddress(providerData[2]);
	    setContactProvider(providerData[3]);	
	}
	
	//toString y print
	public String toString() {
		return vat + "|" + name + "|" + taxAddress + "|" + contactProvider + "|";
	}
	public void print(){
	  System.out.println(this);	  
	}
	
	//Lectura y escritura:
	public static Provider readFromStdio() {
		System.out.println("Setting new Provider");
		Provider result = new Provider();
		Scanner userInput = new Scanner(System.in);
        System.out.print("vat:");
        result.setVat(Integer.parseInt(userInput.next()));
        System.out.print("name:");
        result.setName(userInput.next());
		System.out.print("Tax addres:");
		result.setTaxAddress(userInput.next());
		System.out.print("Contact:");
		result.setContactProvider(userInput.next());		
	  
	  return result;
	}
	
	public static Provider readFromFile(String file){
	  Provider result = new Provider();
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