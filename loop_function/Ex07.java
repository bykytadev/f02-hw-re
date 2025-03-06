package ronin_engineer.loop_function;

import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số n: ");

        int n = scanner.nextInt();
        long factorial = 1;

        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        System.out.println("Giai thừa của " + n + " là: " + factorial);

        scanner.close();
    }
}

/*
 * 7. Viết chương trình tính giai thừa của một số n (n > 0).
 */