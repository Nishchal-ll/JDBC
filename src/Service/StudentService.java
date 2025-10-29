package Service;

import Model.Student;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    public void addStudent(Student student) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement pst = con.prepareStatement(
                    "INSERT INTO students (name, age, course) VALUES (?, ?, ?)");
            pst.setString(1, student.getName());
            pst.setInt(2, student.getAge());
            pst.setString(3, student.getCourse());
            pst.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM students");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("course")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateStudent(int id, String newCourse) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement pst = con.prepareStatement("UPDATE students SET course=? WHERE id=?");
            pst.setString(1, newCourse);
            pst.setInt(2, id);
            pst.executeUpdate();
            System.out.println(" Student updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement pst = con.prepareStatement("DELETE FROM students WHERE id=?");
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("🗑 Student deleted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
