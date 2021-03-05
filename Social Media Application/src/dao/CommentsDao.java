package dao;
import entity.Comments;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentsDao {
	private Connection connection;
	
	// Query pulls all comments and posts for one single user id
	private final String GET_POSTS_COMMENTS_QUERY = "SELECT P.POST_TEXT, " + 
			"C.COMMENT_TEXT, " + 
			"USER_POSTS.USERNAME AS POST_USER, " + 
			"USER_COMMENTS.USERNAME AS COMMENT_USER " + 
			"FROM COMMENTS AS C " + 
			"INNER JOIN POSTS AS P" + 
			"	ON C.POST_ID = P.ID " + 
			"INNER JOIN USERS AS USER_POSTS " + 
			"	ON USER_POSTS.ID = P.POSTER_ID " + 
			"INNER JOIN USERS AS USER_COMMENTS " + 
			"	ON USER_COMMENTS.ID = C.COMMENTER_ID " + 
			"WHERE USER_POSTS.ID = ? OR USER_COMMENTS.ID = ? " + 
			"ORDER BY P.ID";
	
	// Get connection for Social Media database and create Comment data access object
	public CommentsDao() {
		connection = DBConnection.getConnection();
	}
	
	// Method queries database by comments, posts, and users
	public List<Comments> getCommentsPostsByUser(int userId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_POSTS_COMMENTS_QUERY);
		ps.setInt(1, userId);
		ps.setInt(2, userId);
		ResultSet rs = ps.executeQuery();
		
		// List to store query result
		List<Comments> commentsPostsByUser = new ArrayList<Comments>();
		
		// Loop through all rows and store in Comments list 
		while (rs.next()) {
			commentsPostsByUser.add(new Comments(rs.getString(4), rs.getString(2), rs.getString(1), rs.getString(3)));
		}
		
		// Return comments, posts, usernames list
		return commentsPostsByUser;
	}
}
