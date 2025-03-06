package ronin_engineer.loop_function;

import java.util.Scanner;

public class Ex14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String str = scanner.nextLine();

        int[] count = new int[256];
        int max = -1;

        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
            if (count[str.charAt(i)] > max) {
                max = count[str.charAt(i)];
            }
        }

        System.out.print("Các ký tự xuất hiện nhiều nhất: ");
        for (int i = 0; i < 256; i++) {
            if (count[i] == max) {
                System.out.print((char) i + " ");
            }
        }
        System.out.println();

        scanner.close();
    }
}

/*
 * 14. Viết một chương trình nhập vào một string và hiển thị ra ký tự có số lần
 * xuất hiện nhiều nhất trong string đó.
 */