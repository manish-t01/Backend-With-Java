package jdbc.learning;

import java.sql.*;
import java.util.Scanner;

public class BatchInsert_01 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "802152";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = "INSERT INTO students(name, age, marks) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            while (true) {

                System.out.print("Enter Name : ");
                String name = sc.nextLine();

                System.out.print("Enter Age : ");
                int age = Integer.parseInt(sc.nextLine());

                System.out.print("Enter Marks : ");
                double marks = Double.parseDouble(sc.nextLine());

                // Set values
                ps.setString(1, name);
                ps.setInt(2, age);
                ps.setDouble(3, marks);

                // Add query to batch
                ps.addBatch();

                System.out.print("Do you want to add another student? (yes/no): ");
                String choice = sc.nextLine();

                if (choice.equalsIgnoreCase("no")) {
                    break;
                }
            }

            // Execute all INSERT statements together
            int[] result = ps.executeBatch();

            System.out.println(result.length + " records inserted successfully.");

            ps.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}