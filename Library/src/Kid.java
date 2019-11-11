import java.util.ArrayList;

public class Kid extends User {
	public Kid()
	{
		
	}
	public Kid(String firstName, String lastName, String address,
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
}