package com.training.qlsv;

import com.training.qlsv.service.CourseService;
import com.training.qlsv.service.StudentService;
import com.training.qlsv.utils.MenuUtils;
import org.flywaydb.core.Flyway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class StudentManagement {
    // new code
    public static void main(String[] args) {

        System.out.println("Chào mừng bạn tới với phần mềm");

            MenuUtils.getMainMenu();

    }
}
