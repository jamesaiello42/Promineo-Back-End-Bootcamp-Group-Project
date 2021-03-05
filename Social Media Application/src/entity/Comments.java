package entity;

public class Comments {
	private int id;
	private int postId;
	private int commenterId;
	private String commenterUsername;
	private String commentText;
	private String dateCommented;
	private String dateEdited;
	
	// Post data
	private String postText;
	private String posterUsername;
	
	public int getId() {
		return id;
	}
	
	public int getPostId() {
		return postId;
	}
	
	public int getCommenterId() {
		return commenterId;
	}
	
	public String getCommentText() {
		return commentText;
	}
	
	public String getDateCommented() {
		return dateCommented;
	}
	
	public String getDateEdited() {
		return dateEdited;
	}

	public String getCommenterUsername() {
		return commenterUsername;
	}

	public String getPostText() {
		return postText;
	}

	public String getPosterUsername() {
		return posterUsername;
	}
}
