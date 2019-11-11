import java.util.ArrayList;

public class Admin extends User {

	public Admin(String firstName, String lastName, String address,
			int phoneNumber, String email, int age, String password,
			int itemLimit, double balance, String userType, int[] itemList)
	{
		super(firstName, lastName, address,
				phoneNumber, email, age, password,
				itemLimit, balance, userType, itemList);
	}
	
	public double getBalance()
	{
		return super.getBalance();
	}
	public int getLimit()
	{
		return super.getItemLimit();
	}
	
	public ArrayList<User> fineUser(String email, double fine, ArrayList<User> uList)
	{
		User u;
		for (int i = 0; i < uList.size(); i++)
		{
			u = uList.get(i);
			if (u.getEmail() != null && u.getEmail().equals(email))
			{
				u.setBalance(u.getBalance() + fine);
				return uList;
			}
		}
		return uList;
	}
}
