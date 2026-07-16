package jdbc.learning;

import java.sql.*;

public class DeleteData_02 {

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

            String query = "DELETE FROM students WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, 5);

            int i = ps.executeUpdate();

            if (i > 0) {
                System.out.println("Data Deleted Successfully");
            } else {
                System.out.println("Deletion Failed");
            }

            ps.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}