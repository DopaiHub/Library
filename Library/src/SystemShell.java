import java.util.ArrayList;
/**
 * SystemShell is a singleton and has all the methods to be called by the interface
 * @author Uncrustables (Josh,Adam,Steven)
 *
 */
public class SystemShell {
	/**
	 * Instance variables for SystemShell
	 */
	protected ArrayList<Item> jsonItemList;
	protected ArrayList<User> jsonUserList;
	protected User person = null;
	protected Admin uAdmin = null;
	protected Teacher uTeacher = null;
	protected Adult uAdult = null;
	protected Kid uKid = null;
	private static SystemShell shell;
	
	/**
	 * Default constructor
	 */
	private SystemShell()
	{
		person = null;
		uAdmin = null;
		uTeacher = null;
		uAdult = null;
		uKid = null;
		jsonUserList = JsonIO.loadUsers();
		jsonItemList = JsonIO.loadItems();
	}
	/**
	 * launchSystem creates a new SystemShell if its empty, otherwise it returns the current shell
	 * @return shell
	 */
	public static SystemShell launchSystem()
	{
		if (shell == null)
			shell = new SystemShell();
		return shell;
	}
	
	/**
	 * searchItem searches the jsonItemList based on the string parameter given 
	 * and returns the items that matches
	 * @param value
	 * @return itemList
	 */
	public ArrayList<Item> searchItem(String value)
	{
		ArrayList<Item> itemList=new ArrayList<Item>();
		for(int i=0;i<jsonItemList.size();i++)
		{
			if (jsonItemList.get(i).getItemName().equalsIgnoreCase(value))
			{
				itemList.add(jsonItemList.get(i));
			}
			else if(jsonItemList.get(i).getCreator().equalsIgnoreCase(value))
			{
				itemList.add(jsonItemList.get(i));
			}
			else if(jsonItemList.get(i).getGenre().equalsIgnoreCase(value))
			{
				itemList.add(jsonItemList.get(i));
			}
			else if(jsonItemList.get(i).getType().equalsIgnoreCase(value))
			{
				itemList.add(jsonItemList.get(i));
			}
		}
		return itemList;
	}
	
	/**
	 * loginUser method logins into the system if the email and password are valid
	 * @param uEmail
	 * @param uPass
	 * @return User
	 */
	public User loginUser(String uEmail, String uPass)
	{
		for (int i = 0; i < jsonUserList.size(); i ++)
		{
			person = jsonUserList.get(i);
			if (person.getEmail().equals(uEmail) && person.getPassword().equals(uPass))
			{
				if (person.getUserType().equalsIgnoreCase("admin"))
					uAdmin = (Admin)person;
				else if (person.getUserType().equalsIgnoreCase("teacher"))
					uTeacher = (Teacher)person;
				if (person.getUserType().equalsIgnoreCase("adult"))
					uAdult = (Adult)person;
				else if (person.getUserType().equalsIgnoreCase("kid"))
					uKid = (Kid)person;
				return person;
			}
		}
		System.out.println("The email and/or password provided did not match any existing user emails/passwords. Please try again.");
		person = null;
		return person;
	}
	
	/**
	 * logoutUser writes to the JSON files and sets person to null
	 */
	public void logoutUser()
	{
		JsonIO.writeItem(jsonItemList);
		JsonIO.writeUser(jsonUserList);
		person = null;
	}
	/**
	 * checkoutItem accounts for cases that a user cant checkout an item, otherwise it checks it out
	 * @param id
	 */
	public void checkoutItem(int id)
	{
		if(person.getItemList().length>person.getItemLimit())
			System.out.println("Item list is full");
		else if(person.getBalance()>0)
		{
			System.out.println("You need to pay your fine of: "+person.getBalance());
		}
		//adds user to waitlist
		else if(jsonItemList.get(id-1).getNumCopies()==0)
		{
			for(int i=0;i<jsonItemList.get(id-1).getWaitList().length;i++)
			{
				String[] wait=new String[10];
				if(jsonItemList.get(id-1).getWaitList()[i]==null)
				{
					wait=jsonItemList.get(id-1).getWaitList();
					for(int j=0;j<wait.length;j++)
					{
						if(wait[j]==null)
						{
							wait[j]=person.getEmail();
							break;
						}
					}
					jsonItemList.get(id-1).setWaitList(wait);
					System.out.println("You have been added to the waitlist for "+jsonItemList.get(id-1).getItemName());
					break;
				}
			}
		}
		//checks out item
		else
		{
			for(int i=0;i<person.itemList.length;i++)
			{
				if(person.itemList[i]==0)
				{
					person.itemList[i]=id;
					jsonItemList.get(id-1).setNumCopies(jsonItemList.get(id-1).getNumCopies()-1);
					System.out.println("You have checked out "+ jsonItemList.get(id-1).getItemName());
					break;
				}
			}
		}
	}
	/**
	 * returnItem returns the item to the library that the user gives
	 * @param id
	 */
	public void returnItem(int id)
	{
		for(int i=0;i<person.itemList.length;i++)
		{
			if(person.itemList[i]==id)
			{
				person.itemList[i]=0;
				jsonItemList.get(id-1).setNumCopies(jsonItemList.get(id-1).getNumCopies()+1);
				System.out.println("You have returned "+jsonItemList.get(id-1).getItemName());
			}
		}
	}
	
	/**
	 * Returns the ID of the item by receiving a name
	 * @param name
	 * @return id
	 */
	public int returnIDByName(String name)
	{
		for(int i=0;i<jsonItemList.size();i++)
		{
			if(jsonItemList.get(i) != null && jsonItemList.get(i).getItemName().equalsIgnoreCase(name))
			{
				return jsonItemList.get(i).getId();
			}
		}
		return -1;
	}
	
	/**
	 * registerUser method adds a user to the arrayList based on parameters
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param phoneNumber
	 * @param email
	 * @param age
	 * @param password
	 * @param type
	 */
	public void registerUser(String firstName,String lastName,String address,
			int phoneNumber, String email, int age, String password,String type)
	{
		//default values
		int itemLimit=10;
		double balance=0;
		int[] itemL=new int[10];
		//if statement adds based on type
		if(type.equalsIgnoreCase("adult"))
		{
			
			jsonUserList.add(new Adult(firstName, lastName, address,
				phoneNumber, email, age, password,
				itemLimit, balance,type,itemL));
		}
		else if(type.equalsIgnoreCase("admin"))
		{
			jsonUserList.add(new Admin(firstName, lastName, address,
					phoneNumber, email, age, password,
					itemLimit, balance,type, itemL));
		}
		else if(type.equalsIgnoreCase("teacher"))
		{
			jsonUserList.add(new Teacher(firstName, lastName, address,
					phoneNumber, email, age, password,
					itemLimit, balance,type, itemL));
		}
		else if(type.equalsIgnoreCase("kid"))
		{
			jsonUserList.add(new Kid(firstName, lastName, address,
					phoneNumber, email, age, password,
					itemLimit, balance,type, itemL));
		}
	}
	
	/**
	 * This method searches the waitlist for a user based on their email and returns the waitList
	 * @param email
	 * @return userWaitList
	 */
	public String[] searchWaitListForUser(String email)
	{
		String[] userWaitList = new String[10];
		int counter = 0;
		for(int i=0;i<jsonItemList.size();i++)
		{
			String[] waitL = jsonItemList.get(i).getWaitList();
			for (int j = 0; j < waitL.length; j++)
			{
				if (waitL[j] != null && waitL[j].equalsIgnoreCase(email))
				{
					userWaitList[counter] = jsonItemList.get(i).getItemName();
					counter++;
				}
			}
		}
		return userWaitList;
	}
	
	/**
	 * Allows the user to pay their fines
	 * @param amount
	 */
	public void payFines(double amount)
	{
		person.setBalance(person.getBalance()-amount);
		System.out.println("Paid: " + amount + ". You now owe: " + person.getBalance());
	}
	
	/**
	 * returns the users items list by their itemName
	 * @return userItems
	 */
	public String[] getUserItems()
	{
		String[] userItems = new String[10];
		int counter = 0;
		int[] itemL = person.getItemList();
		for (int i = 0; i < jsonItemList.size(); i++)
		{
			for (int j = 0; j < itemL.length; j++)
			{
				if (itemL[j] == jsonItemList.get(i).getId())
				{
					userItems[counter] = jsonItemList.get(i).getItemName();
					counter++;
				}
			}
		}
		return userItems;
	}
	/**
	 * addStock adds an amount of copies to the item given the itemName
	 * @param itemName
	 * @param copies
	 */
	public void addStock(String itemName,int copies)
	{
		for(int i=0;i<jsonItemList.size();i++)
		{
			if(jsonItemList.get(i).getItemName().equalsIgnoreCase(itemName))
			{
				jsonItemList.get(i).setNumCopies(jsonItemList.get(i).getNumCopies()+copies);
				System.out.println("Added "+copies+" to "+jsonItemList.get(i).getItemName());
			}
		}
	}
	/**
	 * Notifies the user if they are in the waitlist for an item
	 * @param uEmail
	 */
	public void notifyUser(String uEmail)
	{
		for(int i=0;i<jsonItemList.size();i++)
		{
			if(jsonItemList.get(i).getNumCopies()>0)
			{
			for(int j=0;j<jsonItemList.get(i).getWaitList().length;j++)
			{
				if(jsonItemList.get(i).getWaitList()[j] != null && jsonItemList.get(i).getWaitList()[j].equalsIgnoreCase(uEmail))
				{
					System.out.println("Your item "+jsonItemList.get(i).getItemName()+" is now availiable to be checked out");
				}
			}
			}
		}
	}
	/**
	 * Prints out the dueDate for an item
	 */
	public void dueDate()
	{
		for(int i=0;i<person.getItemList().length;i++)
		{
			if(person.getItemList()[i]>0)
			{
				String itemName=jsonItemList.get(person.getItemList()[i]-1).getItemName();
				int maxTime=jsonItemList.get(person.getItemList()[i]-1).getMaxTime();
				int checkoutTime=jsonItemList.get(person.getItemList()[i]-1).getCheckoutTime();
				System.out.println(itemName+" is due in "+(maxTime-checkoutTime)+" days");
			}
		}
	}
	
	/**
	 * showReviews takes in an itemName and prints out the the reviews
	 * @param itemName
	 */
	public void showReviews(String itemName)
	{
		for(int i=0;i<jsonItemList.size();i++)
		{
			if(jsonItemList.get(i)!=null&&jsonItemList.get(i).getItemName().equalsIgnoreCase(itemName))
			{
				for(int j=0;j<jsonItemList.get(i).getReviews().length;j++)
				{
					if(jsonItemList.get(i).getReviews()[j]!=null)
					System.out.println(jsonItemList.get(i).getReviews()[j]);
				}
			}
			
		}
	}
	
	/**
	 * addReview method adds a review to the item
	 * @param itemName
	 * @param rating
	 * @param review
	 */
	public void addReview(String itemName,double rating,String review)
	{
		for(int i=0;i<jsonItemList.size();i++)
		{
			if(jsonItemList.get(i)!=null&&jsonItemList.get(i).getItemName().equalsIgnoreCase(itemName))
			{
				String[] reviews=new String[jsonItemList.get(i).getReviews()[i].length()];
				for(int j=0;j<reviews.length;j++)
				{
					if(jsonItemList.get(i).getReviews()[j]!=null)
						reviews[j]=jsonItemList.get(i).getReviews()[j];
					if(reviews[j]==null)
					{
						reviews[j]="Rating: "+rating+" "+review;
						break;
					}
				}
				jsonItemList.get(i).setReviews(reviews);
				jsonItemList.get(i).setRating((jsonItemList.get(i).getRating()+rating)/2);
			}
		}
	}
	
	/**
	 * addFine method allows the admin to fine a user
	 * @param fineAmt
	 * @param email
	 */
	public void addFine(double fineAmt, String email)
	{
		if (uAdmin != null)
		{
			uAdmin.fineUser(email, fineAmt, jsonUserList);
		}
		else
		{
			System.out.println("Only an Admin may add fines to users");
		}
	}
}
