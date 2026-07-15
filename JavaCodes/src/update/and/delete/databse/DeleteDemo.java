package update.and.delete.databse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteDemo {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Delete Data ");
		System.out.println("Enter Your Email ");
		String email2 = sc.nextLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "802152");
	    
		PreparedStatement ps = con.prepareStatement(
				"Delete from register where email = ?");
		
		ps.setString(1, email2);
		
		int i = ps.executeUpdate();
		
		if(i > 0) {
			System.out.println("Deletion Successful");
		}else {
			System.out.println("Deletion Failed");
		}
		
		ps.close();
		con.close();
	}
}
  