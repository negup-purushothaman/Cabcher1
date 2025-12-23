package Genericlabaries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseutility {
	Connection con;

	public void getDbconnection(String url, String username, String password) throws Throwable {

		try {

			Driver driver = new Driver();

			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
		
			
		}
	}
	
	public void getDbconnection() throws Throwable {

		try {

			Driver driver = new Driver();

			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root" );
		} catch (Exception e) {
		}
	}
	
	
	
	

	public void closeDbconnection() throws Throwable {
		try {
		con.close();
		}catch(Exception e) {
			
		}
	}
	
	
	
	

	public ResultSet executeNonselectQuery(String query ,String index) throws Throwable {
		ResultSet result=null;
		try {
		Statement stat = con.createStatement();
		 result = stat.executeQuery(query);
		 while(result.next()) {
			 System.out.println(result.getString(index)+""+result.getString(index));
			 
		 }
		 
		 
		 
		}catch(Exception e)
	
		{}
		return result;
	}
	
	
	
	
	
 public int executeNonSelectquery(String query) {
	 int result=0;
		try {
		Statement stat = con.createStatement();
		 result = stat.executeUpdate(query);
		}catch(Exception e)
		{
			
		}
		return result;
	 
 }
	
	
	
	
}
