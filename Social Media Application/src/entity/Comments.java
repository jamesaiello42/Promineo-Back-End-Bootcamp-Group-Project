package entity;

public class Comments {
	private int id;
	private int postId;
	private int commenterId;
	private String commentText;
	private String dateCommented;
	private String dateEdited;
	
	public Comments(int id, int postId, int commenterId, String commentText, String dateCommented, String dateEdited) {
		this.id = id;
		this.postId = postId;
		this.commenterId = commenterId;
		this.commentText = commentText;
		this.dateCommented = dateCommented;
		this.dateEdited = dateEdited;
	}

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
}
