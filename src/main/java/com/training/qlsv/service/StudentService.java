package com.training.qlsv.service;

import com.training.qlsv.dao.CourseDao;
import com.training.qlsv.dao.StudentDao;
import com.training.qlsv.model.Course;
import com.training.qlsv.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService {
    Scanner scanner = new Scanner(System.in);

    private StudentDao studentDao = new StudentDao();

    public Student create(Student student) {
//        student.setCourseList(insertCourseIntoStudent(student.getId()));
        studentDao.create(student);
//        insertCourseIntoStudent(student.getId());
        return student;
    }

//    private List<Course> insertCourseIntoStudent(Integer studentId) {
//        List<Course> courses = new ArrayList<>();
//        System.out.println("Danh sách các môn học");
//        CourseDao courseDao = new CourseDao();
//        courseDao.findAll();
//        System.out.println("Bạn muốn tham gia bao nhiêu môn?");
//        Integer chooseCourse = scanner.nextInt();
//        scanner.nextLine();
//        System.out.println("Nhập mã môn học bạn muốn tham gia:");
//        for (int i = 0; i < chooseCourse; i++) {
//            Integer courseId = scanner.nextInt();
//            Course course = courseDao.findById(courseId);
//            studentDao.insertCourseIntoStudentDao(studentId, courseId);
//            courses.add(course);
//        }
//        return courses;
//    }

    public Student findById(Integer id) {
        return studentDao.findById(id);
    }

    public void update(Student student) {
        studentDao.update(student);
    }

    public void delete(Student student) {
        studentDao.deleteById(student.getId());
        studentDao.deleteCourseRecord(student.getId());
    }

    public List<Student> findAll() {
        return studentDao.findAll();
    }
}
