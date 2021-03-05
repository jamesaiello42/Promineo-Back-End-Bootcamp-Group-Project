package entity;

public class Posts {
	private int id;
	private int posterId;
	private String postText;
	private String datePosted;
	private String dateEdited;
	
	public int getId() {
		return id;
	}
	
	public int getPosterId() {
		return posterId;
	}
	
	public String getDatePosted() {
		return datePosted;
	}
	
	public String getDateEdited() {
		return dateEdited;
	}

	public String getPostText() {
		return postText;
	}
	
}
