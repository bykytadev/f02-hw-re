package ronin_engineer.array;

import java.util.Scanner;

public class HW06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng: ");
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];

        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        boolean isSymmetric = true;
        for (int i = 0; i < n / 2; i++) {
            if (arr[i] != arr[n - 1 - i]) {
                isSymmetric = false;
                break;
            }
        }

        if (isSymmetric) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        scanner.close();
    }
}

/*
 * Viết một chương trình kiểm tra một mảng một chiều có phải là một mảng đối
 * xứng không, nếu có in ra “YES", nếu không in ra “NO". Biết một mảng đối xứng
 * là một mảng đọc từ trái qua phải, đọc từ phải qua trái đều giống nhau. Ví dụ
 * một mảng đối xứng [1, 2, 3, 2, 1].
 */