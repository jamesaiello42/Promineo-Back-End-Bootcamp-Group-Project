package entity;

// This entity class for both tables comment_likes and post_likes
public class Likes {
	private int id;
	private int userId;
	private int postOrCommentId;
	private String dateLiked;
	
	// Stores user GET_POST_COMMENTS_TOTAL_BY_USER_QUERY info
	private String userName;
	private int postLikes;
	private int commentLikes;
	
	// Used to by the GET_POST_COMMENTS_TOTAL_BY_USER_QUERY
	public Likes(String userName, int postLikes, int commentLikes) {
		super();
		this.userName = userName;
		this.postLikes = postLikes;
		this.commentLikes = commentLikes;
	}
	
	// Get id of post like or comment like
	public int getId() {
		return id;
	}

	// Get id of user
	public int getUserId() {
		return userId;
	}

	// Get post or comment id
	public int getPostOrCommentId() {
		return postOrCommentId;
	}

	// Gets date post or comment was like
	public String getDateLiked() {
		return dateLiked;
	}

	// Get username of like
	public String getUserName() {
		return userName;
	}

	// Get post like count
	public int getPostLikes() {
		return postLikes;
	}

	// Get comment like count
	public int getCommentLikes() {
		return commentLikes;
	}
	
	
	
}
