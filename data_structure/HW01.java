package ronin_engineer.data_structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW01 {
    private List<Integer> numbers;
    private Scanner scanner;

    public HW01() {
        numbers = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Thêm số vào danh sách
    public void addNumber() {
        System.out.print("Nhập số cần thêm: ");
        try {
            int number = scanner.nextInt();
            numbers.add(number);
            System.out.println("Đã thêm số " + number + " vào danh sách thành công.");
        } catch (Exception e) {
            System.out.println("Đầu vào không hợp lệ. Vui lòng nhập một số nguyên.");
            scanner.nextLine(); // Clear scanner buffer
        }
    }

    // Sửa số trong danh sách
    public void editNumber() {
        if (numbers.isEmpty()) {
            System.out.println("Danh sách trống. Không có gì để sửa.");
            return;
        }

        displayNumbers();
        System.out.print("Nhập vị trí của số cần sửa (0-" + (numbers.size() - 1) + "): ");
        try {
            int index = scanner.nextInt();
            if (index >= 0 && index < numbers.size()) {
                System.out.print("Nhập giá trị mới: ");
                int newNumber = scanner.nextInt();
                numbers.set(index, newNumber);
                System.out.println("Đã cập nhật số tại vị trí " + index + " thành " + newNumber);
            } else {
                System.out.println("Vị trí không hợp lệ. Vui lòng thử lại.");
            }
        } catch (Exception e) {
            System.out.println("Đầu vào không hợp lệ. Vui lòng nhập một số nguyên.");
            scanner.nextLine();
        }
    }

    // Xóa số khỏi danh sách
    public void removeNumber() {
        if (numbers.isEmpty()) {
            System.out.println("Danh sách trống. Không có gì để xóa.");
            return;
        }

        displayNumbers();
        System.out.print("Nhập vị trí của số cần xóa (0-" + (numbers.size() - 1) + "): ");
        try {
            int index = scanner.nextInt();
            if (index >= 0 && index < numbers.size()) {
                int removedNumber = numbers.remove(index);
                System.out.println("Đã xóa số " + removedNumber + " khỏi danh sách.");
            } else {
                System.out.println("Vị trí không hợp lệ. Vui lòng thử lại.");
            }
        } catch (Exception e) {
            System.out.println("Đầu vào không hợp lệ. Vui lòng nhập một số nguyên.");
            scanner.nextLine();
        }
    }

    // Hiển thị danh sách số
    public void displayNumbers() {
        if (numbers.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            System.out.println("Các số trong danh sách:");
            for (int i = 0; i < numbers.size(); i++) {
                System.out.println(i + ": " + numbers.get(i));
            }
        }
    }

    // Hiển thị menu chức năng
    public void showMenu() {
        int choice = 0;
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- QUẢN LÝ DANH SÁCH SỐ ---");
            System.out.println("1. Thêm số");
            System.out.println("2. Sửa số");
            System.out.println("3. Xóa số");
            System.out.println("4. Xem danh sách");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn của bạn (1-5): ");

            try {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addNumber();
                        break;
                    case 2:
                        editNumber();
                        break;
                    case 3:
                        removeNumber();
                        break;
                    case 4:
                        displayNumbers();
                        break;
                    case 5:
                        exit = true;
                        System.out.println("Đang thoát chương trình. Tạm biệt!");
                        scanner.close();
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số từ 1 đến 5.");
                }
            } catch (Exception e) {
                System.out.println("Đầu vào không hợp lệ. Vui lòng nhập một số nguyên.");
                scanner.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        HW01 numberManager = new HW01();
        numberManager.showMenu();
    }
}

/*
 * Sử dụng List (ArrayList): Viết một chương trình cho phép lưu trữ một tập hợp
 * các số và có thể thêm, sửa,
 * xóa, xem tập hợp các số đó.
 */