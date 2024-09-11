import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class MySQLConnect {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/JDNCTut";
        String username = "root";
        String password = "Harshu@13";
 
        Connection connection = null;
 
        try {
            // Load the MySQL JDBC driver (not required in most modern environments)
            Class.forName("com.mysql.cj.jdbc.Driver");
 
            // Establish the connection
            connection = DriverManager.getConnection(jdbcUrl, username, password);
 
            if (connection != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
 
        } catch (SQLException e) {
            System.out.println("MySQL connection failed: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}