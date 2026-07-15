package update.delete.fetch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FetchDemo {
	public static void main(String[] args)throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "802152");
		
		PreparedStatement ps = con.prepareStatement("Select * from register");
		ResultSet rs = ps.executeQuery();
		
		System.out.println("Name----------| Email-------------|Password-----| Gender---| City----------|");
		System.out.println("");
		while (rs.next()) {
			String name1 = rs.getString("name");
			String email1 = rs.getString("email");
			String password1 = rs.getString("password");
			String gender1 = rs.getString("gender");
			String city1 = rs.getString("city");
			
			System.out.printf("%-15s %-20s %-12s %-10s %-15s%n",
			        name1, email1, password1, gender1, city1);
		}
		
		rs.close();
		ps.close();
		con.close();
	}
}
