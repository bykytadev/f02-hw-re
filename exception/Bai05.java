package ronin_engineer.exception;

import java.util.Scanner;

// Lớp ngoại lệ tùy chỉnh
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Bai05 {

    // Phương thức kiểm tra tuổi
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 6) {
            throw new InvalidAgeException("Tuổi không hợp lệ! Tuổi phải từ 6 trở lên.");
        }
        System.out.println("Tuổi hợp lệ: " + age);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập tuổi của bạn: ");
            int age = scanner.nextInt();

            // Kiểm tra tuổi
            validateAge(age);

            System.out.println("Chương trình tiếp tục chạy sau khi kiểm tra tuổi thành công.");

        } catch (InvalidAgeException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Lỗi: Bạn nhập sai định dạng tuổi!");
        } finally {
            scanner.close();
            System.out.println("Chương trình kết thúc.");
        }
    }
}

/*
 * Tạo một lớp ngoại lệ tùy chỉnh (custom exception) tên là InvalidAgeException.
 * Viết một chương trình yêu cầu người dùng nhập
 * vào tuổi, nếu tuổi nhỏ hơn 6 thì ném ra ngoại lệ InvalidAgeException và thông
 * báo lỗi cho người dùng.
 */