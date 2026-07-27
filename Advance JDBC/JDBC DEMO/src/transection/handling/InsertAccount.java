package transection.handling;

import java.sql.*;
import java.util.Scanner;

public class InsertAccount {

    private static final String URL = "jdbc:mysql://localhost:3306/bank";
    private static final String USER = "root";
    private static final String PASSWORD = "802152";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found.");
            return;
        }

        String query = "INSERT INTO accounts(account_no, name, balance) VALUES (?, ?, ?)";

        try (
                Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = con.prepareStatement(query);
                Scanner sc = new Scanner(System.in)
        ) {

            System.out.print("Enter Account Number: ");
            int accountNo = sc.nextInt();
            sc.nextLine(); // Consume newline

            System.out.print("Enter Account Holder Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Initial Balance: ");
            double balance = sc.nextDouble();

            pstmt.setInt(1, accountNo);
            pstmt.setString(2, name);
            pstmt.setDouble(3, balance);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Account inserted successfully.");
            } else {
                System.out.println("Failed to insert account.");
            }

            con.close();
            sc.close();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}