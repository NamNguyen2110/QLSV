package com.training.qlsv.dao;

import com.training.qlsv.model.Course;
import com.training.qlsv.model.Course;
import com.training.qlsv.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {

    private ConnectorDB connectorDB = new ConnectorDB();
    // get connection
    Connection connection = connectorDB.getConnection();

    public Course create(Course course) {
        try {
            // Create a statement object
            String sql = "INSERT INTO Course (name) VALUE (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, course.getName());

            preparedStatement.executeUpdate();
            System.out.println("create successfully");
            return course;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
            return null;
        }

    }

    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();

        try {

            // Create a statement object
            String sql = "SELECT * FROM course";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // execute query
            ResultSet resultSet = preparedStatement.executeQuery();

            // handling result set
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Course course = new Course();
                course.setId(id);
                course.setName(name);
                course.setStudents(findStudentByCourse(course.getId()));
                courses.add(course);
                System.out.println(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("errors");
        }
        return courses;
    }

    public Course findById(int id) {
        List<Student> students = new ArrayList<>();
        try {
            // Create a statement object
            String sql = "SELECT * FROM Course WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // set parameter
            preparedStatement.setInt(1, id);

            // execute query
            ResultSet resultSet = preparedStatement.executeQuery();

            // handling result set
            if (resultSet.next()) {
                Integer idResult = resultSet.getInt("id");
                String nameResult = resultSet.getString("name");
                students = findStudentByCourse(idResult);
                Course course = new Course();
                course.setId(idResult);
                course.setName(nameResult);
                course.setStudents(students);
                return course;
            } else {
                System.out.println("Course not found");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("errors");
            return null;
        }
    }

    private List<Student> findStudentByCourse(int id) {
        List<Student> students = new ArrayList<>();
        try {
            // Create a statement object
            String sql = "SELECT s.full_name as name, cs.id_course FROM student s LEFT JOIN coursestudent cs ON s.id = cs.id_student where id_course = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            // execute query
            ResultSet resultSet = preparedStatement.executeQuery();

            // handling result set
            while (resultSet.next()) {
                Student student = new Student();
                student.setName(resultSet.getString("name"));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("errors");
        }
        return students;
    }

    public void deleteByID(Integer id) {
        try {
            // Create a statement object
            String sql = "DELETE FROM Course WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // set parameter
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudentRecord(Integer courseId) {
        try {
            // Create a statement object
            String sql = "DELETE FROM CourseStudent WHERE id_course = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // set parameter
            preparedStatement.setInt(1, courseId);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Course course) {
        try {
            // Create a statement object
            String sql = "UPDATE Course SET name = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // set parameter
            preparedStatement.setString(1, course.getName());
            preparedStatement.setInt(2, course.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

