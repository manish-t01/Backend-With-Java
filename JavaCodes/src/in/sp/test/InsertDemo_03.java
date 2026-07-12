package in.sp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertDemo_03 {
	
	public static void main(String[] args) throws Exception {
		
		String name1 = "Amit";
		String mail1 = "amit@gmail.com";
		String password1 = "505060";
		String gender1 = "male";
		String city1 = "Bengluru";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "802152");
	    
		PreparedStatement ps = con.prepareStatement(
				"INSERT INTO register VALUES (?,?,?,?,?)");
		ps.setString(1, name1);
		ps.setString(2, mail1);
		ps.setString(3, password1);
		ps.setString(4, gender1);
		ps.setString(5, city1);
		
		int i = ps.executeUpdate();
		
		if(i > 0) {
			System.out.println("Success");
		}
		else {
			System.out.println("Fail");
		}
	}
}
  