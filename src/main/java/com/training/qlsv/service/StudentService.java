package com.training.qlsv.service;

import com.training.qlsv.dao.StudentDao;
import com.training.qlsv.model.Student;

import java.util.Scanner;

public class StudentService {
    static Scanner scanner = new Scanner(System.in);

    public static Student createStudent() {
        System.out.println("Mời bạn nhập tên sv");
        String studentName = scanner.nextLine();
        System.out.println("Mời bạn nhập địa chỉ");
        String studentAddress = scanner.nextLine();
        Student student = new Student();
        student.setName(studentName);
        student.setAddress(studentAddress);
        StudentDao.create(student);
        return student;
    }

    public static void findAll() {
        StudentDao.findAll();
    }

}
