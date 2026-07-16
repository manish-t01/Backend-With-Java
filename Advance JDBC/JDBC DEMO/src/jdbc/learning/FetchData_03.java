package jdbc.learning;

import java.sql.*;

public class FetchData_03 {

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

            String query = "SELECT marks FROM students WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, 1);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                double marks = rs.getDouble("marks");
                System.out.println("Marks: " + marks);
            } else {
                System.out.println("Marks not found!!");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}