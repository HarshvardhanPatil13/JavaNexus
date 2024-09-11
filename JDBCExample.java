import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class JDBCExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/JDNCTut";
        String username = "root";
        String password = "Harshu@13";
 
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
 
            // Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");
 
            // Create a statement
            Statement statement = connection.createStatement();
 
            // Execute a query
           String query = "SELECT * FROM Students";
            ResultSet resultSet = statement.executeQuery(query);
 
            // Process the result set
            while (resultSet.next()) {
                int roll = resultSet.getInt("roll");
                String name = resultSet.getString("name");
                String branch=resultSet.getString("branch");
 
                // Print the result
                System.out.println("ID: " + roll + "| Name: " + name+ "     | Branch :"+branch);
            }
 
            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}