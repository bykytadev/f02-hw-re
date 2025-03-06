package ronin_engineer.loop_function;

import java.util.Scanner;

public class Ex17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số nguyên dương: ");
        int num = scanner.nextInt();

        for (int i = 2; i <= num; i++) {
            int count = 0;
            while (num % i == 0) {
                count++;
                num /= i;
            }
            if (count > 0) {
                System.out.print(i + "^" + count + " ");
            }
        }

        scanner.close();
    }
}

/*
 * 17. Hãy phân tích một số nguyên dương thành tích các thừa số nguyên tố.
 * Ví dụ
 * 60 = 2^2 x 3^1 x 5^1
 */