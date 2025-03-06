package ronin_engineer.loop_function;

import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số n: ");
        int n = scanner.nextInt();

        int a = 1, b = 1;
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        System.out.println("Số Fibonacci thứ " + n + " là: " + b);

        scanner.close();
    }
}

/*
 * 10. Tìm số Fibonacci thứ n. Input nhận vào là số n (n > 0), output là số
 * fibonacci của số n đó. Công thức truy hồi của dãy fibonacci có dạng:
 * f(n) = f(n-1) + f(n-2) . Với f(1) = 1; f(2) =1;
 */