package jdbc.learning;

import java.sql.*;
import java.util.Scanner;

public class InsertData {

    private static String url = "jdbc:mysql://localhost:3306/mydb";
    private static String user = "root";
    private static String password = "802152";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Name ");
        String name = sc.nextLine();

        System.out.println("Enter Age ");
        int age = sc.nextInt();

        System.out.println("Enter Marks ");
        double marks = sc.nextDouble();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {

            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement query = con.prepareStatement(
                    "INSERT INTO students(name, age, marks) VALUES (?, ?, ?)");

            query.setString(1, name);
            query.setInt(2, age);
            query.setDouble(3, marks);

            int i = query.executeUpdate();

            if (i > 0) {
                System.out.println("Data Inserted Successfully");
            } else {
                System.out.println("Failed to Insert Data");
            }

            query.close();
            con.close();
            sc.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}