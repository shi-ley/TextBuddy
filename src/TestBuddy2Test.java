import static org.junit.Assert.assertEquals;
import org.junit.Test;



public class TestBuddy2Test {

	@Test
	public void testExecuteCommand() {
		
		
		testOneCommand("display all the currently stored input", "a red hat", "display");
		
			}
	

	private void testOneCommand(String description, String expected, String command) {
		assertEquals(description, expected, TextBuddy2.processInputData(command)); 
	}

}

