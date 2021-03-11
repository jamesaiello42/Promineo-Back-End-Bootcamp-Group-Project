package entity;

// Wendy Sun contributed setters and getters
// Fields were implemented by James Aiello.

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
	
	// James Aiello and Wendy Sun contributed this one
	public Comments(int id, String commenterUsername, String commentText, String postText, String posterUsername) {
		this.setId(id); 
		this.setCommenterId(commenterId); 
		this.setCommenterUsername(commenterUsername); 
		this.setCommentText(commentText); 
		this.setPostText(postText); 
		this.setPosterUsername(posterUsername); 
	}//end constructor 
	
	// Wendy Sun contributed constructor
	public Comments(int postId, String postText, int CommenterId, String commentText, String dateCommented ) {

		this.setPostId(postId); 
		this.setPostText(postText); 
		this.setCommenterId(commenterId);
		this.setCommentText(commentText);
		this.setDateCommented(dateCommented); 
	}//end constructor

	private void setId(int id) {
		this.id = id;			
	}//end setId
	
	private void setPostId(int postId) {
		this.postId= postId; 	
	}//end setPostId
		
	private void setCommenterId(int commenterId) {
		this.commenterId = commenterId;
	}//end setCommenterId

	private void setCommenterUsername(String commenterUsername) {
		this.commenterUsername = commenterUsername; 	
	}//end setCommenterUsername 

	private void setCommentText(String commentText) {
		this.commentText = commentText; 		
	}//end setCommentText

	private void setDateCommented(String dateCommented) {
		this.dateCommented = dateCommented;	
	}//end setDateCommented
	
	private void setPosterUsername(String posterUsername) {
		this.posterUsername = posterUsername; 		
	}// end setPosterUsername 

	private void setPostText(String postText) {
		this.postText = postText; 		
	}//end setPostText
	
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
