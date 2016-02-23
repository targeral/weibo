package L.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import L.db.Post;
import L.db.Reply;

public class replyDao extends dao{
	public boolean addReply(Reply reply){
		String sql="INSERT INTO reply"+"(PostID,UserName,Instance,DateTime)"
				+ "VALUES(?,?,?,now())";
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setInt(1, reply.getPostID());
			pstmt.setString(2, reply.getUserName());
			pstmt.setString(3, reply.getInstance());
			//pstmt.setString(4, reply.getDateTime());
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException se){
			se.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Reply> findByPostID(int pID){
		ArrayList<Reply> replyList=new ArrayList<Reply>();
		String sql="SELECT UserName,Instance,DateTime FROM reply where PostID=? ORDER BY ReplyID DESC";
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);){
			pstmt.setInt(1, pID);
			try(ResultSet rst=pstmt.executeQuery()){
				while(rst.next()){
					Reply reply=new Reply();
					reply.setUserName(rst.getString("UserName"));
					reply.setInstance(rst.getString("Instance"));
					reply.setDateTime(rst.getString("DateTime"));
					replyList.add(reply);
				}
			}
			return replyList;
		}
		catch(SQLException se){
			se.printStackTrace();
			return null;
		}	
	}
}
