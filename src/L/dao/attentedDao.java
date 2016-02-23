package L.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import L.db.Attented;

public class attentedDao extends dao{
	public boolean addAttented(Attented attented){
		String sql="INSERT INTO attented"+"(UserName,AttentName,Summary,Sign,PostNumber,AttentNumber,AttentedNumber)"
				+ "VALUES(?,?,?,?,?,?,?)";
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setString(1, attented.getUserName());
			pstmt.setString(2, attented.getAttentName());
			pstmt.setString(3, attented.getSummary());
			pstmt.setString(4, attented.getSign());
			pstmt.setInt(5, attented.getPostNumber());
			pstmt.setInt(6, attented.getAttentNumber());
			pstmt.setInt(7, attented.getAttentedNumber());
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException se){
			se.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteAttented(String uname,String aname){
		String sql="DELETE FROM attented WHERE UserName=? and AttentName=?";
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setString(1,uname);
			pstmt.setString(2,aname);
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Attented> findByUserName(String uname){
		ArrayList<Attented> attentedList=new ArrayList<Attented>();
		String sql="SELECT * FROM attented where UserName=?";
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);){
			pstmt.setString(1, uname);
			try(ResultSet rst=pstmt.executeQuery()){
				while(rst.next()){
					Attented attented=new Attented();
					attented.setUserName(uname);
					attented.setAttentName(rst.getString("AttentName"));
					attented.setSummary(rst.getString("Summary"));
					attented.setSign(rst.getString("Sign"));
					attented.setPostNumber(rst.getInt("PostNumber"));
					attented.setAttentNumber(rst.getInt("AttentNumber"));
					attented.setAttentedNumber(rst.getInt("AttentedNumber"));
					attentedList.add(attented);
				}
			}
			return attentedList;
		}
		catch(SQLException se){
			se.printStackTrace();
			return null;
		}
	}
}
