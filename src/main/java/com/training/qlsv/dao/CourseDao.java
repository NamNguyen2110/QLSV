package com.training.qlsv.dao;

import com.training.qlsv.model.Course;
import com.training.qlsv.model.Course;
import com.training.qlsv.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {

    private ConnectorDB connectorDB = new ConnectorDB();
    // get connection
    Connection connection = connectorDB.getConnection();
    private static final String createCourse = "INSERT INTO Course (name) VALUE (?)";
    private static final String findAllCourse = "SELECT * FROM course";
    private static final String findById = "SELECT * FROM course WHERE id = ?";
    private static final String findByCourseId = "SELECT s.full_name FROM student s LEFT JOIN coursestudent cs ON s.id = cs.id_student where id_course = ?";
    private static final String deleteCourse = "DELETE FROM Course WHERE id = ?";
    private static final String deleteStudentRecord = "DELETE FROM CourseStudent WHERE id_course = ?";
    private static final String updateCourse = "UPDATE Course SET name = ? WHERE id = ?";

    public Course create(Course course) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createCourse);
            preparedStatement.setString(1, course.getName());

            preparedStatement.executeUpdate();
            System.out.println("create successfully");
            return course;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error SQL EXECUTE");
            return null;
        }

    }

    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();
        try {
            // Create a statement object
            PreparedStatement preparedStatement = connection.prepareStatement(findAllCourse);

            // execute query
            ResultSet resultSet = preparedStatement.executeQuery();

            // handling result set
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Course course = new Course();
                course.setId(id);
                course.setName(name);
                course.setStudents(findByCourseId(course.getId()));
                courses.add(course);
                System.out.println(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error SQL EXECUTE");
        }
        return courses;
    }

    public Course findById(Integer id) {
        List<Student> students = new ArrayList<>();
        try {
            // Create a statement object
            PreparedStatement preparedStatement = connection.prepareStatement(findById);

            // set parameter
            preparedStatement.setInt(1, id);

            // execute query
            ResultSet resultSet = preparedStatement.executeQuery();

            // handling result set
            if (resultSet.next()) {
                Integer idResult = resultSet.getInt("id");
                String nameResult = resultSet.getString("name");
                students = findByCourseId(idResult);
                Course course = new Course();
                course.setId(idResult);
                course.setName(nameResult);
                course.setStudents(students);
                return course;
            } else {
                System.out.println("Course not found");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("errors");
            return null;
        }
    }

    private List<Student> findByCourseId(Integer id) {
        List<Student> students = new ArrayList<>();
        try {
            // Create a statement object
            PreparedStatement preparedStatement = connection.prepareStatement(findByCourseId);
            preparedStatement.setInt(1, id);
            // execute query
            ResultSet resultSet = preparedStatement.executeQuery();

            // handling result set
            while (resultSet.next()) {
                Student student = new Student();
                student.setName(resultSet.getString("name"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("errors");
        }
        return students;
    }

    public void deleteById(Integer id) {
        try {
            // Create a statement object
            PreparedStatement preparedStatement = connection.prepareStatement(deleteCourse);

            // set parameter
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudentRecord(Integer courseId) {
        try {
            // Create a statement object
            PreparedStatement preparedStatement = connection.prepareStatement(deleteStudentRecord);

            // set parameter
            preparedStatement.setInt(1, courseId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Course course) {
        try {
            // Create a statement object
            PreparedStatement preparedStatement = connection.prepareStatement(updateCourse);

            // set parameter
            preparedStatement.setString(1, course.getName());
            preparedStatement.setInt(2, course.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

