import java.util.ArrayList;
public class SystemShell {
	protected ArrayList<Item> jsonItemList;
	protected ArrayList<User> jsonUserList;
	protected User person;
	private static SystemShell shell;
	
	private SystemShell()
	{
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
	
	public User loginUser()
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
}