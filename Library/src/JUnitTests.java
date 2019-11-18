import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnitTests {

	@Test
	void launchSystemTest() {
		SystemShell shell = null;
		shell = SystemShell.launchSystem();
		assert(shell != null);
	}

}
