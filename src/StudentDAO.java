package EduMentor_dummy_project.src;

import java.sql.*;

public class StudentDAO {
    // Insert student method with duplicate check
    public static void insertStudent(Student student) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            // Check if email already exists
            String checkEmailSQL = "SELECT COUNT(*) FROM student WHERE email = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkEmailSQL);
            checkStmt.setString(1, student.getEmail());
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
                System.out.println("Email " + student.getEmail() + " already exists. Cannot insert.");
                return; // Exit the method if the email is already in use
            }

            // Insert the student if email is unique
            String insertSQL = "INSERT INTO student (name, email, password, grade_level) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(insertSQL);
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getPassword());
            stmt.setString(4, student.getGradeLevel());
            stmt.executeUpdate();
            System.out.println("? Student inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all students method
    public static void getAllStudents() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String selectSQL = "SELECT * FROM student";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectSQL);
            while (rs.next()) {
                int id = rs.getInt("student_id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String gradeLevel = rs.getString("grade_level");
                Timestamp registrationDate = rs.getTimestamp("registration_date");
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email + ", Password: " + password
                        + ", Grade Level: " + gradeLevel + ", Registration Date: " + registrationDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
