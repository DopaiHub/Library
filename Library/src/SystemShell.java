import java.util.ArrayList;
public class SystemShell {
	protected ArrayList<Item> jsonItemList;
	protected ArrayList<User> jsonUserList;
	protected User person = null;
	protected Admin uAdmin = null;
	protected Teacher uTeacher = null;
	protected Adult uAdult = null;
	protected Kid uKid = null;
	private static SystemShell shell;
	
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
	
	public static SystemShell launchSystem()
	{
		if (shell == null)
			shell = new SystemShell();
		return shell;
	}
	
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
	
	public User loginUser(String uEmail, String uPass)
	{
		for (int i = 0; i < jsonUserList.size(); i ++)
		{
			person = jsonUserList.get(i);
			if (person.email.equals(uEmail) && person.password.equals(uPass))
			{
				if (person.userType.equals("Admin"))
					uAdmin = (Admin)person;
				else if (person.userType.equals("Teacher"))
					uTeacher = (Teacher)person;
				if (person.userType.equals("Adult"))
					uAdult = (Adult)person;
				else if (person.userType.equals("Teacher"))
					uTeacher = (Teacher)person;
				return person;
			}
		}
		System.out.println("The email and/or password provided did not match any existing user emails/passwords. Please try again.");
		person = null;
		return person;
	}
	
	public void logoutUser()
	{
		JsonIO.writeItem(jsonItemList);
		JsonIO.writeUser(jsonUserList);
		person = null;
	}
	
	public void checkoutItem(int id)
	{
		if(person.getItemList().length>person.getItemLimit())
			System.out.println("Item list is full");
		else if(person.getBalance()>0)
		{
			System.out.println("You need to pay your fine of: "+person.getBalance());
		}
		else if(jsonItemList.get(id-1).getNumCopies()==0)
		{
			for(int i=0;i<jsonItemList.get(id-1).getWaitList().length;i++)
			{
				String[] wait=new String[10];
				if(jsonItemList.get(id-1).getWaitList()==null)
				{
					wait=jsonItemList.get(id-1).getWaitList();
					jsonItemList.get(id-1).setWaitList(wait);
					System.out.println("You have been added to the waitlist for "+jsonItemList.get(id-1).getItemName());
					break;
				}
			}
		}
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
	
	public void registerUser(String firstName,String lastName,String address,
			int phoneNumber, String email, int age, String password,String type)
	{
		int itemLimit=10;
		double balance=0;
		int[] itemL=new int[10];
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
	
	public void payFines(double amount)
	{
		person.setBalance(person.getBalance()-amount);
	}
	
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
	public void notifyUser(String uEmail)
	{
		for(int i=0;i<jsonItemList.size();i++)
		{
			if(jsonItemList.get(i).getNumCopies()>0)
			{
			for(int j=0;j<jsonItemList.get(i).getWaitList().length;j++)
			{
				if(jsonItemList.get(i).getWaitList()[i].equalsIgnoreCase(uEmail))
				{
					System.out.println("Your item "+jsonItemList.get(i).getItemName()+" is now availiable to be checked out");
				}
			}
			}
		}
	}
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
	
	public void showReviews(String itemName)
	{
		for(int i=0;i<jsonItemList.size();i++)
		{
			if(jsonItemList.get(i).getItemName().equalsIgnoreCase(itemName))
			{
				for(int j=0;j<jsonItemList.get(i).getReviews().length;j++)
				{
					System.out.println(jsonItemList.get(i).getReviews()[i]);
				}
			}
		}
	}
	
	public void addReview(String itemName,double rating,String review)
	{
		for(int i=0;i<jsonItemList.size();i++)
		{
			if(jsonItemList.get(i).getItemName().equalsIgnoreCase(itemName))
			{
				String[] reviews=new String[jsonItemList.get(i).getReviews()[i].length()];
				reviews[i]=jsonItemList.get(i).getReviews()[i];
				for(int j=0;j<reviews.length;j++)
				{
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
}
