import java.util.ArrayList;
public class SystemShell<T> {
	protected ArrayList<Item> jsonItemList;
	protected ArrayList<T> jsonUserList;
	protected User person;
	private static SystemShell shell;
	
	private SystemShell()
	{
		JsonIO json = new JsonIO();
		jsonUserList = json.loadUsers();
		jsonItemList = json.loadItems();
	}
	
	public SystemShell launchSystem()
	{
		if (shell == null)
			shell = new SystemShell();
		return shell;
	}
	
	public void searchItem(String str)
	{
		
	}
	
	public User loginUser(String uEmail, String uPass)
	{
		return null;
	}
	
	public void logoutUser()
	{
		
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
	
	public void registerUser(String a, String b, String c, String d, String e)
	{
		
	}
	
	public void searchItemType(String iType)
	{
		
	}
}