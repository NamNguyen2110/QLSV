package com.training.qlsv.service;

import com.training.qlsv.dao.CourseDao;
import com.training.qlsv.model.Course;
import com.training.qlsv.model.Student;

import java.util.List;
import java.util.Scanner;

public class CourseService {
    Scanner scanner = new Scanner(System.in);

    private CourseDao courseDao = new CourseDao();

    public void create(Course course) {
        courseDao.create(course);
    }

    public Course findById(Integer id) {
        return courseDao.findById(id);
    }

    public void update(Course course) {
        courseDao.update(course);
    }

    public void deleteById(Course course) {
        courseDao.deleteById(course.getId());
        courseDao.deleteStudentRecord(course.getId());
    }
    public List<Course> findAll() {
        return courseDao.findAll();
    }
}
