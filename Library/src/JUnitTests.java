import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * JUnit test class
 * @author Uncrustables (Josh,Adam,Steven)
 *
 */
class JUnitTests {

	@Test
	/**
	 * Create a system shell object and expect the created object not to be null
	 */
	void launchSystemTest() {
		SystemShell shell = null;
		shell = SystemShell.launchSystem();
		assert(shell != null);
	}

	@Test
	/**
	 * Search for an item using a valid search term and expect at least one result
	 */
	void searchItemPassTest() {
		SystemShell shell = SystemShell.launchSystem();
		ArrayList<Item> items = new ArrayList<Item>();
		String book = "book";
		items = shell.searchItem(book);
		assert(items.size() > 0);
	}
	
	@Test
	/**
	 * Search for an item using an invalid search term and expect no results
	 */
	void searchItemFailTest() {
		SystemShell shell = SystemShell.launchSystem();
		ArrayList<Item> items = new ArrayList<Item>();
		String invalid = "invalid";
		items = shell.searchItem(invalid);
		assert(items.size() == 0);
	}
	
	@Test
	/**
	 * Provide valid username and password and expect the user to be logged in
	 */
	void loginUserPassTest() {
		SystemShell shell = SystemShell.launchSystem();
		String validEmail = "JD@email.com";
		String validPass = "123";
		assert(shell.loginUser(validEmail, validPass) != null);
	}
	
	@Test
	/**
	 * Provide invalid username and password and expect the user not to be logged in
	 */
	void loginUserFailTest() {
		SystemShell shell = SystemShell.launchSystem();
		String invalidEmail = "invalidUser";
		String invalidPass = "321";
		assert(shell.loginUser(invalidEmail, invalidPass) == null);
	}
	
	@Test
	/**
	 * Logins into JD's account and returns his copy of The Hitchhiker's Guide to the Galaxy, then checks if copies increased from before returned
	 * Search valid keyword and return items that match
	 */
	void returnItemPassTest()
	{
		SystemShell shell = SystemShell.launchSystem();
		shell.loginUser("JD@email.com", "123");
		int id = 3;
		int copies = shell.jsonItemList.get(id-1).getNumCopies();
		shell.returnItem(id);
		int copiesAfter = shell.jsonItemList.get(id-1).getNumCopies();
		assert(copiesAfter > copies);
	}
	
	@Test
	/**
	 * Logins into JD's account and tries to return an item he doesn't have, then checks to see that copies before and after are equal
	 */
	void returnItemFailTest()
	{
		SystemShell shell = SystemShell.launchSystem();
		shell.loginUser("JD@email.com", "123");
		int id = 4;
		int copies = shell.jsonItemList.get(id-1).getNumCopies();
		shell.returnItem(id);
		int copiesAfter = shell.jsonItemList.get(id-1).getNumCopies();
		assertEquals(copiesAfter, copies);
	}
	
	@Test
	/**
	 * Logins into JD's account then searches for Dante's Peak, then checks to see if the id returned matches with the expected id
	 */
	void returnIDByNamePassTest()
	{
		SystemShell shell = SystemShell.launchSystem();
		shell.loginUser("JD@email.com", "123");
		int peakID = 5;
		int returnedID = shell.returnIDByName("Dante's Peak");
		assertEquals(returnedID, peakID);
	}
	
	@Test
	/**
	 * Logins into JD's account then searches for a misspelled item, then checks to see if id returned is -1
	 */
	void returnIDByNameFailTest()
	{
		SystemShell shell = SystemShell.launchSystem();
		shell.loginUser("JD@email.com", "123");
		int returnedID = shell.returnIDByName("Dante's Peek");
		assertEquals(returnedID, -1);
	}
	
	@Test
	/**
	 * Login to JD@email.com and checksout The Cat in The Hat, checks if copies of The Cat in The Hat went down by 1
	 */
	void checkOutItemPassTest() {
		SystemShell shell = SystemShell.launchSystem();
		shell.loginUser("JD@email.com", "123");
		int id=1;
		int copies=shell.jsonItemList.get(id-1).getNumCopies();
		shell.checkoutItem(id);
		int copiesAfter=shell.jsonItemList.get(id-1).getNumCopies();
		assertEquals(copies,copiesAfter+1);
	}
	
	@Test 
	/**
	 * Can't checkout because he has fines
	 */
	void checkOutItemFailTest() { 
		SystemShell shell = SystemShell.launchSystem(); 
		shell.loginUser("bob@email.com", "123"); 
		int id=1; 
		int copies=shell.jsonItemList.get(id-1).getNumCopies();
		shell.checkoutItem(id); 
		int copiesAfter=shell.jsonItemList.get(id-1).getNumCopies();
		assertEquals(copies,copiesAfter);
	}
	@Test
	/**
	 * Tests if adding stock to an item works
	 */
	void addStockPassTest() {
		SystemShell shell = SystemShell.launchSystem();
		shell.loginUser("admin@email.com", "123");
		int id=0;
		String itemName="The Cat in the Hat";
		int addAmount=1;
		int copies=shell.jsonItemList.get(id).getNumCopies();
		shell.addStock(itemName, addAmount);
		int copiesAfter=shell.jsonItemList.get(id).getNumCopies();
		assertEquals(copies+addAmount,copiesAfter);
	}
	@Test
	/**
	 * Tests to see if adding stock to a random item would add stock to an item
	 */
	void addStockFailTest() {
		SystemShell shell = SystemShell.launchSystem();
		shell.loginUser("admin@email.com", "123");
		int id=0;
		String itemName="Random Book";
		int addAmount=1;
		int copies=shell.jsonItemList.get(id).getNumCopies();
		shell.addStock(itemName, addAmount);
		int copiesAfter=shell.jsonItemList.get(id).getNumCopies();
		assertEquals(copies,copiesAfter);
	}
	@Test
	/**
	 * Tests if review array is increased when a review is added
	 */
	void addReviewPassTest() {
		SystemShell shell=SystemShell.launchSystem();
		shell.loginUser("JD@email.com","123");
		String itemName="The Cat in the Hat";
		double rating=5;
		String review="It was cool";
		int reviews=shell.jsonItemList.get(0).getReviews().length;
		shell.addReview(itemName, rating, review);
		int reviewsAfter=shell.jsonItemList.get(0).getReviews().length;
		assert((reviews-reviewsAfter<0)==true);
	}
	@Test
	/**
	 * Tests if an incorrect item name is given as a parameter, nothing happens
	 */
	void addReviewFailTest() {
		SystemShell shell=SystemShell.launchSystem();
		shell.loginUser("JD@email.com","123");
		String itemName="Random Book";
		double rating=5;
		String review="It was cool";
		int reviews=shell.jsonItemList.get(0).getReviews().length;
		shell.addReview(itemName, rating, review);
		int reviewsAfter=shell.jsonItemList.get(0).getReviews().length;
		assert((reviews-reviewsAfter<0)==false);
	}
	@Test
	/**
	 * Adds a fine of $5.0 to JD@email.com
	 */
	void addFinePassTest() {
		SystemShell shell = SystemShell.launchSystem();
		shell.loginUser("admin@email.com", "123");
		int id=0;
		double fineAmount=5.0;
		double fines=shell.jsonUserList.get(id).getBalance();
		shell.addFine(fineAmount, "JD@email.com");
		double finesAfter=shell.jsonUserList.get(id).getBalance();
		assertEquals(fines+fineAmount,finesAfter);
	}
	@Test
	/**
	 * Can't add fine because user logged in isn't an admin
	 */
	void addFineFailTest() {
		SystemShell shell = SystemShell.launchSystem();
		shell.uAdmin=null;
		shell.loginUser("bob@email.com", "123");
		int id=0;
		double fineAmount=5.0;
		double fines=shell.jsonUserList.get(id).getBalance();
		shell.addFine(fineAmount, "JD@email.com");
		double finesAfter=shell.jsonUserList.get(id).getBalance();
		assertEquals(fines,finesAfter);
	}
	@Test
	/**
	 * Logins into JD's account and calls to see the user items, then checks to see that the only two books JD has match the expected
	 */
	void getUserItemsTest()
	{
		SystemShell shell = SystemShell.launchSystem();
		shell.loginUser("JD@email.com", "123");
		String book1and2 = "The Cat in the Hat";
		String[] returnedItems = shell.getUserItems();
		System.out.println("Returned Items 0 and 1: " + returnedItems[0]);
		assertTrue(returnedItems[0].equals(book1and2) && returnedItems[1].equals(book1and2));
	}
	
	@Test
	/**
	 * Logins into JD's account and calls searchWaitlistForUser to see about items he's on the waitlist for, then checks to see that the expected
	 * items line up with what he actually has on his waitlist
	 * 
	 * Given that this will always return a string array that either returns null or strings, there is no fail condition, regardless of if the
	 * wrong email is entered or not
	 */
	void searchWaitlistForUserPassTest()
	{
		SystemShell shell = SystemShell.launchSystem();
		shell.loginUser("JD@email.com", "123");
		String email = "JD@email.com";
		String expectedItem1 = "To Kill a Mockingbird";
		String expectedItem2 = "Dante's Peak";
		String[] waitListItems = shell.searchWaitListForUser(email);
		for (int i = 0; i < waitListItems.length; i++)
			System.out.println(waitListItems[i] + " ");
		assertTrue(waitListItems[0].equals(expectedItem1) && waitListItems[1].equals(expectedItem2) && waitListItems[2] == null);
	}
	@Test
	/**
	 * Registers an adult given correct parameters
	 */
	void registerAdultUserTest() {
		SystemShell shell = SystemShell.launchSystem();
		int usersSize = shell.jsonUserList.size();
		String firstName = "john";
		String lastName = "paul";
		String address = "test lane";
		int phoneNumber = 123;
		String email = "JP@email.com";
		int age = 50;
		String password = "12345";
		String userType = "adult";
		shell.registerUser(firstName, lastName, address,
				phoneNumber, email, age, password, userType);
		assert(shell.jsonUserList.size() != usersSize);
	}
	@Test
	/**
	 * Registers an admin given correct parameters
	 */
	void registerAdminUserTest() {
		SystemShell shell = SystemShell.launchSystem();
		int usersSize = shell.jsonUserList.size();
		String firstName = "john";
		String lastName = "paul";
		String address = "test lane";
		int phoneNumber = 123;
		String email = "JP@email.com";
		int age = 50;
		String password = "12345";
		String userType = "admin";
		shell.registerUser(firstName, lastName, address,
				phoneNumber, email, age, password, userType);
		assert(shell.jsonUserList.size() != usersSize);
	}
	/*@Test
	/**
	 * User pays a fine
	*/
	void payFinesTest() {
		SystemShell shell = SystemShell.launchSystem();
		User user = new Adult();
		shell.loginUser("bob@email.com", "123");
		for(int i = 0; i < shell.jsonUserList.size(); i++) {
			if(shell.jsonUserList.get(i).getLastName().equals("Ross")) {
				user = shell.jsonUserList.get(i);
			}
		}
		
		double bal = user.getBalance();
		shell.payFines(10.0);
		assert(user.getBalance() != bal);
	}
}
