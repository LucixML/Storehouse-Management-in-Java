
import java.util.ArrayList;
import java.util.Scanner;
import store.StoreManager;
public class RunApp {
	public static void main (String[] args){
		Scanner sn = new Scanner(System.in);
		boolean done = false;
		int opcion;
		
		StoreManager F = new StoreManager();
		F.print();
		
		String storeInfo = "StoreInfo: Store name:"+ F.getName() + "\nStock cost:"+ F.getStockCost() + "\nStock benefit:"+ F.getStockBenefit();
		
		while (!done) {
			System.out.println();
			System.out.println("--------MainMenu--------");
			System.out.println(storeInfo);
			System.out.println();
			System.out.println( "1.-Create Store");
			System.out.println( "2.-Manage Stock");
			System.out.println( "3.-Manage Orders (To process)");
			System.out.println( "4.-Manage Orders (Processed)");        
			System.out.println( "5.-Manage Clients");    
			System.out.println( "6.-Manage Providers");  
			System.out.println( "7.-Manage Employees");
			System.out.println( "8.-Print Store Info");  
			System.out.println( "9.-Testing");  
			System.out.println( "0.-Exit application");
			System.out.println("opcion>");
			opcion = sn.nextInt();
			
			while (opcion<0 || opcion>9 ){
				System.out.println();
				System.out.println("--------MainMenu--------");
				System.out.println(storeInfo);
				System.out.println();
				System.out.println( "1.-Create Store");
				System.out.println( "2.-Manage Stock");
				System.out.println( "3.-Manage Orders (To process)");
				System.out.println( "4.-Manage Orders (Processed)");        
				System.out.println( "5.-Manage Clients");    
				System.out.println( "6.-Manage Providers");  
				System.out.println( "7.-Manage Employees");
				System.out.println( "8.-Print Store Info");  
				System.out.println( "9.-Testing");  
				System.out.println( "0.-Exit application");
				System.out.println("opcion>");
				opcion = sn.nextInt();
			}
			
            switch (opcion) {
                case 1:
					System.out.println("--------Create Store Menu--------");
					System.out.println("Has creado una tienda");
                break;
				
                case 2:
                    F.manage("Stock");
				break;
				
                case 3:
                    F.manage("Orders To Be Processed");
                break;
				
                case 4:
                    F.manage("Orders Processed");
                break;
				
                case 5:
					F.manage("Clients");
				break;
				
                case 6 :
                    F.manage("Providers");
                break;
				
                case 7:
                    F.manage("Employees");
                break;
				
                case 8:
                    System.out.println("--------Store Info Menu--------");
                    System.out.println(storeInfo);
                break;
				
                case 9:
					System.out.println("--------Testing Menu--------");
                    System.out.println("El programara procedera a hacer testing");
                break;
				
                case 0:
                    done = true;
                break;
            }
				
				
		}
	}
            	
}