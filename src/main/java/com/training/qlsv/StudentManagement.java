package com.training.qlsv;

import com.training.qlsv.service.StudentService;

import java.util.Scanner;

public class StudentManagement {
    // new code
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Chào mừng bạn tới với phần mềm");
        while (true) {
            System.out.println("Có 2 option");
            System.out.println("1. Thêm thông tin sinh viên");
            System.out.println("2. Lấy ra danh sách sinh viên");
            System.out.println("3. Tìm thông tin sinh viên theo ID");
            System.out.println("4. Update thông tin sinh viên");
            System.out.println("5. Xóa thông tin sinh viên");
            System.out.println("6. Kết thúc chương trình");
            System.out.println("Mời chọn option");
            int choose = scanner.nextInt();
            switch (choose) {
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
                case 6:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình. Hẹn gặp lại!");
                    return;
            }
        }
    }
}
