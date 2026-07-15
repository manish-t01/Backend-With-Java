package update.delete.fetch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateDemo {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Updating Your City ");
		System.out.println("Enter Your City Name ");
		String city2 = sc.nextLine();
		
		System.out.println("Enter Your Email ");
		String email2 = sc.nextLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "802152");
	    
		PreparedStatement ps = con.prepareStatement(
				"Update register set city = ? where email = ?");
		
		ps.setString(1, city2);
		ps.setString(2, email2);
		
		int i = ps.executeUpdate();
		
		if(i > 0) {
			System.out.println("Update Successful");
		}else {
			System.out.println("Update Failed");
		}
		
		ps.close();
		con.close();
	}
}
  