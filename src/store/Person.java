
import java.util.Scanner;
import java.io.*;
public class Person{
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	
	//Constructores:
	public Person(int id, String firstName, String lastName, String email){
	    setId(id);
        setFirstName(firstName);
        setLastName(lastName);
		setEmail(email);
	 }
	public Person(){
	    this(0, "firstName", "lastName", "email");
	}
	
	//Setters y getters:
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void set (String[] personData){
	    setId(Integer.parseInt(personData[0]));
	    setFirstName(personData[1]);
	    setLastName(personData[2]);
	    setEmail(personData[3]);	
	}
	
	//toString y print
	public String toString() {
		return id + "|" + firstName + "|" + lastName + "|" + email + "|";
	}
	public void print(){
	  System.out.println(this);	  
	}
	
	//Lectura y escritura:
	public static Person readFromStdio() {
		System.out.println("Setting new Person");
		Person result = new Person();
		Scanner userInput = new Scanner(System.in);
        System.out.print("Id:");
        result.setId(Integer.parseInt(userInput.next()));
        System.out.print("First Name:");
        result.setFirstName(userInput.next());
		System.out.print("Last Name:");
		result.setLastName(userInput.next());
		System.out.print("email:");
		result.setEmail(userInput.next());		
	  
	  return result;
	}
	
	public static Person readFromFile(String file){
	  Person result = new Person();
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