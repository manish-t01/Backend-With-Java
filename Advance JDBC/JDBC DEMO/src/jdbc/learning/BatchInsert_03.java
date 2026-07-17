package jdbc.learning;

import java.sql.SQLException;

public class BatchInsert_03 {
    public static void main(String[] args) throws SQLException {

//===========================================================
//        WHY SHOULD WE USE AUTO COMMIT = FALSE?
//===========================================================
//
//                By default, JDBC uses:
//
//        Auto Commit = true
//
//        This means every SQL statement is saved immediately after it
//        executes successfully.
//
//        For a single query, this is usually fine.
//
//                Example:
//
//        INSERT INTO students VALUES(...);
//
//        The record is inserted and saved instantly.
//
//
//-----------------------------------------------------------
//                Why is this a problem?
//-----------------------------------------------------------
//
//        Many real-world tasks require multiple SQL queries to
//        complete one operation.
//
//                Example:
//        A bank money transfer.
//
//        Step 1:
//        Deduct ₹1000 from Account A
//
//        Step 2:
//        Add ₹1000 to Account B
//
//        These two queries belong to ONE transaction.
//
//                If Auto Commit is ON:
//
//        Query 1 → Saved ✔
//        Query 2 → Error ❌
//
//        Result:
//
//        Account A loses ₹1000.
//        Account B receives nothing.
//
//        The database now contains incorrect and inconsistent data.
//
//
//-----------------------------------------------------------
//                Solution
//-----------------------------------------------------------
//
//                Disable Auto Commit.
//
//        con.setAutoCommit(false);
//
//        Now JDBC waits instead of saving each query immediately.
//
//                If every query succeeds:
//
//        con.commit();
//
//        All changes are saved together.
//
//                If any query fails:
//
//        con.rollback();
//
//        All changes are cancelled.
//
//        This keeps the database correct and consistent.
//
//
//===========================================================
//            WHAT HAPPENS IF WE DON'T USE IT?
//===========================================================
//
//                If we leave Auto Commit ON:
//
//✔ Every query is saved immediately.
//✔ We cannot group multiple queries into one transaction.
//✔ If one query fails, previous successful queries remain
//        saved.
//✔ This may leave incomplete or incorrect data.
//✔ Data consistency can be lost.
//
//
//                Example:
//
//        UPDATE Account A      ✔ Saved
//        UPDATE Account B      ❌ Failed
//
//        Final Result:
//
//        Account A is updated.
//        Account B is not updated.
//
//                This creates an inconsistent database.
//
//
//===========================================================
//        BENEFITS OF AUTO COMMIT = FALSE
//===========================================================
//
//✔ Groups multiple SQL statements into one transaction.
//✔ Prevents partial updates.
//✔ Keeps data accurate and consistent.
//✔ Gives complete control over when data is saved.
//✔ Allows rollback() if an error occurs.
//✔ Improves performance during batch processing because the
//        database commits once instead of after every query.
//
//
//===========================================================
//        WHEN SHOULD WE USE IT?
//===========================================================
//
//                Use Auto Commit = false when:
//
//• Money transfers
//• Batch inserts
//• Online shopping orders
//• Employee salary processing
//• Booking systems
//• Inventory management
//• Any operation involving multiple related SQL queries
//
//
//===========================================================
//                SIMPLE RULE TO REMEMBER
//===========================================================
//
//                Auto Commit = true
//
//        Every query is saved immediately.
//
//                Auto Commit = false
//
//        Wait...
//        Execute all queries...
//
//        If all succeed:
//        commit();
//
//        If any fail:
//        rollback();
//
//
//===========================================================
//        INTERVIEW ANSWER
//===========================================================
//
//        Q: Why do we use Auto Commit = false?
//
//        Answer:
//        We use Auto Commit = false to group multiple SQL statements
//        into a single transaction. This ensures that either all
//        queries are saved together using commit(), or all changes are
//        cancelled using rollback() if an error occurs. It prevents
//        partial updates and keeps the database consistent.

        System.out.println("It is just important note on AutoCommit ");
        System.out.println("which is used during batch processing, bank transactions etc in jdbc. ");
    }
}
