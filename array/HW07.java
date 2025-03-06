package ronin_engineer.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HW07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, Integer> firstIndex = new HashMap<>();

        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            counts.put(arr[i], counts.getOrDefault(arr[i], 0) + 1);
            if (!firstIndex.containsKey(arr[i])) {
                firstIndex.put(arr[i], i);
            }
        }

        int result = -1;
        int minIndex = Integer.MAX_VALUE;
        int occurrence = 0;

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > 1) {
                int num = entry.getKey();
                int index = firstIndex.get(num);
                if (index < minIndex) {
                    minIndex = index;
                    result = num;
                    occurrence = entry.getValue();
                }
            }
        }

        if (result != -1) {
            System.out.println("Số " + result + " xuất hiện " + occurrence + " lần và có số thứ tự là " + minIndex);
        } else {
            System.out.println("NO");
        }
        scanner.close();
    }
}

/*
 * Cho dãy số A[] gồm có N phần tử. Nhiệm vụ của bạn là hãy tìm số xuất hiện
 * nhiều hơn 1 lần trong dãy số và số thứ tự là nhỏ nhất. Ví dụ: Input; 10 5 3 4
 * 3 5 6 ⇒ Output là 5 vì có 5 và 3 đều xuất hiện 2 lần, nhưng số 5 có số thứ tự
 * nhỏ hơn, input: 1 2 3 4 ⇒ NO.
 */