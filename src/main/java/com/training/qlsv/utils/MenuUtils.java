package com.training.qlsv.utils;

import com.training.qlsv.enums.OptionMenu;
import com.training.qlsv.model.Course;
import com.training.qlsv.model.Student;
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
        switch (OptionMenu.of(chooseMainMenu)) {
            case OPTION_ONE:
                getStudentMenu();
            case OPTION_TWO:
                getCourseMenu();
            case OPTION_THREE:
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
        switch (OptionMenu.of(chooseStudentMenu)) {
            case OPTION_ONE:
                System.out.println("Mời bạn nhập tên sv");
                String studentName = scanner.nextLine();
                System.out.println("Mời bạn nhập địa chỉ");
                String studentAddress = scanner.nextLine();
                Student student = new Student();
                student.setName(studentName);
                student.setAddress(studentAddress);
                studentService.create(student);
                break;
            case OPTION_TWO:
                studentService.findAll();
                break;
            case OPTION_THREE:
                System.out.println("Mời bạn nhập id sv");
                Integer id = scanner.nextInt();
                scanner.nextLine();
                student = studentService.findById(id);
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
                break;
            case OPTION_FOUR:
                System.out.println("Mời bạn nhập id sv");
                id = scanner.nextInt();
                scanner.nextLine();
                student = studentService.findById(id);
                System.out.println("Mời bạn nhập tên sv");
                studentName = scanner.nextLine();
                System.out.println("Mời bạn nhập địa chỉ");
                studentAddress = scanner.nextLine();
                student.setName(studentName);
                student.setAddress(studentAddress);
                studentService.update(student);
                System.out.println("update successfully");
                break;
            case OPTION_FIVE:
                System.out.println("Mời bạn nhập id sv");
                id = scanner.nextInt();
                scanner.nextLine();
                student = studentService.findById(id);
                studentService.delete(student);
                System.out.println("delete successfully");
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
        switch (OptionMenu.of(chooseCourseMenu)) {
            case OPTION_ONE:
                System.out.println("Mời bạn nhập tên course");
                String courseName = scanner.nextLine();
                Course course = new Course();
                course.setName(courseName);
                courseService.create(course);
                System.out.println("create course successful!");
                break;
            case OPTION_TWO:
                courseService.findAll();
                break;
            case OPTION_THREE:
                System.out.println("Mời bạn nhập id course");
                Integer id = scanner.nextInt();
                scanner.nextLine();
                course = courseService.findById(id);
                System.out.println("Tên của môn học là: " + course.getName());
                System.out.println("Các sv đã tham gia môn học này là:");
                for (int i = 0; i < course.getStudents().size(); i++) {
                    System.out.println(course.getStudents().get(i).getName());
                }
                break;
            case OPTION_FOUR:
                System.out.println("Mời bạn nhập id course");
                id = scanner.nextInt();
                scanner.nextLine();
                course = courseService.findById(id);
                System.out.println("Mời bạn nhập tên course");
                courseName = scanner.nextLine();
                course.setName(courseName);
                courseService.update(course);
                System.out.println("update successfully");
                break;
            case OPTION_FIVE:
                System.out.println("Mời bạn nhập id course");
                id = scanner.nextInt();
                scanner.nextLine();
                course = courseService.findById(id);
                courseService.deleteById(course);
                System.out.println("delete successfully");
                break;
        }
        getMainMenu();
    }
}

