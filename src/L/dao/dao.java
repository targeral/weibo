package L.dao;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class dao {
	DataSource dataSource;
	public dao(){
		try{
			Context context=new InitialContext();
			dataSource=(DataSource)context.lookup("java:comp/env/jdbc/mysql");
		}
		catch(NamingException ne){
			System.out.println("Exception:"+ne);
		}
	}
	public Connection getConnection()throws Exception{
		return dataSource.getConnection();
	}
}
