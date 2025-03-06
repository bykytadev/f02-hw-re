package ronin_engineer.loop_function;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int positiveCount = 0, negativeCount = 0;
        double sum = 0;
        int count = 0;

        while (true) {
            System.out.print("Nhập số nguyên (0 để kết thúc): ");
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            if (num > 0) {
                positiveCount++;
            } else {
                negativeCount++;
            }
            sum += num;
            count++;
        }

        if (count > 0) {
            double average = sum / count;
            System.out.println("Số lượng giá trị dương: " + positiveCount);
            System.out.println("Số lượng giá trị âm: " + negativeCount);
            System.out.println("Tổng các giá trị: " + sum);
            System.out.println("Giá trị trung bình: " + average);
        } else {
            System.out.println("Không có giá trị nào được nhập.");
        }

        scanner.close();
    }
}

/*
 * 1. Viết một chương trình đọc một số lượng số nguyên không xác định, xác định
 * có bao nhiêu giá trị dương và âm đã được đọc và tính tổng và giá trị trung
 * bình của các giá trị đầu vào (không tính số 0).
 * Chương trình kết thúc khi nhập vào số 0.
 */