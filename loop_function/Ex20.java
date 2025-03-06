package ronin_engineer.loop_function;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số nguyên dương N: ");
        int N = scanner.nextInt();

        int count = 0;
        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (N % i == 0 && i % 2 == 0) {
                count++;
                divisors.add(i);
            }
        }

        System.out.println("Số ước số của N chia hết cho 2: " + count);
        System.out.print("Các ước số của N chia hết cho 2: ");
        for (int divisor : divisors) {
            System.out.print(divisor + " ");
        }
        System.out.println();

        scanner.close();
    }
}

/*
 * 20. Cho số nguyên dương N. Nhiệm vụ của bạn là hãy xác định xem có bao nhiêu
 * ước số của N chia hết cho 2.
 */

/*
 * output:
 * Nhập số nguyên dương N: 100
 * Số ước số của N chia hết cho 2: 6
 * Các ước số của N chia hết cho 2: 2 4 10 20 50 100
 */