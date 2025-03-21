package ronin_engineer.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bai04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[5]; // Mảng có 5 phần tử

        System.out.println("Mảng hiện tại có 5 phần tử (chỉ số từ 0-4)");

        boolean validInput = false;

        while (!validInput) {
            try {
                // Yêu cầu nhập chỉ số
                System.out.print("Nhập chỉ số mảng: ");
                int index = scanner.nextInt();

                // Yêu cầu nhập giá trị
                System.out.print("Nhập giá trị cần gán: ");
                int value = scanner.nextInt();

                // Gán giá trị vào mảng
                array[index] = value;

                // Hiển thị kết quả
                System.out.println("Đã gán giá trị " + value + " vào mảng tại vị trí " + index);

                // In ra mảng sau khi gán
                System.out.print("Mảng sau khi gán: ");
                for (int i = 0; i < array.length; i++) {
                    System.out.print(array[i] + " ");
                }
                System.out.println();

                validInput = true; // Đánh dấu đã nhập thành công

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Lỗi: Chỉ số mảng ngoài phạm vi (0-4)!");
                System.out.println("Vui lòng nhập lại.");
                scanner.nextLine(); // Xóa bộ đệm đầu vào

            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Nhập sai định dạng số nguyên!");
                System.out.println("Vui lòng nhập lại.");
                scanner.nextLine(); // Xóa bộ đệm đầu vào

            } catch (Exception e) {
                System.out.println("Lỗi không xác định: " + e.getMessage());
                System.out.println("Vui lòng nhập lại.");
                scanner.nextLine(); // Xóa bộ đệm đầu vào
            }
        }

        scanner.close();
        System.out.println("Chương trình kết thúc.");
    }
}
/*
 * Viết một chương trình yêu cầu người dùng nhập vào một chỉ số mảng và giá trị
 * cần gán cho phần tử đó. Sử dụng nhiều khối
 * catch để bắt các ngoại lệ như: ArrayIndexOutOfBoundsException (truy cập chỉ
 * số mảng ngoài phạm vi) và
 * InputMismatchException (nhập sai định dạng) rồi in ra thông báo yêu cầu người
 * dùng nhập lại.
 */