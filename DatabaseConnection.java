import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/EduMentorDatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "vishu0509"; // replace this

    public static Connection connect() {
        try {
            // Manually load the driver (this is the key fix!)
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Connected to MySQL successfully!");
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("❌ MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Connection failed!");
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        connect();
    }
}
