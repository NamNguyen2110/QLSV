package com.training.qlsv;

import com.training.qlsv.model.Student;
import com.training.qlsv.service.StudentService;

import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("Please submit student information");
//        System.out.println("Name: ");
//        String name = sc.nextLine();
//        System.out.println("Address: ");
//        String address = sc.nextLine();
//
//        Student student = new Student();
//        student.setId(1);
//        student.setName(name);
//        student.setAddress(address);
//
//        StudentService.createStudent(student);
        System.out.println("List student: ");
        System.out.println(StudentService.findAll());
    }
}
