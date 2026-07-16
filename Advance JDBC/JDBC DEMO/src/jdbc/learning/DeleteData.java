package jdbc.learning;

import java.sql.*;

public class DeleteData {

    private static String url = "jdbc:mysql://localhost:3306/mydb";
    private static String user = "root";
    private static String password = "802152";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        try{

            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            String query = "DELETE FROM students WHERE id = 5";
            int i = st.executeUpdate(query);

            if (i > 0) {
                System.out.println("Data Deleted Successfully");
            } else {
                System.out.println("Deletion Failed");
            }

            st.close();
            con.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
