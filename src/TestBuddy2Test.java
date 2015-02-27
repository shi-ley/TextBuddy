import static org.junit.Assert.assertEquals;
import org.junit.Test;



public class TestBuddy2Test {

	@Test
	public void testExecuteCommand() {
		
		TextBuddy2.processInputData("add a red hat");
		testOneCommand("display all the currently stored input", "1. a red hat", "display");
		TextBuddy2.processInputData("add a blue hat");
		testOneCommand("display all the currently stored input", "1. a red hat\n2. a blue hat", "display");
		
			}
	

	private void testOneCommand(String description, String expected, String command) {
		assertEquals(description, expected, TextBuddy2.processInputData(command)); 
	}

}

