package entity;

public class Comments {
	// Comments Fields
	private int id;
	private int commenterId;
	private String commenterUsername;
	private String commentText;
	private String dateCommented;
	private String dateEdited;
	
	// Post data fields
	private int postId;
	private String postText;
	private String posterUsername;
	
	// Special constructor to set only Commenter Usernam, Comment Text, Post Text, Poster Name
	public Comments(String commenterUsername, String commentText, String postText, String posterUsername) {
		this.commenterUsername = commenterUsername;
		this.commentText = commentText;
		this.postText = postText;
		this.posterUsername = posterUsername;
	}

	// Getter for Field id
	public int getId() {
		return id;
	}
	
	// Getter for Field Post ID
	public int getPostId() {
		return postId;
	}
	
	// Getter for Field Commenter ID
	public int getCommenterId() {
		return commenterId;
	}
	
	// Getter for Field Comment Text
	public String getCommentText() {
		return commentText;
	}
	
	// Getter for Field Date Commented
	public String getDateCommented() {
		return dateCommented;
	}
	
	// Getter for Field Date Edited
	public String getDateEdited() {
		return dateEdited;
	}

	// Getter for Field Commenter Username
	public String getCommenterUsername() {
		return commenterUsername;
	}

	// Getter for Field Post Text
	public String getPostText() {
		return postText;
	}

	// Getter for Field Poster Username
	public String getPosterUsername() {
		return posterUsername;
	}
}
