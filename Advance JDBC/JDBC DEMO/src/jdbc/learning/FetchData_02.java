package jdbc.learning;

import java.sql.*;

public class FetchData_02 {

    private static String url = "jdbc:mysql://localhost:3306/mydb";
    private static String user = "root";
    private static String password = "802152";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {

            Connection con = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM students";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            System.out.println("Id--| Name-------------------| Age--| Marks---");
            System.out.println("----------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                double marks = rs.getDouble("marks");

                System.out.printf("%-4d| %-23s| %-5d| %-8.2f%n",
                        id, name, age, marks);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}