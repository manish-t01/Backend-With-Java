package in.sp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

//With User Input.
public class InsertDemo_04 {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your Name ");
		String name1 = sc.nextLine();
		
		System.out.println("Enter Your Mail Adress ");
		String mail1 = sc.nextLine();
		
		System.out.println("Enter Your Password ");
		String password1 = sc.nextLine();
		
		System.out.println("Enter Your Gender ");
		String gender1 = sc.nextLine();
		
		System.out.println("Enter Your City ");
		String city1 = sc.nextLine();
		
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
		}else {
			System.out.println("Fail");
		}
		
		ps.close();
		con.close();
	}
}
