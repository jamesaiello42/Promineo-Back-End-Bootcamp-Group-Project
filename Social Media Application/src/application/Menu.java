package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import dao.CommentsDao;
import dao.LikesDao;

public class Menu {
	// Objects are responsible for directly touching the db. 
	private CommentsDao commentsDao;
	private LikesDao likesDao;
	private Scanner scanner = new Scanner(System.in);
	
	// These are options that the user can select from the menu
	// Add new options here
	private List<String> options = Arrays.asList(
			"Display All Posts and Comments by User ID"
	);
	
	// Create a data access object to allow getting data from the db via a layer
	public Menu() {
		commentsDao = new CommentsDao();
		likesDao = new LikesDao();
	}
	
	// Function serves as the main driver of the Menu object
	public void start() throws SQLException {
		String selection = "";
		
		do {
			
			// Print menu and receive user's menu selection
			printMenu();
			selection = scanner.nextLine();
			
			// Determine which operation
			switch (selection) {
				// Display all comments and post by the passed in user from the db
				case "1":
					
					System.out.println();
					break;								
			}
			
			// Line for neatness
			System.out.println();
			
		} while (!selection.equals("-1"));
	}
	
	// Loops through list of options that output to the user's screen
	private void printMenu() {
		System.out.println("Select an Option (-1 to terminate program):\n---------------------------------------------");
		for (int i = 0; i < options.size(); i++)
			System.out.println((i + 1) + ") " + options.get(i));
		
		System.out.println("\nSelection: ");
	}
}
