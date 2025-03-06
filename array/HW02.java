package ronin_engineer.array;

import java.util.ArrayList;
import java.util.Scanner;

public class HW02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Nhập số nguyên n cần tìm: ");
        int target = scanner.nextInt();

        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == target) {
                indexes.add(i);
            }
        }

        if (indexes.isEmpty()) {
            System.out.println("Index của " + target + " là: -1");
        } else {
            System.out.print("Index của " + target + " là: ");
            for (int i = 0; i < indexes.size(); i++) {
                System.out.print(indexes.get(i));
                if (i < indexes.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}

/*
 * Nhập vào một mảng và số nguyên n. Trả về index của số nguyên n có trong mảng,
 * nếu không có trả về -1.
 */