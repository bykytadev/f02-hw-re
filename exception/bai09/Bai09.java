package ronin_engineer.exception.bai09;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bai09 {

    private static Scanner scanner = new Scanner(System.in);
    private static StudentManager studentManager = new StudentManager();

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            try {
                displayMenu();
                int choice = getUserChoice();

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        removeStudent();
                        break;
                    case 3:
                        displayStudents();
                        break;
                    case 4:
                        searchStudent();
                        break;
                    case 5:
                        exit = true;
                        System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Vui lòng nhập một số nguyên!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Lỗi không xác định: " + e.getMessage());
            }

            // Dừng màn hình
            if (!exit) {
                System.out.println("\nNhấn Enter để tiếp tục...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    // Hiển thị menu
    private static void displayMenu() {
        System.out.println("\n=== QUẢN LÝ SINH VIÊN RONIN ===");
        System.out.println("1. Thêm sinh viên");
        System.out.println("2. Xóa sinh viên");
        System.out.println("3. Hiển thị danh sách sinh viên");
        System.out.println("4. Tìm kiếm sinh viên theo ID");
        System.out.println("5. Thoát");
        System.out.print("Chọn chức năng (1-5): ");
    }

    // Lấy lựa chọn từ người dùng
    private static int getUserChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            return choice;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw e;
        }
    }

    // Thêm sinh viên
    private static void addStudent() {
        try {
            System.out.println("\n--- THÊM SINH VIÊN ---");

            System.out.print("Nhập ID sinh viên: ");
            String id = scanner.nextLine();

            System.out.print("Nhập tên sinh viên: ");
            String name = scanner.nextLine();

            System.out.print("Nhập tuổi sinh viên: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nhập lớp sinh viên: ");
            String className = scanner.nextLine();

            Student student = new Student(id, name, age, className);
            studentManager.addStudent(student);

        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Tuổi phải là số nguyên!");
            scanner.nextLine();
        } catch (DuplicateStudentIDException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    // Xóa sinh viên
    private static void removeStudent() {
        try {
            System.out.println("\n--- XÓA SINH VIÊN ---");

            System.out.print("Nhập ID sinh viên cần xóa: ");
            String id = scanner.nextLine();

            studentManager.removeStudentById(id);

        } catch (EmptyStudentListException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (StudentNotFoundException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    // Hiển thị danh sách sinh viên
    private static void displayStudents() {
        try {
            studentManager.displayStudents();
        } catch (EmptyStudentListException e) {
            System.out.println("Thông báo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    // Tìm kiếm sinh viên
    private static void searchStudent() {
        try {
            System.out.println("\n--- TÌM KIẾM SINH VIÊN ---");

            System.out.print("Nhập ID sinh viên cần tìm: ");
            String id = scanner.nextLine();

            Student student = studentManager.findStudentById(id);
            System.out.println("\nĐã tìm thấy sinh viên:");
            System.out.println(student);

        } catch (EmptyStudentListException e) {
            System.out.println("Thông báo: " + e.getMessage());
        } catch (StudentNotFoundException e) {
            System.out.println("Thông báo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
/*
 * Viết một chương trình quản lý danh sách sinh viên. Chương trình có các
 * chức năng: thêm sinh viên, xóa sinh viên, và hiển thị danh
 * sách sinh viên. Trong quá trình thao tác, hãy xử lý các ngoại lệ như
 * NullPointerException, IndexOutOfBoundsException, và các ngoại
 * lệ tùy chỉnh khác (nếu có) khi danh sách sinh viên rỗng hoặc chỉ số sinh viên
 * không hợp lệ.
 */