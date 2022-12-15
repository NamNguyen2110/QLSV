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

    public Student createStudent() {
        System.out.println("Mời bạn nhập tên sv");
        String studentName = scanner.nextLine();
        System.out.println("Mời bạn nhập địa chỉ");
        String studentAddress = scanner.nextLine();
        Student student = new Student();
        student.setName(studentName);
        student.setAddress(studentAddress);
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

    public Student findById() {
        System.out.println("Mời bạn nhập id sv");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        Student student = studentDao.findById(id);
        System.out.println("Tên của sv là: " + student.getName());
        System.out.println("Địa chỉ của sv là: " + student.getAddress());
        System.out.println("Các môn học sv này đã tham gia là:");
        if (student.getCourseList().size() > 0) {
            for (int i = 0; i < student.getCourseList().size(); i++) {
                System.out.println(student.getCourseList().get(i).getName());
            }
        } else {
            System.out.println("sinh viên này chưa tham gia môn học nào");
        }
        return student;
    }

    public Student updateById() {
        System.out.println("Mời bạn nhập id sv");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        Student student = studentDao.findById(id);
        System.out.println("Mời bạn nhập tên sv");
        String studentName = scanner.nextLine();
        System.out.println("Mời bạn nhập địa chỉ");
        String studentAddress = scanner.nextLine();
        student.setName(studentName);
        student.setAddress(studentAddress);
        studentDao.update(student);
        System.out.println("update successfully");
        return student;
    }

    public void deleteById() {
        System.out.println("Mời bạn nhập id sv");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        studentDao.deleteByID(id);
        studentDao.deleteCourseRecord(id);
        System.out.println("delete successfully");
    }

    public List<Student> findAll() {
        return studentDao.findAll();
    }
}
