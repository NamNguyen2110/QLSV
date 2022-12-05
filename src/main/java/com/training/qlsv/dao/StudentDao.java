package com.training.qlsv.dao;

import com.google.gson.Gson;
import com.training.qlsv.model.Student;
import com.training.qlsv.utils.FileUtils;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    List<Student> students = new ArrayList<>();
    private ConnectorDB connectorDB = new ConnectorDB();
    // get connection
    Connection connection = connectorDB.getConnection();

    public List<Student> findAll() {
        try {
            // Create a statement object
            String sql = "SELECT * FROM student";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // execute query
            ResultSet resultSet = preparedStatement.executeQuery();

            // handling result set
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String fullName = resultSet.getString("full_name");
                String address = resultSet.getString("address");

                Student student = new Student(id, fullName, address);
                students.add(student);
                System.out.println(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("errors");
        }
        return students;
    }

    public Student findById(int id) {
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
                Student student = new Student(idResult, fullNameResult, addressResult);
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
}

