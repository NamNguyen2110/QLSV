package com.training.qlsv.dao;

import com.training.qlsv.model.Course;
import com.training.qlsv.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private List<Student> students = new ArrayList<>();
    private ConnectorDB connectorDB = new ConnectorDB();
    // get connection
    Connection connection = connectorDB.getConnection();

    public List<Student> findAll() {

        try {
            // Create a statement object
            String sql = "SELECT id, full_name, address FROM student";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // execute query
            ResultSet resultSet = preparedStatement.executeQuery();

            // handling result set
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("full_name"));
                student.setAddress(resultSet.getString("address"));
                student.setCourseList( findCourseByStudent(student.getId()));
                students.add(student);
                System.out.println(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("errors");
        }
        return students;
    }

    private List<Course> findCourseByStudent(int id) {
        List<Course> courses = new ArrayList<>();
        try {
            // Create a statement object
            String sql = "SELECT c.name as name, cs.id_student FROM course c LEFT JOIN coursestudent cs ON c.id = cs.id_course where id_student = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            // execute query
            ResultSet resultSet = preparedStatement.executeQuery();

            // handling result set
            while (resultSet.next()) {
                Course course = new Course();
                course.setName(resultSet.getString("name"));
                courses.add(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("errors");
        }
        return courses;
    }

    public Student findById(int id) {
        List<Course> courses = new ArrayList<>();
        try {
            // Create a statement object
            String sql = "SELECT * FROM student WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // set parameter
            preparedStatement.setInt(1, id);

            // execute query
            ResultSet resultSet = preparedStatement.executeQuery();

            // handling result set
            if (resultSet.next()) {
                Integer idResult = resultSet.getInt("id");
                String fullNameResult = resultSet.getString("full_name");
                String addressResult = resultSet.getString("address");
                courses = findCourseByStudent(id);
                Student student = new Student();
                student.setId(idResult);
                student.setName(fullNameResult);
                student.setAddress(addressResult);
                student.setCourseList(courses);
                return student;
            } else {
                System.out.println("Student not found");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("errors");
            return null;
        }
    }

    public void deleteByID(Integer id) {
        try {
            // Create a statement object
            String sql = "DELETE FROM student WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // set parameter
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCourseRecord(Integer studentId) {
        try {
            // Create a statement object
            String sql = "DELETE FROM CourseStudent WHERE id_student = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // set parameter
            preparedStatement.setInt(1, studentId);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Student student) {
        try {
            // Create a statement object
            String sql = "UPDATE student SET Full_name = ?, Address = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // set parameter
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getAddress());
            preparedStatement.setInt(3, student.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Student create(Student student) {
        try {
            // Create a statement object
            String sql = "INSERT INTO student (full_name, address) VALUE (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getAddress());

            preparedStatement.executeUpdate();
            System.out.println("create successfully");
            return student;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
            return null;
        }
    }

    public void insertCourseIntoStudentDao(Integer studentId, Integer courseId) {
        try {
            // Create a statement object
            String sql = "INSERT INTO coursestudent (id_student, id_course) VALUE (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, courseId);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");

        }
    }
}

