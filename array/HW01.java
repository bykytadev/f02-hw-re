package ronin_engineer.array;

import java.util.Scanner;

public class HW01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        System.out.println("Tổng các phần tử trong mảng: " + sum);

        scanner.close();
    }
}

/*
 * Nhập vào một mảng, và tính tổng các số có trong mảng đó.
 */