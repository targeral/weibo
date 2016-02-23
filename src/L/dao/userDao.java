package L.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import L.db.User;

public class userDao extends dao{
	public boolean addUser(User user){
		String sql="INSERT INTO user"+"(UserName,Password,RealName,"
				+ "Sex,Age,Email,PhoneNumber,Address,Summary,Sign)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
		boolean falg=false;
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getRealName());
			pstmt.setString(4, user.getSex());
			pstmt.setInt(5, user.getAge());
			pstmt.setString(6, user.getEmail());
			pstmt.setString(7, user.getPhoneNumber());
			pstmt.setString(8, user.getAddress());            
			pstmt.setString(9, user.getSummary());
			pstmt.setString(10, user.getSign());
			pstmt.executeUpdate();
		}
		catch(Exception se){
			se.printStackTrace();
			return false;
		}
		return true;
	}	
	
	public boolean updatePassword(User u){
		String uname=u.getUserName();
		String pas=u.getPassword();
		User user=new User();
		String sql="UPDATE user SET Password='"+pas+"' WHERE UserName=?";
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);){
			pstmt.setString(1,uname);
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException se){
			se.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<User> findAllUser(){
		
		ArrayList<User> userList=new ArrayList<User>();
		String sql="SELECT UserName,Password FROM user";
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);){
			try(ResultSet rst=pstmt.executeQuery()){
				while(rst.next()){
					User user=new User();
					user.setUserName(rst.getString("UserName"));
					user.setPassword(rst.getString("Password"));
					userList.add(user);
				}
			}
			return userList;
		}
		catch(SQLException se){
			se.printStackTrace();
			return null;
		}
	}
	
	public User findByName(String uname){
		String sql="SELECT * "
				+ "FROM user where UserName=?";
		User user=new User();
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setString(1, uname);
			try(ResultSet rst=pstmt.executeQuery()){
				if(rst.next()){
					user.setUserName(rst.getString("UserName"));
					user.setRealName(rst.getString("RealName"));
					user.setSex(rst.getString("Sex"));
					user.setAge(rst.getInt("Age"));
					user.setEmail(rst.getString("Email"));
					user.setPhoneNumber(rst.getString("PhoneNumber"));
					user.setSummary(rst.getString("Summary"));
					user.setSign(rst.getString("Sign"));
					user.setUserName(rst.getString("UserName"));
					user.setPostNumber(rst.getInt("PostNumber"));
					user.setAddress(rst.getString("Address"));
					user.setAttentNumber(rst.getInt("AttentNumber"));
					user.setAttentedNumber(rst.getInt("AttentedNumber"));
				}
			}
		}
		catch(SQLException se){
			return null;
		}
		return user;
	}
	
	public boolean addPost(String uname){
		String sql="UPDATE user SET PostNumber=PostNumber+1 WHERE UserName=?";
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setString(1, uname);
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deletePost(String uname){
		String sql="UPDATE user SET PostNumber=PostNumber-1 WHERE UserName=?";
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setString(1, uname);
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addAttent(String uname){
		String sql="UPDATE user SET AttentNumber=AttentNumber+1 WHERE UserName=?";
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setString(1, uname);
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteAttent(String uname){
		String sql="UPDATE user SET AttentNumber=AttentNumber-1 WHERE UserName=?";
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setString(1, uname);
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addAttented(String uname){
		String sql="UPDATE user SET AttentedNumber=AttentedNumber+1 WHERE UserName=?";
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setString(1, uname);
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteAttented(String uname){
		String sql="UPDATE user SET AttentedNumber=AttentedNumber-1 WHERE UserName=?";
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setString(1, uname);
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
}
