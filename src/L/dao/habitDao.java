package L.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import L.db.Habit;

public class habitDao extends dao{
	public boolean addHabit(Habit habit){
		String sql="INSERT INTO habit"+"(UserName,Habit)"
				+ "VALUES(?,?)";
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setString(1, habit.getUserName());
			pstmt.setString(2, habit.getHabit());
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException se){
			se.printStackTrace();
			return false;
		}
	} 
	
	public boolean deleteAllHabitByUserName(String uname){
		String sql="DELETE FROM habit WHERE UserName=?";
		try(Connection conn=dataSource.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql);){
				pstmt.setString(1, uname);
				pstmt.executeUpdate();
				return true;
			}
			catch(SQLException se){
				se.printStackTrace();
				return false;
			}
	}
	
	public ArrayList<Habit> findByUserName(String uname){
		Habit habit=new Habit();
		ArrayList<Habit> habitList=new ArrayList<Habit>();
		String sql="SELECT Habit FROM habit where uname=?";
		try(Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);){
			pstmt.setString(1, uname);
			try(ResultSet rst=pstmt.executeQuery()){
				while(rst.next()){
					habit.setHabit(rst.getString("Habit"));
					habitList.add(habit);
				}
			}
			return habitList;
		}
		catch(SQLException se){
			se.printStackTrace();
			return null;
		}
	}
}
