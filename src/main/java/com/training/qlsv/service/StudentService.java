package com.training.qlsv.service;

import com.training.qlsv.dao.StudentDao;
import com.training.qlsv.model.Student;

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
        studentDao.create(student);
        return student;
    }

    public Student findById() {
        System.out.println("Mời bạn nhập id sv");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        Student student = studentDao.findById(id);
        System.out.println(student.toString());
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
        System.out.println("delete successfully");
    }

    public List<Student> findAll() {
        return studentDao.findAll();
    }
}
