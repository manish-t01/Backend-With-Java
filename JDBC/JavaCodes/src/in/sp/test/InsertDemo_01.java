package in.sp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertDemo_01 {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "802152");
	    
		PreparedStatement ps = con.prepareStatement(
				"INSERT INTO register VALUES ('manish', 'manish@gmail.com', '12345', 'male', 'dibrugarh')");
		
		int i = ps.executeUpdate();
		
		if(i > 0) {
			System.out.println("Success");
		}else {
			System.out.println("Fail");
		}
		
		ps.close();
		con.close();
	}
}
  