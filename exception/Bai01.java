package ronin_engineer.exception;

import java.util.Scanner;

public class Bai01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập số thứ nhất: ");
            int a = scanner.nextInt();
            System.out.print("Nhập số thứ hai: ");
            int b = scanner.nextInt();

            int result = a / b;
            System.out.println("Kết quả: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Lỗi: Không thể chia cho 0!");

        } catch (Exception e) {
            System.out.println("Lỗi: Vui lòng nhập số nguyên hợp lệ!");

        } finally {
            scanner.close();
        }

    }
}

/*
 * Viết một chương trình yêu cầu người dùng nhập vào hai số nguyên. Thực hiện
 * phép chia số thứ nhất cho số thứ hai. Nếu xảy
 * ra ngoại lệ chia cho 0, hãy xử lý và thông báo lỗi cho người dùng.
 */