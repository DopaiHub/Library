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
	protected String userType;
	protected ArrayList<Item> itemList;

	public User()
	{
		
	}
	
	public User(String firstName, String lastName, String address,
			int phoneNumber, String email, int age, String password,
			int itemLimit, double balance, String userType, ArrayList<Item> itemList)
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
		this.userType = userType;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getItemLimit() {
		return itemLimit;
	}

	public void setItemLimit(int itemLimit) {
		this.itemLimit = itemLimit;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
