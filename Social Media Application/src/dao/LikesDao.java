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
													
}
