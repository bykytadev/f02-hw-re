package ronin_engineer.exception;

import java.util.Scanner;

// Tạo lớp ngoại lệ tùy chỉnh NegativeNumberException
class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}

public class Bai06 {

    // Phương thức kiểm tra số nguyên
    public static void validateNumber(int number) throws NegativeNumberException {
        if (number < 0) {
            try {
                // Ném ra ngoại lệ NumberFormatException
                throw new NumberFormatException("Số âm không hợp lệ: " + number);
            } catch (NumberFormatException e) {
                // Chuyển đổi thành ngoại lệ tùy chỉnh NegativeNumberException
                throw new NegativeNumberException("Số không được âm: " + number);
            }
        }
        System.out.println("Số hợp lệ: " + number);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Nhập một số nguyên dương: ");
                int number = scanner.nextInt();

                // Kiểm tra số
                validateNumber(number);

                // Nếu không có ngoại lệ, đánh dấu nhập thành công
                validInput = true;
                System.out.println("Số bạn nhập là hợp lệ.");

            } catch (NegativeNumberException e) {
                System.out.println("Lỗi: " + e.getMessage());
                System.out.println("Vui lòng nhập lại một số nguyên dương.");

            } catch (Exception e) {
                System.out.println("Lỗi nhập liệu: " + e.getMessage());
                System.out.println("Vui lòng nhập lại một số nguyên hợp lệ.");
                scanner.nextLine(); // Xóa bộ đệm đầu vào
            }
        }

        scanner.close();
        System.out.println("Chương trình kết thúc.");
    }
}
/*
 * Viết một chương trình yêu cầu người dùng nhập vào một số nguyên. Nếu số nhập
 * vào là số âm, hãy ném ra ngoại lệ
 * NumberFormatException và chuyển đổi nó thành một ngoại lệ tùy chỉnh tên là
 * NegativeNumberException. Hãy bắt ngoại lệ
 * NegativeNumberException và thông báo yêu cầu người dùng nhập lại.
 */