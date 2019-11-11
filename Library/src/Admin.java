/**
 * 
 * @author Uncrustables (Joshua, Adam, Steven)
 *
 */
import java.util.ArrayList;
public class Admin extends User {

	/**
	 * Parameterized constructor used to create Admin objects
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param phoneNumber
	 * @param email
	 * @param age
	 * @param password
	 * @param itemLimit
	 * @param balance
	 * @param userType
	 * @param itemList
	 */
	public Admin(String firstName, String lastName, String address,
			int phoneNumber, String email, int age, String password,
			int itemLimit, double balance, String userType, int[] itemList) {
		/*
		 * super call to the User class using the User class constructor
		 */
		super(firstName, lastName, address,
				phoneNumber, email, age, password,
				itemLimit, balance, userType, itemList);
	}
	
	/**
	 * Getter method for balances
	 * @return super.getBalance()
	 */
	public double getBalance()
	{
		return super.getBalance();
	}
	/**
	 * Getter method for item limits
	 * @return super.getItemLimit()
	 */
	public int getItemLimit()
	{
		return super.getItemLimit();
	}
	
	/**
	 * Method used to fine a user based on the sent-in amount, the email of the user, and the current array list of users
	 * @param email
	 * @param fine
	 * @param uList
	 * @return uList
	 */
	public void fineUser(String email, double fine, ArrayList<User> uList)
	{
		/*
		 * For loop that loops throughout uList
		 */
		for (int i = 0; i < uList.size(); i++)
		{
			/*
			 * If statement that checks to see if the email at the current index isn't null as well as if the email is equal to the sent-in email
			 */
			if (uList.get(i).getEmail() != null && uList.get(i).getEmail().equals(email))
			{
				/*
				 * Sets the balance of the user being fined to the sum of their current balance plus the entered fine, then exits the method
				 */
				uList.get(i).setBalance(uList.get(i).getBalance() + fine);
				return;
			}
		}
	}
}
