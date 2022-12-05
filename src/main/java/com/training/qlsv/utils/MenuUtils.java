package com.training.qlsv.utils;

import com.training.qlsv.service.CourseService;
import com.training.qlsv.service.StudentService;

import java.util.Scanner;

public class MenuUtils {
    static Scanner scanner = new Scanner(System.in);

    public static void getMainMenu() {
        System.out.println("Có 2 option");
        System.out.println("1. Xem menu sinh viên");
        System.out.println("2. Xem menu các khóa học");
        System.out.println("3. Kết thúc chương trình");
        int chooseMainMenu = scanner.nextInt();
        if (chooseMainMenu == 1) {
            getStudentMenu();
        } else if (chooseMainMenu == 2) {
            getCourseMenu();
        } else if (chooseMainMenu == 3) {
            System.out.println("Cảm ơn bạn đã sử dụng chương trình. Hẹn gặp lại!");
            return;
        }
    }

    public static void getStudentMenu() {
        StudentService studentService = new StudentService();
        System.out.println("1. Thêm thông tin sinh viên");
        System.out.println("2. Lấy ra danh sách sinh viên");
        System.out.println("3. Tìm thông tin sinh viên theo ID");
        System.out.println("4. Update thông tin sinh viên");
        System.out.println("5. Xóa thông tin sinh viên");
        int chooseStudentMenu = scanner.nextInt();
        switch (chooseStudentMenu) {
            case 1:
                studentService.createStudent();
                break;
            case 2:
                studentService.findAll();
                break;
            case 3:
                studentService.findById();
                break;
            case 4:
                studentService.updateById();
                break;
            case 5:
                studentService.deleteById();
                break;
        }
        getMainMenu();
    }

    public static void getCourseMenu() {
        CourseService courseService = new CourseService();
        System.out.println("1. Thêm thông tin môn học");
        System.out.println("2. Lấy ra danh sách môn học");
        System.out.println("3. Tìm thông tin môn học theo ID");
        System.out.println("4. Update thông tin môn học");
        System.out.println("5. Xóa thông tin môn học");
        int chooseCourseMenu = scanner.nextInt();
        switch (chooseCourseMenu) {
            case 1:
                courseService.createCourse();
                break;
            case 2:
                courseService.findAll();
                break;
            case 3:
                courseService.findById();
                break;
            case 4:
                courseService.updateById();
                break;
            case 5:
                courseService.deleteById();
                break;
        }
        getMainMenu();
    }
}

