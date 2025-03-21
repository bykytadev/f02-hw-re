package ronin_engineer.exception;

import java.util.Scanner;

public class Bai03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập số nguyên thứ nhất: ");
            int num1 = scanner.nextInt();

            System.out.print("Nhập số nguyên thứ hai: ");
            int num2 = scanner.nextInt();

            int sum = num1 + num2;
            System.out.println("Tổng của hai số là: " + sum);

        } catch (Exception e) {
            System.out.println("Lỗi: Bạn nhập sai định dạng số nguyên!");
        } finally {
            System.out.println("Chương trình kết thúc.");
            scanner.close();
        }
    }
}

/*
 * Viết một chương trình thực hiện nhập vào và cộng hai số nguyên. Sử dụng khối
 * try-catch-finally để bắt ngoại lệ khi nhập sai
 * định dạng số, và in ra thông báo kết thúc chương trình trong khối finally.
 */