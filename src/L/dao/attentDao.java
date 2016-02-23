package L.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import L.db.Attent;
import L.db.Post;

public class attentDao extends dao{
	public boolean addAttent(Attent attent){
		String sql="INSERT INTO attent"+"(UserName,AttentName,Summary,Sign,PostNumber,AttentNumber,AttentedNumber)"
				+ "VALUES(?,?,?,?,?,?,?)";
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setString(1, attent.getUserName());
			pstmt.setString(2, attent.getAttentName());
			pstmt.setString(3, attent.getSummary());
			pstmt.setString(4, attent.getSign());
			pstmt.setInt(5, attent.getPostNumber());
			pstmt.setInt(6, attent.getAttentNumber());
			pstmt.setInt(7, attent.getAttentedNumber());
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException se){
			se.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteAttent(String uname,String aname){
		String sql="DELETE FROM attent WHERE UserName=? and AttentName=?";
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
	
	public ArrayList<Attent> findByUserName(String uname){
		ArrayList<Attent> attentList=new ArrayList<Attent>();
		String sql="SELECT * FROM attent where UserName=?";
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);){
			pstmt.setString(1, uname);
			try(ResultSet rst=pstmt.executeQuery()){
				while(rst.next()){
					Attent attent=new Attent();
					attent.setUserName(uname);
					attent.setAttentName(rst.getString("AttentName"));
					attent.setSummary(rst.getString("Summary"));
					attent.setSign(rst.getString("Sign"));
					attent.setPostNumber(rst.getInt("PostNumber"));
					attent.setAttentNumber(rst.getInt("AttentNumber"));
					attent.setAttentedNumber(rst.getInt("AttentedNumber"));
					attentList.add(attent);
				}
			}
			return attentList;
		}
		catch(SQLException se){
			se.printStackTrace();
			return null;
		}
	}
	
	public boolean checkAttent(String u1,String u2){
		String sql="SELECT * FROM attent where UserName=? and AttentName=?";
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);){
			pstmt.setString(1, u1);
			pstmt.setString(2, u2);
			try(ResultSet rst=pstmt.executeQuery()){
				if(rst.next()){
					return true;
				}
				return false;
			}
		}
		catch(SQLException se){
			se.printStackTrace();
			return false;
		}
	}
}
