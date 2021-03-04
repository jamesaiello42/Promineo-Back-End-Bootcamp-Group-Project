package entity;

public class Likes {
	private int id;
	private int userId;
	private int postOrCommentId;
	private String postOrComment;
	private String dateLike;
	
	public Likes(int id, int userId, int postOrCommentId, String postOrComment, String dateLike) {
		this.id = id;
		this.userId = userId;
		this.postOrCommentId = postOrCommentId;
		this.postOrComment = postOrComment;
		this.dateLike = dateLike;
	}

	public int getId() {
		return id;
	}

	public int getUserId() {
		return userId;
	}

	public int getPostOrCommentId() {
		return postOrCommentId;
	}

	public String getPostOrComment() {
		return postOrComment;
	}

	public String getDateLike() {
		return dateLike;
	}
	
}
