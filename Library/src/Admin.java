import java.util.ArrayList;

public class Admin extends User {

	public Admin(String firstName, String lastName, String address,
			int phoneNumber, String email, int age, String password,
			int itemLimit, double balance, String userType, ArrayList<Item> itemList)
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
		return super.getLimit();
	}
	
	//TODO
	public void fineUser(User user)
	{
		
	}
}
