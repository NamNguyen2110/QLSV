package com.training.qlsv.dao;

import com.training.qlsv.model.Course;
import com.training.qlsv.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {

    List<Course> courses = new ArrayList<>();
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
                courses.add(course);
                System.out.println(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("errors");
        }
        return courses;
    }
}

