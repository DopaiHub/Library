import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class JUnitTests {

	@Test
	void launchSystemTest() {
		SystemShell shell = null;
		shell = SystemShell.launchSystem();
		assert(shell != null);
	}

	@Test
	void searchItemPassTest() {
		SystemShell shell = SystemShell.launchSystem();
		ArrayList<Item> items = new ArrayList<Item>();
		String book = "book";
		items = shell.searchItem(book);
		assert(items.size() > 0);
	}
	
	@Test
	void searchItemFailTest() {
		SystemShell shell = SystemShell.launchSystem();
		ArrayList<Item> items = new ArrayList<Item>();
		String invalid = "invalid";
		items = shell.searchItem(invalid);
		assert(items.size() == 0);
	}
	
	@Test
	void loginUserPassTest() {
		SystemShell shell = SystemShell.launchSystem();
		String validEmail = "JD@email.com";
		String validPass = "123";
		assert(shell.loginUser(validEmail, validPass) != null);
	}
	
	@Test
	void loginUserFailTest() {
		SystemShell shell = SystemShell.launchSystem();
		String invalidEmail = "invalidUser";
		String invalidPass = "321";
		assert(shell.loginUser(invalidEmail, invalidPass) == null);
	}
	
	@Test
	/**
	 * Logins into JD's account and returns his copy of The Hitchhiker's Guide to the Galaxy, then checks if copies increased from before returned
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
	 * Cant checkout because he has fines
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
		shell.loginUser("bob@email.com", "123");
		int id=0;
		double fineAmount=5.0;
		double fines=shell.jsonUserList.get(id).getBalance();
		shell.addFine(fineAmount, "JD@email.com");
		double finesAfter=shell.jsonUserList.get(id).getBalance();
		assertEquals(fines,finesAfter);
	}
}
