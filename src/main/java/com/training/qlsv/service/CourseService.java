package com.training.qlsv.service;

import com.training.qlsv.dao.CourseDao;
import com.training.qlsv.model.Course;
import com.training.qlsv.model.Student;

import java.util.List;
import java.util.Scanner;

public class CourseService {
    Scanner scanner = new Scanner(System.in);

    private CourseDao courseDao = new CourseDao();

    public Course createCourse() {
        System.out.println("Mời bạn nhập tên course");
        String courseName = scanner.nextLine();
        Course course = new Course();
        course.setName(courseName);
        courseDao.create(course);
        return course;
    }

    public Student findById() {
//        System.out.println("Mời bạn nhập teen course");
//        Integer id = scanner.nextInt();
//        scanner.nextLine();
//        Course course = CourseDao.findById(id);
//        System.out.println(course.toString());
//        return course;
        return null;
    }

    public Course updateById() {
//        System.out.println("Mời bạn nhập id sv");
//        Integer id = scanner.nextInt();
//        scanner.nextLine();
//        Course Course = CourseDao.findById(id);
//        System.out.println("Mời bạn nhập tên sv");
//        String CourseName = scanner.nextLine();
//        System.out.println("Mời bạn nhập địa chỉ");
//        String CourseAddress = scanner.nextLine();
//        Course.setName(CourseName);
//        Course.setAddress(CourseAddress);
//        CourseDao.update(Course);
//        System.out.println("update successfully");
//        return Course;
        return null;
    }

    public void deleteById() {
//        System.out.println("Mời bạn nhập id sv");
//        Integer id = scanner.nextInt();
//        scanner.nextLine();
//        CourseDao.deleteByID(id);
//        System.out.println("delete successfully");
    }
    public List<Course> findAll() {
        return courseDao.findAll();
    }
}
