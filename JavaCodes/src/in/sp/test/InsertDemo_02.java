package in.sp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertDemo_02 {

	public static void main(String[] args) throws Exception {

		// ==========================================================
		// NOTE 1: Data that we want to insert into the database.
		// These values can also come from the user (Scanner, GUI, etc.).
		// ==========================================================
		String name1 = "Anant";
		String mail1 = "anant@gmail.com";
		String password1 = "505050";
		String gender1 = "male";
		String city1 = "Patna";

		// ==========================================================
		// NOTE 2: Load the MySQL JDBC Driver.
		// This allows Java to communicate with the MySQL database.
		// ==========================================================
		Class.forName("com.mysql.cj.jdbc.Driver");

		// ==========================================================
		// NOTE 3: Create a connection with the database.
		//
		// URL Format:
		// jdbc:mysql://hostname:port/database_name
		//
		// Here:
		// localhost  -> MySQL is running on this computer
		// 3306       -> Default MySQL port number
		// jdbc_db    -> Database name
		// ==========================================================
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root","802152");

		// ==========================================================
		// NOTE 4: Create a PreparedStatement containing the SQL query.
		//
		// Here we are concatenating the values into the SQL query.
		// This works, but it is NOT the recommended method because it
		// can lead to SQL Injection attacks.
		//
		// Recommended:
		// INSERT INTO register VALUES (?, ?, ?, ?, ?)
		// ==========================================================
		PreparedStatement ps = con.prepareStatement(
				"INSERT INTO register VALUES ('"+ name1 + "', '"+ mail1 + "', '"+ password1 + "', '"+ gender1 + "', '"+ city1 + "')");

		// ==========================================================
		// NOTE 5: Execute the INSERT query.
		//
		// executeUpdate() returns the number of rows affected.
		// If one row is inserted successfully, it returns 1.
		// ==========================================================
		int i = ps.executeUpdate();

		// ==========================================================
		// NOTE 6: Check whether the data was inserted successfully.
		// ==========================================================
		if (i > 0) {
			System.out.println("Success");
		} else {
			System.out.println("Fail");
		}

		// ==========================================================
		// NOTE 7: Always close database resources.
		// Closing resources prevents memory leaks.
		// ==========================================================
		ps.close();
		con.close();
	}
}