package jdbc.learning;

import java.sql.*;

public class FetchData {

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
            String query = "select * from students";
            ResultSet rs = st.executeQuery(query);

            System.out.println("Id--| Name-------------------| Age--| Marks---");
            System.out.println("----------------------------------------------");
            while (rs.next()) {
                int id = rs.getInt(  "id");
                String name = rs.getString(  "name");
                int age = rs.getInt(  "age");
                double marks = rs.getDouble(  "marks");

                System.out.printf("%-4s| %-23s| %-5s| %-8s%n",
                        id, name, age, marks);
            }

            rs.close();
            st.close();
            con.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
