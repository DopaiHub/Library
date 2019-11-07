import java.util.ArrayList;
public class SystemShell {
	protected ArrayList<Item> jsonItemList;
	protected ArrayList<User> jsonUserList;
	protected User person;
	private static SystemShell shell;
	
	private SystemShell()
	{
		JsonIO json = new JsonIO();
		jsonUserList = json.loadUsers();
		jsonItemList = json.loadItems();
	}
	
	public static SystemShell launchSystem()
	{
		if (shell == null)
			shell = new SystemShell();
		return shell;
	}
	
	public void searchItem(String str)
	{
		for(int i=0;i<jsonItemList.size();i++)
		{
			if (jsonItemList.get(i).getItemName().equalsIgnoreCase(str))
			{
				System.out.println(jsonItemList.get(i).toString());
			}
		}
	}
	
	public User loginUser(String uEmail, String uPass)
	{
		for (int i = 0; i < jsonUserList.size(); i ++)
		{
			person = jsonUserList.get(i);
			if (person.email.equals(uEmail) && person.password.equals(uPass))
			{return person;
			}
		}
		System.out.println("The email and/or password provided did not match any existing user emails/passwords. Please try again.");
		person = null;
		return person;
	}
	
	public void logoutUser()
	{
		person = null;
	}
	
	private void returnItem(Item item)
	{
		
		
		
		
	}
	
	public void checkoutItem(int id)
	{
		if(person.getItemList().length>=person.getItemLimit())
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
					break;
				}
			}
		}
	}
	
	public void searchUser(User user)
	{
		
	}
	
	private void editUser(User user)
	{
		
	}
	
	public void searchItem(Item item)
	{
		
	}
	
	private void editItem(Item item)
	{
		
	}
	
	public void registerUser(String userType, String firstN, String lastN, String email, String password, int age, String addr, int phoneNum)
	{
		
		//User newU = new User(firstN, lastN, addr, phoneNum, email, age, password, );
	}
	
	public void searchItemType(String iType)
	{
		
	}
	public void payFines(double amount)
	{
		person.setBalance(person.getBalance()-amount);
	}
}