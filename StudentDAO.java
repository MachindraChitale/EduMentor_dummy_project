
import java.sql.*;

public class StudentDAO {
    public void getAllStudents() {
        try (Connection conn = DatabaseConnection.connect()) {
            String query = "SELECT * FROM students";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
