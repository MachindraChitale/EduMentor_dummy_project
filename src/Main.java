package EduMentor_dummy_project.src;

public class Main {
    public static void main(String[] args) {
        // Step 1: Establish a connection to the database
        try {
            DatabaseConnection.getConnection(); // Ensure the connection is established

            // Step 2: Create a new student
            Student s1 = new Student(0, "Vishwajeet", "darekarvishwajeet@gmail.com", "mypassword", "12th");

            // Step 3: Insert the student into the database
            StudentDAO.insertStudent(s1); // Now static, can be directly called
            System.out.println("? Student inserted successfully.");

            // Step 4: Fetch and display all students from the database
            StudentDAO.getAllStudents(); // Now static, can be directly called

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
