package ronin_engineer.loop_function;

import java.util.Scanner;

public class Ex09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử trong dãy: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }

        System.out.println("Số lớn thứ hai trong dãy là: " + second);

        scanner.close();
    }
}

/*
 * 9. Viết một chương trình tìm số lớn thứ 2 trong dãy số nguyên không âm. input
 * là một dãy cần tìm, output là số lớn thứ 2 trong dãy.
 */