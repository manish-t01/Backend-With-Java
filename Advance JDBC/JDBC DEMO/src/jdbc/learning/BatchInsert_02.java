package jdbc.learning;

import java.sql.*;
import java.util.Scanner;

public class BatchInsert_02 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "802152";

    public static void main(String[] args) {

        String sql = "INSERT INTO students(name, age, marks) VALUES (?, ?, ?)";

        try (
                Scanner sc = new Scanner(System.in);
                Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con.setAutoCommit(false);

            while (true) {

                System.out.print("Enter Name : ");
                String name = sc.nextLine();

                System.out.print("Enter Age : ");
                int age = Integer.parseInt(sc.nextLine());

                System.out.print("Enter Marks : ");
                double marks = Double.parseDouble(sc.nextLine());

                ps.setString(1, name);
                ps.setInt(2, age);
                ps.setDouble(3, marks);

                ps.addBatch();

                System.out.print("Add another student? (yes/no): ");
                if (sc.nextLine().equalsIgnoreCase("no")) {
                    break;
                }
            }

            ps.executeBatch();
            con.commit();

            System.out.println("Batch inserted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}