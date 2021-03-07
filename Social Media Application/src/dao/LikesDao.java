package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Likes;

public class LikesDao {
	private Connection connection;
	
	// Get connection for Social Media database and create Likes data access object
	public LikesDao() {
		connection = DBConnection.getConnection();
	}
	
	// Query pulls back how many likes on a user's posts or comments
	private final String GET_POST_COMMENTS_TOTAL_BY_USER_QUERY = "SELECT MAX(POST_LIKE_CNT) AS POST_LIKE_CNT, " +
													"MAX(COMMENT_LIKE_COUNT) AS COMMENT_LIKE_COUNT, " +
													"U.USERNAME " +
													"FROM " +
													"( " +
													"SELECT COUNT(*) AS POST_LIKE_CNT, " +
													"0 AS COMMENT_LIKE_COUNT, " +
													"? AS USER_ID " +
													"FROM POST_LIKES " +
													"WHERE USER_ID = ? " +
													"UNION " + 
													"SELECT 0 AS POST_LIKE_CNT, " + 
													"COUNT(*) AS COMMENT_LIKE_COUNT, " + 
													"? AS USER_ID " + 
													"FROM COMMENT_LIKES " + 
													"WHERE USER_ID = ? " + 
													") AS TOTAL_LIKES " + 
													"INNER JOIN USERS AS U " + 
													"	ON U.ID = TOTAL_LIKES.USER_ID ";
	
	// Like a post or comment
	private final String CREATE_POST_LIKE_QUERY = "INSERT INTO POST_LIKES (USER_ID, POST_ID, DATE_LIKED) VALUES (?, ?, NOW())";
	private final String CREATE_COMMENT_LIKE_QUERY = "INSERT INTO COMMENT_LIKES (USER_ID, COMMENT_ID, DATE_LIKED) VALUES (?, ?, NOW())";
	private final String QUERY_CHECK_POST = "SELECT COUNT(*) AS CNT FROM POSTS WHERE ID = ?";
	private final String QUERY_CHECK_COMMENT = "SELECT COUNT(*) AS CNT FROM COMMENTS WHERE ID = ?";
	private final String QUERY_CHECK_USER = "SELECT COUNT(*) AS CNT FROM USERS WHERE ID = ?";
	
	// Remove a like from a post or comment
	private final String DELEATE_POST_LIKE_QUERY = "DELETE FROM POST_LIKES WHERE ID = ?";
	private final String DELETE_COMMENT_LIKE_QUERY = "DELETE FROM COMMENT_LIKES WHERE ID = ?";
	
	// Method queries database by comments, posts, and users
	public Likes getNumberOfPostsCommentLikesByUser(int userId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_POST_COMMENTS_TOTAL_BY_USER_QUERY);
		
		// The same parameter value four times over
		for (int i = 1; i <= 4; i++)
			ps.setInt(i, userId);
		
		ResultSet rs = ps.executeQuery();
		Likes userLikeCnt = null;
		
		// Loop through all rows and store in Comments list 
		while (rs.next()) {
			userLikeCnt = new Likes(rs.getString(3), rs.getInt(1), rs.getInt(2));
		}
		
		// Return comments, posts, usernames list
		return userLikeCnt;
	}	
	
	// Methods creates a new comment in the database
	public void like (int userId, int id, String type) throws SQLException {	
		
		// Check variable to prevent program erroring out when parent does not exist
		int checkPostComment = 0, checkUser = 0;
		ResultSet rs, rs2;
		
		// Statement to prevent program erroring out when parent comment does not exist
		if (type.equals("comment")) {
			PreparedStatement ps = connection.prepareStatement(QUERY_CHECK_COMMENT);
			ps.setInt(1, id);
			rs = ps.executeQuery();
		}
		else {
			// Statement to prevent program erroring out when parent post does not exist
			PreparedStatement ps = connection.prepareStatement(QUERY_CHECK_POST);
			ps.setInt(1, id);
			rs = ps.executeQuery();
		}
		
		// Statement to prevent program erroring out when parent user does not exist
		PreparedStatement ps2 = connection.prepareStatement(QUERY_CHECK_USER);
		ps2.setInt(1, id);
		rs2 = ps2.executeQuery();
		
		// Loop through all post rows to check
		while (rs.next()) {
			checkPostComment = rs.getInt(1);
		}
		
		// Loop through all user rows to check
		while (rs2.next()) {
			checkUser = rs2.getInt(1);
		}
		
		// Only execute this code if Users and Posts or comment have a parent row
		if (checkPostComment > 0 && checkUser > 0) {
			PreparedStatement ps3 = null;
			
			// Like a post or comment
			if (type.equals("comment")) 
				ps3 = connection.prepareStatement(CREATE_COMMENT_LIKE_QUERY);
			else
				ps3 = connection.prepareStatement(CREATE_POST_LIKE_QUERY);
			
			// Set parameter and execute query
			ps3.setInt(1, userId);
			ps3.setInt(2, id);
			ps3.executeUpdate();
		}
		else 
			// Tell user something is up
			System.out.println("\nCannot insert into Likes because parent record does not exist in Users, Posts, or Comments");
	}
	
	// Method to unlike a comment or post
	public void unlike (int likeId, String type) throws SQLException {
		// Prepared statement for deletes comments and likes tables dependency
		PreparedStatement ps = null;
		if (type.equals("comment")) {
			ps = connection.prepareStatement(DELETE_COMMENT_LIKE_QUERY);
		}
		else
			ps = connection.prepareStatement(DELEATE_POST_LIKE_QUERY);
		
		// Set parameter and execute query
		ps.setInt(1, likeId);
		ps.executeUpdate();
	}
													
}
