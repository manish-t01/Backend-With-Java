package transection.handling;

import java.sql.*;
import java.util.Scanner;

public class Transaction_01 {

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

        try (
                Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                Scanner sc = new Scanner(System.in)
        ) {

            con.setAutoCommit(false);

            System.out.print("Enter Sender Account Number: ");
            int sender = sc.nextInt();

            System.out.print("Enter Receiver Account Number: ");
            int receiver = sc.nextInt();

            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();

            // Check sender balance first
            if (!isSufficient(con, sender, amount)) {
                System.out.println("Insufficient Balance!");
                con.rollback();
                return;
            }

            String debitQuery =
                    "UPDATE accounts SET balance = balance - ? WHERE account_no = ?";

            String creditQuery =
                    "UPDATE accounts SET balance = balance + ? WHERE account_no = ?";

            try (
                    PreparedStatement debitStatement = con.prepareStatement(debitQuery);
                    PreparedStatement creditStatement = con.prepareStatement(creditQuery)
            ) {

                // Debit
                debitStatement.setDouble(1, amount);
                debitStatement.setInt(2, sender);

                // Credit
                creditStatement.setDouble(1, amount);
                creditStatement.setInt(2, receiver);

                int debitRows = debitStatement.executeUpdate();
                int creditRows = creditStatement.executeUpdate();

                if (debitRows == 1 && creditRows == 1) {
                    con.commit();
                    System.out.println("Transaction Successful.");
                } else {
                    con.rollback();
                    System.out.println("Transaction Failed.");
                }

            } catch (SQLException e) {
                con.rollback();
                System.out.println("Transaction Rolled Back.");
                e.printStackTrace();
            }

            con.close();
            sc.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static boolean isSufficient(Connection connection, int accountNo, double amount) {

        String query =
                "SELECT balance FROM accounts WHERE account_no = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, accountNo);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                double balance = resultSet.getDouble("balance");
                return balance >= amount;
            }

            connection.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}