import java.util.Scanner;

public class UiDriver {

	public static void main(String[] args) {
		
		//TODO Add login function
		//TODO Add functionality to Admin users
		//TODO Connect case statements with SystemShell API
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Library System!");
		System.out.println("------------------------------" + "\n");
		boolean login = false;
		while(login == false) {
			System.out.println("1. Login");
			System.out.println("2. Create Account");
		
			int loginChoice = scan.nextInt();
			switch (loginChoice) {
			case 1: 
        		System.out.println("\n" + "Logging in is not set up yet." + "\n");
        		login = true;
            	break;
        	case 2: 
        		System.out.println("\n" + "Account creation is not set up yet." + "\n");
        		login = true;
            	break;
			}
		}
		
		
		boolean run = true;
		while(run == true) {
			System.out.println("Please choose an operation." + "\n");
			System.out.println("1. View Account Information");
			System.out.println("2. Search for an Item");
			System.out.println("3. Return an Item");
			System.out.println("4. Exit Library System");
			
			
			int choice = scan.nextInt();	
			switch (choice) { 
	        case 1: 
	        	System.out.println("\n" + "\n");
	        	System.out.println("------------------------------");
	        	System.out.println("Viewing Account Information");
	        	System.out.println("------------------------------");
	        	System.out.println("\n" + "\n");
	            break; 
	        case 2: 
	        	System.out.println("\n" + "\n");
	        	System.out.println("------------------------------");
	        	System.out.println("Searching for an Item");
	        	System.out.println("------------------------------");
	        	System.out.println("\n" + "\n");
	            break; 
	        case 3: 
	        	System.out.println("\n" + "\n");
	        	System.out.println("------------------------------");
	        	System.out.println("Returning an Item");
	        	System.out.println("------------------------------");
	        	System.out.println("\n" + "\n");
	            break; 
	        case 4: 
	        	System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
	        	System.out.println("Shutting Down. . .");
	        	System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
	        	run = false;
	            break; 
	        } 
			
		}
	}
}
