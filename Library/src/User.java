/**
 * User is an abstract class that is used as the blueprint for User subclasses and has getter and setter methods for all instance variables
 * @author Uncrustables (Joshua, Adam, Steven)
 *
 */
public abstract class User {
	/**
	 * These are all instance variables that a User will have
	 */
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
	protected int[] itemList;

	/**
	 * Empty default constructor
	 */
	public User() {}
	
	/**
	 * Parameterized constructor used to create User objects
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
	public User(String firstName, String lastName, String address,
			int phoneNumber, String email, int age, String password,
			int itemLimit, double balance, String userType, int[] itemList) {
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
	
	/**
	 * Getter method for balances
	 * @return balance
	 */
	public double getBalance() {
		return this.balance;
	}
	
	//TODO need to add expiration() method to Item
	public int getExpiration(Item item) {
		int temp = 0;
		return temp;
		//return item.expiration();
	}
	/**
	 * Getter method for first names
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter method for setting first names
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter method for last names
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter method for setting last names
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getter method for addresses
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Setter method for setting addresses
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Getter method for phone numbers
	 * @return phoneNumber
	 */
	public int getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Setter method for setting phone numbers
	 * @param phoneNumber
	 */
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Getter method for emails
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter method for setting emails
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter method for ages
	 * @return age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Setter method for setting ages
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Getter method for passwords
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter method for setting passwords
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter method for item limits
	 * @return itemLimit
	 */
	public int getItemLimit() {
		return itemLimit;
	}

	/**
	 * Setter method for setting item limits
	 * @param itemLimit
	 */
	public void setItemLimit(int itemLimit) {
		this.itemLimit = itemLimit;
	}

	/**
	 * Getter method for user types
	 * @return userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * Setter method for setting user types
	 * @param userType
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	/**
	 * Getter method for item lists
	 * @return itemList
	 */
	public int[] getItemList() {
		return itemList;
	}

	/**
	 * Setter method for setting item lists
	 * @param itemList
	 */
	public void setItemList(int[] itemList) {
		this.itemList = itemList;
	}

	/**
	 * Setter method for setting balances
	 * @param balance
	 */
	public void setBalance(double balance) {
		/*
		 * if-else statement that checks to see if the sent-in value is greater than or equal to 0
		 * if >=0: sets this.balance to the sent-in balance
		 * else: sets this.balance to 0
		 */
		if(balance>=0)
			this.balance = balance;
		else
			this.balance=0;
	}
}