<<<<<<< HEAD
package EduMentor_dummy_project.src;
=======
package src;
>>>>>>> d17f422c8270bb43803cf0c6f513394cc29bc758

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/EduMentorDatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "vishu0509";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Connected to MySQL successfully!");
            return conn;
        } catch (SQLException e) {
            System.err.println("❌ Failed to connect to MySQL!");
            System.err.println("Reason: " + e.getMessage());
            return null; // return null if connection fails
        }
    }
}
