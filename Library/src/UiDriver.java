import java.util.Scanner;

public class UiDriver {
	
	public static User login(String email, String password) {
		SystemShell shell = SystemShell.launchSystem();
		User user = shell.loginUser(email, password);
		return user;
	}

	public static void main(String[] args) {
		
		//TODO Add login function
		//TODO Add functionality to Admin users
		//TODO Connect case statements with SystemShell API
		
		
		SystemShell shell = SystemShell.launchSystem();
		User you = new Adult();
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Library System!");
		System.out.println("------------------------------" + "\n");
		boolean endLogin = false;
		while(endLogin == false) {
			System.out.println("1. Login");
			System.out.println("2. Create Account");
			String email = "";
			String password = "";
		
			int loginChoice = scan.nextInt();
			switch (loginChoice) {
			case 1:
        		System.out.println("\n" + "Please enter your email: ");
        		email = scan.next();
        		System.out.println("\n" + "Please enter your password: ");
        		password = scan.next();
        		you = login(email, password);
        		
        		if(you != null) {
        			System.out.println("Welcome " + you.getFirstName());
        			endLogin = true;
        		}
            	break;
        	case 2:
        		System.out.println("Welcome to Account Creation!");
    
        		System.out.println("Enter your First Name: ");
        		String first  = scan.next();
        		System.out.println("Enter your Last Name: ");
        		String last = scan.next();
        		System.out.println("Enter your Address: ");
        		String address = scan.nextLine();
        		scan.nextLine();
        		System.out.println("Address: " + address);
        		System.out.println("Enter your Phone Number: ");
        		int phoneNumber = scan.nextInt();
        		System.out.println("Enter your Email: ");
        		email = scan.next();
        		System.out.println("Enter your Age: ");
        		int age = scan.nextInt();
        		System.out.println("Enter your Password: ");
        		password = scan.next();
        		System.out.println("What is your account type?");
        		System.out.println("1. Adult");
        		System.out.println("2. Admin");
        		System.out.println("3. Kid");
        		System.out.println("4. Teacher");
        		int userTypeChoice = 0;
        		String userType = "";
        		userTypeChoice = scan.nextInt();
        		if(userTypeChoice == 1) {
        			userType = "adult";
        		}
        		else if(userTypeChoice == 2) {
        			userType = "admin";
        		}
        		else if(userTypeChoice == 3) {
        			userType = "kid";
        		}
        		else if(userTypeChoice == 4) {
        			userType = "teacher";
        		}
        		
        		shell.registerUser(first, last, address, phoneNumber, email, age, password, userType);
        		
            	break;
			}
		}
		
		
		boolean run = true;
		while(run == true) {
			System.out.println("Please choose an operation." + "\n");
			System.out.println("1. View Account Information");
			System.out.println("2. Search for an Item");
			System.out.println("3. Return an Item");
			System.out.println("4. List Your Items");
			System.out.println("5. Exit Library System");
			
			
			int choice = scan.nextInt();	
			switch (choice) { 
	        case 1:
	        	System.out.println("\n" + "\n");
	        	System.out.println("------------------------------");
	        	System.out.println("Viewing Account Information");
	        	System.out.println("\n" + "First Name: " + you.getFirstName());
	        	System.out.println("\n" + "Last Name: " + you.getLastName());
	        	System.out.println("\n" + "Address: " + you.getAddress());
	        	System.out.println("\n" + "Phone Number: " + you.getPhoneNumber());
	        	System.out.println("\n" + "Email: " + you.getEmail());
	        	System.out.println("\n" + "Age: " + you.getAge());
	        	System.out.println("\n" + "Balance: " + you.getBalance());
	        	System.out.println("\n" + "Account Type: " + you.getUserType());
	        	System.out.println("------------------------------");
	        	System.out.println("\n" + "\n");
	            break; 
	        case 2:
	        	boolean endSearch = false;
	        	System.out.println("\n" + "\n");
	        	System.out.println("------------------------------");
	        	System.out.println("Searching for an Item");
	        	System.out.println("------------------------------");
	        	System.out.println("\n" + "\n");
	        	while(endSearch == false) {
	        		
	        		endSearch = true;
	        	}
	            break; 
	        case 3: 
	        	System.out.println("\n" + "\n");
	        	System.out.println("------------------------------");
	        	System.out.println("Returning an Item");
	        	System.out.println("------------------------------");
	        	System.out.println("\n" + "\n");
	            break;
	        case 4: 
	        	boolean endList = false;
	        	System.out.println("\n" + "\n");
	        	System.out.println("------------------------------");
	        	System.out.println("List Your Items");
	        	System.out.println("------------------------------");
	        	System.out.println("\n" + "\n");
	        	while(endList == false) {
	        		String[] userItemList = new String[10];
	        		String[] userWaitList = new String[10];
	        		userWaitList = shell.searchWaitListForUser(you.getEmail());
	        		//userItemList =
	        		for(int i = 0; i < 9; i++) {
	        			System.out.println(userWaitList[i]);
	        		}
	        		
	        		endList = true;
	        	}
	            break;
	        case 5: 
	        	System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
	        	System.out.println("Shutting Down. . .");
	        	System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
	        	run = false;
	            break; 
	        } 
			
		}
	}
}
