import java.util.ArrayList;

public abstract class User {
	protected String firstName;
	protected String lastName;
	protected String address;
	protected int phoneNumber;
	protected String email;
	protected int age;
	protected String password;
	protected int itemLimit;
	protected double balance;
	protected ArrayList<Item> itemList;

	public User()
	{
		
	}
	
	public User(String firstName, String lastName, String address,
			int phoneNumber, String email, int age, String password,
			int itemLimit, double balance, ArrayList<Item> itemList)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.age = age;
		this.password = password;
		this.itemLimit = itemLimit;
		this.balance = balance;
		this.itemList = itemList;
	}
	
	public double getBalance()
	{
		return this.balance;
	}
	
	public int getLimit()
	{
		return this.itemLimit;
	}
	
	//TODO need to add expiration() method to Item
	public int getExpiration(Item item)
	{
		int temp = 0;
		return temp;
		//return item.expiration();
	}
}
