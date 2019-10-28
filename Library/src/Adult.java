import java.util.ArrayList;

public class Adult extends User {
	public Adult()
	{
		
	}
	public Adult(String firstName, String lastName, String address,
			int phoneNumber, String email, int age, String password,
			int itemLimit, double balance, ArrayList<Item> itemList)
	{
		super(firstName, lastName, address,
				phoneNumber, email, age, password,
				itemLimit, balance, itemList);
	}
	public double getBalance()
	{
		return super.getBalance();
	}
	public int getLimit()
	{
		return super.getLimit();
	}
}
