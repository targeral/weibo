package L.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import L.db.Post;
import L.db.User;

public class postDao extends dao{
	public boolean addPost(Post post){
		String sql="INSERT INTO post"+"(UserName,Instance,DateTime,ResendFlag)"
				+ "VALUES(?,?,now(),?)";
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setString(1, post.getUserName());
			pstmt.setString(2, post.getInstance());
			//pstmt.setString(3, post.getDateTime());
			pstmt.setInt(3, post.getResendFlag());
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException se){
			se.printStackTrace();
			return false;
		}
	}
	
	public boolean pointPost(int pid){
		String sql="UPDATE post SET Zan=Zan+1 WHERE PostID=?";
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setInt(1, pid);
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addResend(int pid){
		String sql="UPDATE post SET ResendNumber=ResendNumber+1 WHERE PostID=?";
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setInt(1, pid);
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addReply(int pid){
		String sql="UPDATE post SET ReplyNumber=ReplyNumber+1 WHERE PostID=?";
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setInt(1, pid);
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deletePost(int pid){
		String sql="DELETE FROM post WHERE PostID=?";
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setInt(1, pid);
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Post> findByOrder(){
		ArrayList<Post> postList=new ArrayList<Post>();
		String sql="SELECT UserName,Instance,DateTime,ReplyNumber,ResendNumber,Zan,postID FROM post order by postID DESC";
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);){
			try(ResultSet rst=pstmt.executeQuery()){
				while(rst.next()){
					Post post=new Post();
					post.setUserName(rst.getString("UserName"));
					post.setInstance(rst.getString("Instance"));
					post.setDateTime(rst.getString("DateTime"));
					post.setReplyNumber(rst.getInt("ReplyNumber"));
					post.setResendNumber(rst.getInt("ResendNumber"));
					post.setZan(rst.getInt("Zan"));
					post.setPostID(rst.getInt("postID"));
					postList.add(post);
				}
			}			
		}
		catch(SQLException se){
			se.printStackTrace();
			return null;
		}
		return postList;
	}
	
	public Post findByPid(int pid){
		String sql="SELECT * FROM post where PostID=?";
		Post post=new Post();
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);){
			pstmt.setInt(1, pid);
			try(ResultSet rst=pstmt.executeQuery()){
				if(rst.next()){
					post.setInstance(rst.getString("Instance"));
					post.setDateTime(rst.getString("DateTime"));
					post.setReplyNumber(rst.getInt("ReplyNumber"));
					post.setResendNumber(rst.getInt("ResendNumber"));
					post.setZan(rst.getInt("Zan"));
					post.setPostID(rst.getInt("PostID"));
					post.setUserName(rst.getString("UserName"));
				}
			}
			
		}
		catch(SQLException se){
			se.printStackTrace();
			return null;
		}
		return post;
	}
	
	public ArrayList<Post> findByUserName(String uname){
		ArrayList<Post> postList=new ArrayList<Post>();
		String sql="SELECT * FROM post where UserName=? AND ResendFlag=?";
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);){
			pstmt.setString(1, uname);
			pstmt.setString(2, "0");
			try(ResultSet rst=pstmt.executeQuery()){
				while(rst.next()){
					Post post=new Post();
					post.setInstance(rst.getString("Instance"));
					post.setUserName(rst.getString("UserName"));
					post.setDateTime(rst.getString("DateTime"));
					post.setReplyNumber(rst.getInt("ReplyNumber"));
					post.setResendNumber(rst.getInt("ResendNumber"));
					post.setZan(rst.getInt("Zan"));
					post.setPostID(rst.getInt("PostID"));
					postList.add(post);
				}
			}
			
		}
		catch(SQLException se){
			se.printStackTrace();
			return null;
		}
		return postList;
	}
}
