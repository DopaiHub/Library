import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
<<<<<<< HEAD
 * @author 
=======
 * @author Uncrustables (Joshua, Adam, Steven)
>>>>>>> 6c8d7dd26ea3f5cf8053ad4b90077950561126d7
 *
 */
public class UiDriver {
	/**
	 * This method starts the System shell interface and returns the user to be logged in
	 * @param email The user's email, password The user's password
	 * @return The object of the user who has logged in
	 */
	public static User login(String email, String password) {
		SystemShell shell = SystemShell.launchSystem();
		User user = shell.loginUser(email, password);
		return user;
	}

	public static void main(String[] args) {
		
		//Creates a system shell object and user to be logged in
		SystemShell shell = SystemShell.launchSystem();
		User you = new Adult();
		
		//Scanner to take in input
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Library System!");
		System.out.println("------------------------------" + "\n");
		boolean endLogin = false;
		
		//While loop that contains login/account creation
		while(endLogin == false) {
			System.out.println("1. Login");
			System.out.println("2. Create Account");
			String email = "";
			String password = "";
		
			int loginChoice = scan.nextInt();
			//Input "loginChoice" decides the case log in or create account
			switch (loginChoice) {
			//Log in case
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
            	//Create account case
        	case 2:
        		System.out.println("Welcome to Account Creation!");
    
        		System.out.println("Enter your First Name: ");
        		String first  = scan.next();
        		System.out.println("Enter your Last Name: ");
        		String last = scan.next();
        		System.out.println("Enter your Address: ");
        		scan.nextLine();
        		String address = scan.nextLine();
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
        		
        		//API to create a new user
        		shell.registerUser(first, last, address, phoneNumber, email, age, password, userType);
        		
            	break;
			}
		}
		//Check if any of your waiting list items are now available
		shell.notifyUser(you.getEmail());
		
		//While loop that contains the Library System program/operations
		boolean run = true;
		while(run == true) {
			System.out.println("\n" + "Please choose an operation." + "\n");
			
			if(you.getUserType().equalsIgnoreCase("admin")) {
				System.out.println("0. Admin Functions");
			}
			System.out.println("1. View Account Information");
			System.out.println("2. Search for an Item");
			System.out.println("3. Return an Item");
			System.out.println("4. List Your Items");
			System.out.println("5. Manage Balance");
			System.out.println("6. Exit Library System" + "\n");
			
			scan.nextLine();
			int choice = scan.nextInt();
			scan.nextLine();
			switch (choice) { 
			
			case 0:
				
				if(you.getUserType().equalsIgnoreCase("admin")) {
					System.out.println("Choose an Admin Function." + "\n");
					System.out.println("1. Add Stock");
					System.out.println("2. Return to Menu");
					
					int adminChoice = scan.nextInt();
					scan.nextLine();
					if(adminChoice == 1) {
						System.out.println("Enter an Item Name to Add : ");
						String itemName = scan.nextLine();
						System.out.println("Enter an Amount of Copies to Add: ");
						int copies = scan.nextInt();
						shell.addStock(itemName, copies);
					}
				}
				
				
				
				break;
			//Case to view account information
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
	        	System.out.println("\n" + "Amount Owed: " + you.getBalance());
	        	System.out.println("\n" + "Account Type: " + you.getUserType());
	        	System.out.println("------------------------------");
	        	System.out.println("\n" + "\n");
	            break; 
	            //Case to search for an item
	        case 2:
	        	boolean endSearch = false;
	        	System.out.println("\n" + "\n");
	        	System.out.println("------------------------------");
	        	System.out.println("Searching for an Item");
	        	System.out.println("------------------------------");
	        	System.out.println("\n" + "\n");
	        	//While loop that facilitates item search functionality
	        	while(endSearch == false) {
	        		ArrayList<Item> itemList=new ArrayList<Item>();
	        		System.out.println("Enter a keyword to search: ");
	        		
	        		String keyword = scan.nextLine();
	        		//API to return items matching the search term
	        		itemList = shell.searchItem(keyword);
	        		if(itemList.size() == 0) {
	        			System.out.println("Keyword had no matches.");
	        			endSearch = true;
	        			break;
	        		}
	        		for(int i = 0; i < itemList.size(); i++) {
	        			if(itemList.get(i) != null) {
	        				System.out.println(i + 1 + ". " + itemList.get(i).getItemName());
	        			}
	        			if(i == itemList.size() - 1) {
        					System.out.println(i + 2 + ". Return to Menu");
        				}
	        		}
	        		int searchChoice = scan.nextInt();
	        		if(searchChoice == itemList.size() + 1) {
	        			System.out.println("Returning to menu");
	        			break;
	        		}
	        		
	        		//Display options for a selected item
	        		System.out.println("Options for " + itemList.get(searchChoice - 1).getItemName());
	        		System.out.println("1. Checkout Item");
	        		System.out.println("2. See Item Information");
	        		System.out.println("3. See Item Reviews");
	        		System.out.println("4. Leave a Review");
	        		System.out.println("5. Return to Menu");
	        		
	        		int itemChoice = scan.nextInt();
	        		//Checkout the item
	        		if(itemChoice == 1) {
	        			shell.checkoutItem(itemList.get(searchChoice - 1).getId());
	        		}
	        		//View item information
	        		else if(itemChoice == 2) {
	        			System.out.println(itemList.get(searchChoice - 1).toString());
	        		}
	        		//See item reviews
	        		else if(itemChoice == 3) {
	        			shell.showReviews(itemList.get(searchChoice - 1).getItemName());
	        		}
	        		//Create a new review
	        		else if(itemChoice == 4) {
	        			shell.showReviews(itemList.get(searchChoice - 1).getItemName());
	        			System.out.println("How would you rate this item out of 5.0?");
	        			double rating = scan.nextDouble();
	        			System.out.println("Write a Review for the item: ");
	        			scan.nextLine();
	        			String review = scan.nextLine();
	        			shell.addReview(itemList.get(searchChoice - 1).getItemName(), rating, review);
	        		}
	        		endSearch = true;
	        	}
	            break;
	            //Case to return an item
	        case 3: 
	        	String[] stringList = shell.getUserItems();
	        	System.out.println("\n" + "\n");
	        	System.out.println("------------------------------");
	        	System.out.println("Returning an Item");
	        	System.out.println("------------------------------");
	        	System.out.println("\n" + "\n");
	        	
	        	//Print a list of the user's items
	        	for(int i = 0; i < you.getItemList().length; i++) {
	        		if(you.getItemList()[i] > 0)
	        			System.out.println(i + 1 + ". " + stringList[i]);
	        		if(stringList[i] == null) {
	        			System.out.println(i + 1 + ". Return to Menu");
	        			i = you.getItemList().length;
	        		}
	        	}
	        	
	        	
	        	System.out.println("Please Choose an Item to Return.");
	        	scan.nextLine();
	        	int returnChoice = scan.nextInt();
	        	
	        	if(stringList[returnChoice] == null) {
	        		break;
	        	}
	        	else {
	        		//Convert item name to item id
	        		int itemId = shell.returnIDByName(stringList[returnChoice-1]);
	        		//return item API
	        		shell.returnItem(itemId);
	        	}
	            break;
	            //Case to list the user's items
	        case 4: 
	        	boolean endList = false;
	        	System.out.println("\n" + "\n");
	        	System.out.println("------------------------------");
	        	System.out.println("List Your Items");
	        	System.out.println("------------------------------");
	        	System.out.println("\n" + "\n");
	        	
	        	//Print items that are checked out
	        	while(endList == false) {
	        		String[] userItemList = new String[10];
	        		String[] userWaitList = new String[10];
	        		userItemList = shell.getUserItems();
	        		System.out.println("\n" + "Items you have checked out: ");
	        		for(int i = 0; i < 10; i++) {
	        			if(userItemList[i] != null) {
	        			System.out.println(userItemList[i]);
	        			}
	        		}
	        		
	        		//Print items that the user is waiting on
	        		userWaitList = shell.searchWaitListForUser(you.getEmail());
	        		System.out.println("\n" + "Items you are waiting on: ");
	        		for(int i = 0; i < 10; i++) {
	        			if(userWaitList[i] != null) {
	        			System.out.println(userWaitList[i]);
	        			}
	        		}
	        		endList = true;
	        	}
	            break;
	            //Case to handle balance and fine functionality
	        case 5: 
	        	System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
	        	System.out.println("------------------------------");
	        	System.out.println("Manage Balance");
	        	System.out.println("------------------------------");
	        	System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
	        	
	        	System.out.println("Please Choose an Action.");
	        	System.out.println("1. Pay Fine");
	        	System.out.println("2. Fine a User");
	        	System.out.println("3. Return to Menu");
	        	
	        	int userChoice = scan.nextInt();
	        	
	        	//Pay a fine on the user's account
	        	if(userChoice == 1) {
	        		System.out.println("Current Debt: " + you.getBalance());
	        		System.out.println("Enter the Amount to be Paid: ");
	        		double amountPaid = scan.nextDouble();
	        		shell.payFines(amountPaid);
	        	}
	        	//Admin function to fine a user
	        	else if(userChoice == 2) {
	        		System.out.println("Enter the email of the user to be fined.");
	        		String fineEmail = scan.next();
	        		System.out.println("Enter the Fine Amount.");
	        		double fineAmount = scan.nextDouble();
	        		shell.addFine(fineAmount, fineEmail);
	        	}
	            break;
	            //Case to shut down the program.
	        case 6: 
	        	System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
	        	System.out.println("Shutting Down. . .");
	        	System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
	        	//ONLY UNCOMMENT BOTTOM LINE WHEN WE ARE 100% SURE THAT THE PROGRAM FUNCITONS PROPERLY
	        	//shell.logoutUser();
	        	run = false;
	            break; 
	        } 
			
		}
	}
}
