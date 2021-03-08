package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import dao.CommentsDao;
import dao.LikesDao;
import entity.Comments;
import entity.Likes;

public class Menu {
	// Objects are responsible for directly touching the db. 
	private CommentsDao commentsDao;
	private LikesDao likesDao;
	private Scanner scanner = new Scanner(System.in);
	
	// These are options that the user can select from the menu
	// Add new options here
	private List<String> options = Arrays.asList(
			"Display All Posts and Comments by User ID",
			"Create a new comment",
			"Update Comment Text by ID",
			"Delete Comment by ID",
			"Show number of Post and Comment Likes by User ID",
			"Like a Post or like a Comment",
			"Unlike a Post or like a Comment",
			"Update Date Like on a Comment or Post"
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
			
			// These are variables are initialized the by scanner objects and passed to dao objects
			int userId;
			int postId;
			int postCommentId;
			
			// More like, post, and comment variabel
			int commentId;
			int likeId;
			String commentText;
			String commOrPost;
			String dateLiked;
			
			// Determine which operation
			try {
					switch (selection) {
						// Display all comments and post by the passed in user from the db
						case "1":		
							System.out.println("\nEnter in the ID of the User: ");
							userId = Integer.parseInt(scanner.nextLine());
							System.out.println();
							displayCommentsPostsByUser(userId);
							System.out.println("\n");
							break;
						// Menu option creates a new comment on a post
						case "2":
							System.out.println("\nEnter the Post ID, Commenter ID, and Comment Text: ");
							postId = Integer.parseInt(scanner.nextLine());
							userId = Integer.parseInt(scanner.nextLine());
							commentText = scanner.nextLine();
							createNewComment(postId, userId, commentText);
							break;
						// Menu option updates a comment's text based off what ID and string the user passes in
						case "3":
							System.out.println("\nEnter the Comment ID, and Comment Text: ");
							commentId = Integer.parseInt(scanner.nextLine());
							commentText = scanner.nextLine();
							updateCommentByID(commentId, commentText);
							break;
						// Menu option deletes a comment by
						case "4":
							System.out.println("\nEnter the Comment ID to delete a comment (will also delete from Likes table due to dependency): ");
							commentId = Integer.parseInt(scanner.nextLine());
							deleteCommentByID(commentId);
							break;
						// Show number of likes for one user's posts or comments
						case "5":
							System.out.println("\nEnter the ID of the User: ");
							userId = Integer.parseInt(scanner.nextLine());
							System.out.println();
							displayNumberOfPostsCommentLikesByUser(userId);
							break;
						case "6":
							// Ask user if they want to like a post or comment
							System.out.println("\nLike a post or comment?: ");
							commOrPost = scanner.nextLine();
							
							// Checks whether option given was correct or not,
							if (commOrPost.toLowerCase().equals("post") || commOrPost.toLowerCase().equals("comment")) {
								System.out.println("\nGive the User ID and ID of the " + commOrPost.toLowerCase() + ": ");
								postCommentId = Integer.parseInt(scanner.nextLine());
								
								// Likes a post or comment
								userId = Integer.parseInt(scanner.nextLine());
								System.out.println();
								likePostOrComment(userId, postCommentId, commOrPost.toLowerCase());			
								
							}
							// Tell user invalid choice
							else
								System.out.println("Invalid option given. Please try again");
							break;
						case "7":
							// Ask user if they want to like a post or comment
							System.out.println("\nUnlike a post or comment?: ");
							commOrPost = scanner.nextLine();
							
							// Checks whether option given was correct or not,
							if (commOrPost.toLowerCase().equals("post") || commOrPost.toLowerCase().equals("comment")) {
								System.out.println("\nGive the Like ID of the "  + commOrPost.toLowerCase() + ": ");
								likeId = Integer.parseInt(scanner.nextLine());
								System.out.println();
								unlikePostOrComment(likeId, commOrPost.toLowerCase());			
							}
							// Tell user invalid choice
							else
								System.out.println("\nInvalid option given. Please try again");
							break;
						case "8":
							// Ask user if they want to like a post or comment
							System.out.println("\nChange the Date Liked of a post or comment?: ");
							commOrPost = scanner.nextLine();
							
							// Checks whether option given was correct or not,
							if (commOrPost.toLowerCase().equals("post") || commOrPost.toLowerCase().equals("comment")) {
								System.out.println("\nGive the Like ID of the "  + commOrPost.toLowerCase() + " and enter the date in this format (YYYY-MM-DD HH:mm): ");
								likeId = Integer.parseInt(scanner.nextLine());
								dateLiked = scanner.nextLine();
								System.out.println();
								updateDateLiked(likeId, dateLiked, commOrPost.toLowerCase());
							}
							// Tell user invalid choice
							else
								System.out.println("\nInvalid option given. Please try again");
							break;
				}
			}
			// Show user any SQL errors
			catch (SQLException e) {
				e.printStackTrace();
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
	
	private void createNewComment(int postId, int commenterId, String commentText) throws SQLException
	{
		commentsDao.createNewComment(postId, commenterId, commentText);
	}
	
	// Updates a single comment text by id 
	private void updateCommentByID(int commentId, String commentText) throws SQLException {
		commentsDao.updateComment(commentId, commentText);	
	}
	
	private void deleteCommentByID(int commentId) throws SQLException {
		commentsDao.deleteCommentById(commentId);
	}
	
	// Outputs a single row representing how many likes on a user's posts or comments
	private void displayNumberOfPostsCommentLikesByUser(int userId) throws SQLException {
		Likes likeNum = likesDao.getNumberOfPostsCommentLikesByUser(userId);
		
		// If there are zero rows, tell the user nothing is found
		if (likeNum.getUserName() == null)
			System.out.println("Results of Posts and Comments by User ID query \"" + userId + "\" not found.");
		else
			// Show comment, post info, and usernames attached to both.
			System.out.println("Username: " + likeNum.getUserName() + " | Number of Post Likes by this User: " + likeNum.getPostLikes() + " | Number of Comment Likes by this User: " + likeNum.getCommentLikes());
	}
	
	// Like a post or comment
	private void likePostOrComment(int userId, int id, String type) throws SQLException
	{
		likesDao.like(userId, id, type);
	}
	
	// Remove a like from a comment or post
	private void unlikePostOrComment(int id, String type) throws SQLException
	{
		likesDao.unlike(id, type);
	}
	
	// Update a comment or post liked date by id
	private void updateDateLiked(int id, String date, String type) throws SQLException {
		likesDao.updateLikeDate(id, date, type);
	}
	
	// Loops through list of options that output to the user's screen
	private void printMenu() {
		System.out.println("Select an Option (-1 to terminate program):\n---------------------------------------------");
		for (int i = 0; i < options.size(); i++)
			System.out.println((i + 1) + ") " + options.get(i));
		
		System.out.println("\nSelection: ");
	}
}
