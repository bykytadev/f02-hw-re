package ronin_engineer.data_structure.hw06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class HW06 {
    // Danh sách sinh viên
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        loadStudentsFromFile();

        while (true) {
            showMenu();
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = getValidInteger(scanner);

            switch (choice) {
                case 1 -> addStudent(scanner);
                case 2 -> editStudent(scanner);
                case 3 -> deleteStudent(scanner);
                case 4 -> displayStudents();
                case 5 -> sortStudents(scanner);
                case 6 -> searchStudent(scanner);
                case 7 -> {
                    saveStudentsToFile();
                    System.out.println("Đã lưu danh sách và thoát chương trình.");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }

    // Hiển thị menu
    private static void showMenu() {
        System.out.println("==================================");
        System.out.println("QUẢN LÝ SINH VIÊN - MENU");
        System.out.println("1. Thêm sinh viên");
        System.out.println("2. Sửa sinh viên");
        System.out.println("3. Xóa sinh viên");
        System.out.println("4. Hiển thị danh sách sinh viên");
        System.out.println("5. Sắp xếp danh sách sinh viên");
        System.out.println("6. Tìm kiếm sinh viên");
        System.out.println("7. Thoát chương trình");
        System.out.println("==================================");
    }

    // Thêm sinh viên
    private static void addStudent(Scanner scanner) {
        System.out.print("Nhập mã sinh viên: ");
        String id = scanner.nextLine();

        // Kiểm tra xem mã sinh viên đã tồn tại chưa
        if (findStudentById(id).isPresent()) {
            System.out.println("Mã sinh viên đã tồn tại. Vui lòng nhập mã khác.");
            return;
        }

        System.out.print("Nhập họ và tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập tuổi: ");
        int age = getValidInteger(scanner);
        System.out.print("Nhập điểm trung bình: ");
        double gpa = getValidDouble(scanner);

        students.add(new Student(id, name, age, gpa));
        System.out.println("Đã thêm sinh viên thành công.");
    }

    // Sửa thông tin sinh viên
    private static void editStudent(Scanner scanner) {
        System.out.print("Nhập mã sinh viên cần sửa: ");
        String id = scanner.nextLine();
        Optional<Student> studentOpt = findStudentById(id);

        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            System.out.print("Nhập họ và tên mới: ");
            student.name = scanner.nextLine();
            System.out.print("Nhập tuổi mới: ");
            student.age = getValidInteger(scanner);
            System.out.print("Nhập điểm trung bình mới: ");
            student.gpa = getValidDouble(scanner);
            System.out.println("Đã cập nhật thông tin sinh viên.");
        } else {
            System.out.println("Không tìm thấy sinh viên với mã đã nhập.");
        }
    }

    // Xóa sinh viên
    private static void deleteStudent(Scanner scanner) {
        System.out.print("Nhập mã sinh viên cần xóa: ");
        String id = scanner.nextLine();
        if (students.removeIf(student -> student.id.equals(id))) {
            System.out.println("Đã xóa sinh viên thành công.");
        } else {
            System.out.println("Không tìm thấy sinh viên với mã đã nhập.");
        }
    }

    // Hiển thị danh sách sinh viên
    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
        } else {
            System.out.println("Danh sách sinh viên:");
            students.forEach(System.out::println);
        }
    }

    // Sắp xếp danh sách sinh viên
    private static void sortStudents(Scanner scanner) {
        System.out.println("1. Theo họ và tên (A -> Z)");
        System.out.println("2. Theo điểm trung bình (Tăng dần)");
        System.out.println("3. Theo điểm trung bình (Giảm dần)");
        System.out.print("Nhập lựa chọn: ");
        int choice = getValidInteger(scanner);

        switch (choice) {
            case 1 -> {
                students.sort(Comparator.comparing(student -> student.name));
                System.out.println("Đã sắp xếp theo họ và tên.");
            }
            case 2 -> {
                students.sort(Comparator.comparingDouble(student -> student.gpa));
                System.out.println("Đã sắp xếp theo điểm trung bình (Tăng dần).");
            }
            case 3 -> {
                students.sort((s1, s2) -> Double.compare(s2.gpa, s1.gpa));
                System.out.println("Đã sắp xếp theo điểm trung bình (Giảm dần).");
            }
            default -> System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    // Tìm kiếm sinh viên
    private static void searchStudent(Scanner scanner) {
        System.out.print("Nhập mã sinh viên cần tìm: ");
        String id = scanner.nextLine();
        Optional<Student> studentOpt = findStudentById(id);

        if (studentOpt.isPresent()) {
            System.out.println("Thông tin sinh viên:");
            System.out.println(studentOpt.get());
        } else {
            System.out.println("Không tìm thấy sinh viên với mã đã nhập.");
        }
    }

    // Lưu danh sách sinh viên vào file
    private static void saveStudentsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu danh sách sinh viên: " + e.getMessage());
        }
    }

    // Đọc danh sách sinh viên từ file
    private static void loadStudentsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"))) {
            students = (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Không tìm thấy file lưu trữ hoặc lỗi khi đọc file.");
        }
    }

    // Tìm sinh viên theo mã
    private static Optional<Student> findStudentById(String id) {
        return students.stream().filter(student -> student.id.equals(id)).findFirst();
    }

    // Nhập số nguyên hợp lệ
    private static int getValidInteger(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Vui lòng nhập số nguyên hợp lệ: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    // Nhập số thực hợp lệ
    private static double getValidDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Vui lòng nhập số thực hợp lệ: ");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }
}