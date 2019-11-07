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
		while (jsonUserList.iterator().hasNext())
		{
			person = jsonUserList.iterator().next();
			if (person.email.equals(uEmail) && person.password.equals(uPass))
				return person;
		}
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
	
	private boolean checkoutItem(Item item)
	{
		return true;
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
		
		User newU = new User(firstN, lastN, addr, phoneNum, email, age, password, );
	}
	
	public void searchItemType(String iType)
	{
		
	}
}