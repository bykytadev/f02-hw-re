package ronin_engineer.loop_function;

import java.util.Scanner;

public class Ex15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số a: ");
        int a = scanner.nextInt();

        System.out.print("Nhập số b: ");
        int b = scanner.nextInt();

        int gcd = findGCD(a, b);
        int lcm = (a * b) / gcd;

        System.out.println("Ước số chung lớn nhất: " + gcd);
        System.out.println("Bội số chung nhỏ nhất: " + lcm);

        scanner.close();
    }

    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

/*
 * 15. Viết chương trình tìm ước số chung lớn nhất và bội số chung nhỏ nhất của
 * hai số nguyên dương a,b.
 */
