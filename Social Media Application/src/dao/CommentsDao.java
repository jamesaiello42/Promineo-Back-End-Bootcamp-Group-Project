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
	private final String GET_POSTS_COMMENTS_QUERY = "SELECT P.POST_TEXT," + 
			"C.COMMENT_TEXT" + 
			"USER_POSTS.USERNAME AS POST_USER" + 
			",USER_COMMENTS.USERNAME AS COMMENT_USER" + 
			"FROM COMMENTS AS C" + 
			"INNER JOIN POSTS AS P" + 
			"	ON C.POST_ID = P.ID" + 
			"INNER JOIN USERS AS USER_POSTS" + 
			"	ON USER_POSTS.ID = P.POSTER_ID" + 
			"INNER JOIN USERS AS USER_COMMENTS" + 
			"	ON USER_COMMENTS.ID = C.COMMENTER_ID" + 
			"WHERE USER_POSTS.ID = ? OR USER_COMMENTS.ID = ?" + 
			"ORDER BY P.ID";
	
	// Get connection for cars database and create car data access object
	public CommentsDao() {
		connection = DBConnection.getConnection();
	}
	
	// Method queries database by car model
	public List<Comments> getCommentsPostsByUser(int userId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_POSTS_COMMENTS_QUERY);
		ps.setInt(1, userId);
		ps.setInt(2, userId);
		ResultSet rs = ps.executeQuery();
		
		// 
		List<Comments> commentsPostsByUser = new ArrayList<Comments>();
		
		// Loop through all rows and store in Car list 
		while (rs.next()) {
	//		commentsPostsByUser.add();
		}
		
		// Return car list
		return commentsPostsByUser;
	}
}
