package com.training.qlsv.dao;

import com.training.qlsv.model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {

    List<Course> Courses = new ArrayList<>();
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
}

