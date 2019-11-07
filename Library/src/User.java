import java.util.ArrayList;

public class User {
	private String firstName;
	private String lastName;
	private String address;
	private int phoneNumber;
	private String email;
	private int age;
	private String password;
	private int itemLimit;
	private double balance;
	private ArrayList<Item> itemList;

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
