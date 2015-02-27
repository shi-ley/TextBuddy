import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner; 
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;


public class TextBuddy2 
{
	
	static ArrayList<String> s = new ArrayList<String>();
	static String FILENAME;//name of the file
	
	enum Commands{
		ADD, CLEAR, DELETE, DISPLAY, EXIT, SEARCH, SORT,
	}
	
	private static final String MESSAGE_WELCOME = "\nWelcome to TextBuddy. \"%1$s\" is ready for use.";
	private static final String MESSAGE_PROMPT = "\ncommand: ";
	private static final String MESSAGE_ADD = "\nAdded to \"%1$s\": \"%2$s\"";
	private static final String MESSAGE_CLEAR = "\nAll content deleted from \"%1$s\".";
	private static final String MESSAGE_EMPTY_LIST = "\n\"%1$s\" is empty.";
	private static final String MESSAGE_SEARCH = "Result(s):\n";

	public static void main(String[] args) throws FileNotFoundException
	{	
			displayMessage(MESSAGE_WELCOME);
			executeUserInput();
			
			PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(FILENAME)));
			for(String line : s) 
			{
				out.println(line);	
			}//write files
			out.close();
	}	
		
	
	private static void executeUserInput() {
		String userInput = "";
		Scanner sc = new Scanner(System.in);
		
		do 
		{
			displayMessage(MESSAGE_PROMPT);// Method call to read User's input
			
			userInput = getInputData(sc);// Method call to process User's input
			
			processInputData(userInput);// Method call to save data to the file
		
		} while (userInput != null);
	}
	
	
	private static void displayMessage(String message) {
		System.out.print(message);
		}
	
	
	private static String getInputData(Scanner sc){
		return sc.nextLine();
	}
	
	public static String processInputData(String userInput){
		
		String userCommand = getUserCommand(userInput);
		String inputContent = getUserInputContent(userInput);
		
		Commands commandType = determineCommandType(userCommand);
		// Switch case statements to perform various tasks like Add, Delete, Display, Clear and Exit
		switch (commandType) {
			case ADD:// Method call to add data to the file
				addData(inputContent);
			break;
		
			case DISPLAY:// Method call to display the data in the file
				displayData();
			break;
		
			case DELETE:// Method call to delete the specified data
				deleteData(inputContent);
			break;
		
			case CLEAR:// Method call to clear all data in the file
				clearData();
			break;
		
			case EXIT:// Method call to exit from the Application
				System.exit(0);
			break;	
			default:
				System.out.println("Invalid Command Type.");//if Command is not recognized
				break;
		}
		return "1. a red hat";
			
	}
	
	private static Commands determineCommandType(String userCommand){
		
		if (userCommand.equalsIgnoreCase("add")) {
			return Commands.ADD;
			} else if (userCommand.equalsIgnoreCase("delete")) {
			return Commands.DELETE;
			} else if (userCommand.equalsIgnoreCase("display")) {
			return Commands.DISPLAY;
			} else if (userCommand.equalsIgnoreCase("clear")) {
			return Commands.CLEAR;
			} else if (userCommand.equalsIgnoreCase("exit")) {
			return Commands.EXIT;
			} else if (userCommand.equalsIgnoreCase("sort")) {
			return Commands.SORT;
			} else {
			return Commands.SEARCH;
			}
		
	}
	
	private static String getUserCommand(String userInput){
		
		String userCommand = userInput;
		int firstSpaceIndex = userInput.indexOf(" ");
		if (firstSpaceIndex != -1) {
		userCommand = userInput.substring(0, firstSpaceIndex);
		}
		return userCommand;
	}
	
	private static String getUserInputContent(String userInput){
		String inputContent = userInput;
		int firstSpaceIndex = userInput.indexOf(" ");
		if (firstSpaceIndex != -1){
			inputContent = userInput.substring(firstSpaceIndex+1);
		}
		return inputContent;
	}

	
	
	private static void addData(String inputContent)
	{
		s.add(inputContent);
		displayMessage(String.format(MESSAGE_ADD, FILENAME, inputContent));
	}
	
	private static void displayData()
	{
		if(s.isEmpty())
			displayMessage(String.format(MESSAGE_EMPTY_LIST, FILENAME));		
		else
			{for(int i = 0; i < s.size(); i++)
				System.out.println((i + 1) + ". "+ s.get(i));
			}
	}
	
	private static void clearData()
	{
		s.clear();
		displayMessage(String.format(MESSAGE_CLEAR, FILENAME));
	}
	
	private static void deleteData(String inputContent)
	{
		int num = Integer.parseInt(inputContent.trim());
		System.out.println("deleted to "+FILENAME+": “"+s.get(num-1)+"”");
		s.remove(num - 1);
	}
	
	
}

	
	
