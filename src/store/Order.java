
import java.util.ArrayList;
public class Order extends ProductList{
	private static int contador = 0;
	private int orderID;
	private String client;
	private String employee;
	
	//Constructores
	public Order(ArrayList<StockableProduct> list, String client, String employee){
		super(list);
		setClient(client);
		setEmployee(employee);
		orderID = contador;
		contador++;
	}
	public Order(){
		super();
		setClient(client);
		setEmployee(employee);
		orderID = contador;
		contador++;
	}	

	//Getters y setters:
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	
	//toString y print
	public String toString() {
		String result = "";
	    for(int i=0; i<super.getlist().size(); i++){
	    	result = orderID + "|" + super.toString() + "|" + client + "|" + employee + "|";
        }
		return result;	
	}
	public void print(){
		String result = "";
	    for(int i=0; i<super.getlist().size(); i++){
			result = orderID + "|" + super.toString() + "|" + client + "|" + employee + "|";
			System.out.println(result);
        }	
	}
}


	