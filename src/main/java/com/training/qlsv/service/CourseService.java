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

    public Course findById() {
        System.out.println("Mời bạn nhập id course");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        Course course = courseDao.findById(id);
        System.out.println("Tên của môn học là: " + course.getName());
        System.out.println("Các sv đã tham gia môn học này là:");
        for (int i = 0; i < course.getStudents().size(); i++) {
            System.out.println(course.getStudents().get(i).getName());
        }
        return course;
    }

    public Course updateById() {
        System.out.println("Mời bạn nhập id course");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        Course course = courseDao.findById(id);
        System.out.println("Mời bạn nhập tên course");
        String CourseName = scanner.nextLine();
        course.setName(CourseName);
        courseDao.update(course);
        System.out.println("update successfully");
        return course;
    }

    public void deleteById() {
        System.out.println("Mời bạn nhập id course");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        courseDao.deleteByID(id);
        courseDao.deleteStudentRecord(id);
        System.out.println("delete successfully");
    }
    public List<Course> findAll() {
        return courseDao.findAll();
    }
}
