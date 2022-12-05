package com.training.qlsv.service;

import com.training.qlsv.dao.CourseDao;
import com.training.qlsv.model.Course;

import java.util.Scanner;

public class CourseService {
    Scanner scanner = new Scanner(System.in);

    private CourseDao courseDao = new CourseDao();

    public Course createCourse() {
        System.out.println("Mời bạn nhập tên course");
        String studentName = scanner.nextLine();

        Course student = new Course();
        student.setName(studentName);
        courseDao.create(student);
        return student;
    }
}
