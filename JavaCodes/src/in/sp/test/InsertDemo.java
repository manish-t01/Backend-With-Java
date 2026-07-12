package in.sp.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class InsertDemo {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "802152");
	    System.out.print("Success.");
	}
}
  