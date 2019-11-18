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
	void returnItemPassTest()
	{
		SystemShell shell = SystemShell.launchSystem();
		String validEmail = "JD@email.com";
		String validPass = "123";
		shell.loginUser(validEmail, validPass);
		shell.returnItem(3);
		//shell.
	}
	
	//Need to make a user and log them in first
	/*@Test
	void logoutUserTest() {
		SystemShell shell = SystemShell.launchSystem();
		
		assert();
	}*/
	
}
