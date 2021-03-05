package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import dao.CommentsDao;
import dao.LikesDao;
import entity.Comments;

public class Menu {
	// Objects are responsible for directly touching the db. 
	private CommentsDao commentsDao;
	private LikesDao likesDao;
	private Scanner scanner = new Scanner(System.in);
	private Scanner scanner2 = new Scanner(System.in);
	
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
			
			// These are variables are initialized the by scanner objects and passed to the dao object
			int userId;
			
			// Determine which operation
			switch (selection) {
				// Display all comments and post by the passed in user from the db
				case "1":		
					System.out.println("\nEnter in the ID of the User: ");
					userId = scanner2.nextInt();
					System.out.println();
					displayCommentsPostsByUser(userId);
					System.out.println("\n");
					break;								
			}
			
			// Line for neatness
			System.out.println();
			
		} while (!selection.equals("-1"));
	}
	
	// Outputs a list of post and comments by a user id and shows are usernames attached to comments and posts
	private void displayCommentsPostsByUser(int userId) throws SQLException {
		List<Comments> comments = commentsDao.getCommentsPostsByUser(userId);
		
		// Show comment, post info, and usernames attached to both.
		for (Comments comment : comments) {
			System.out.println("Post: " + comment.getPostText() + " | Poster: " + comment.getPosterUsername() + " | Comment: " + comment.getCommentText() + " | Commenter: " + comment.getCommenterUsername());
		}
		
		// If there are zero rows, tell the user nothing is found
		if (comments.size() == 0)
			System.out.println("Results of Posts and Comments by User ID query \"" + userId + "\" not found.");
	}	
	
	// Loops through list of options that output to the user's screen
	private void printMenu() {
		System.out.println("Select an Option (-1 to terminate program):\n---------------------------------------------");
		for (int i = 0; i < options.size(); i++)
			System.out.println((i + 1) + ") " + options.get(i));
		
		System.out.println("\nSelection: ");
	}
}
