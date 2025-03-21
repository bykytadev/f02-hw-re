package ronin_engineer.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bai02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number;

        while (true) {
            try {
                System.out.print("Nhập một số nguyên: ");
                number = scanner.nextInt();
                System.out.println("Số nguyên bạn vừa nhập: " + number);
                break; // Thoát khỏi vòng lặp nếu nhập đúng
            } catch (InputMismatchException e) {
                System.err.println("Lỗi: Bạn đã nhập không phải là số nguyên. Vui lòng nhập lại.");
                scanner.next(); // Đọc bỏ input không hợp lệ để tránh lặp vô hạn
            }
        }
        scanner.close();

    }
}

/*
 * Viết chương trình yêu cầu người dùng nhập một số nguyên. Nếu người dùng nhập
 * không phải số nguyên, hãy xử lý ngoại lệ
 * InputMismatchException và thông báo lỗi cho người dùng, yêu cầu họ nhập lại.
 */