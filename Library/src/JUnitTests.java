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
	
	
	//Need to make a user and log them in first
	/*@Test
	void logoutUserTest() {
		SystemShell shell = SystemShell.launchSystem();
		
		assert();
	}*/
	
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
		System.out.println(copies+" "+copiesAfter);
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
}
