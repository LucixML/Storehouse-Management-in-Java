
import java.util.ArrayList;
public class ProductList {
	private ArrayList<StockableProduct> list;
	private double totalCost;
	private double totalPrice;
	private double totalBenefit;
	//Constructores:
	public ProductList(ArrayList<StockableProduct>list) {
		setlist(list);
	}
	public ProductList() {
		this.list = new ArrayList<StockableProduct>();
		setTotalCost(calculateCost());
		setTotalPrice(calculatePrice());
		setTotalBenefit(calculateBenefit());
	}
	
	//Getters y setters:
	public ArrayList<StockableProduct> getlist() {
		return list;
	}
	public void setlist(ArrayList<StockableProduct> list) {
		this.list = list;
		this.calculateCost();
		this.calculatePrice();
		this.calculateBenefit();
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getTotalBenefit() {
		return totalBenefit;
	}
	public void setTotalBenefit(double totalBenefit) {
		this.totalBenefit = totalBenefit;
	}
	
	//Metodos:
	public double calculateCost() {
		for(int i=0; i<list.size(); i++){
           totalCost += list.get(i).getCostPerUnit() * list.get(i).getNumUnits();
        }
		return totalCost;
	}
	public double calculatePrice() {
		for(int i=0; i<list.size(); i++){
           totalPrice += list.get(i).getPricePerUnit() * list.get(i).getNumUnits();
        }
		return totalPrice;
	}
	public double calculateBenefit() {
		totalBenefit = totalPrice - totalCost;
		return totalBenefit;
	}
	public StockableProduct mostExpensiveProduct() {
		StockableProduct mostExpensive = new StockableProduct();
	    for(int i=0; i<list.size(); i++){
           if(mostExpensive.getPricePerUnit()<list.get(i).getPricePerUnit()){
			   mostExpensive = list.get(i);
		   }
        }
		return mostExpensive;	
	}
	public StockableProduct cheapestProduct() {
		StockableProduct cheaper = new StockableProduct();
	    for(int i=0; i<list.size(); i++){
           if(cheaper.getPricePerUnit()>list.get(i).getPricePerUnit()){
			   cheaper = list.get(i);
		   }
        }
		return cheaper;	
	}
	

	
	//toString y print
	public String toString() {
		String result = "";
	    for(int i=0; i<list.size(); i++){
	    	result = result + list.get(i).toString();
        }
		return result + "|" + totalCost + "|" + totalPrice + "|" + totalBenefit + "|\n" ;	
	}
	public void print(){
		System.out.print(this);
        	
	}
	
}