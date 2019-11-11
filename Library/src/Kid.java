/**
 * 
 * @author Uncrustables (Joshua, Adam, Steven)
 *
 */
public class Kid extends User {
	/**
	 * Empty default constructor
	 */
	public Kid() {}
	
	/**
	 * Parameterized constructor used to create Kid objects
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
	public Kid(String firstName, String lastName, String address,
			int phoneNumber, String email, int age, String password,
			int itemLimit, double balance, String userType, int[] itemList)
	{
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
}