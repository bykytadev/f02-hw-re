package ronin_engineer.loop_function;

import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        int max = arr[0], count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                count = 1;
            } else if (arr[i] == max) {
                count++;
            }
        }

        System.out.println("Giá trị lớn nhất: " + max);
        System.out.println("Số lần giá trị lớn nhất xuất hiện: " + count);

        scanner.close();
    }
}

/*
 * 13. Viết một chương trình nhập vào n số nguyên, hiển thị số lần xuất hiện của
 * số lớn nhất.
 */