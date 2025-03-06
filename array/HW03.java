package ronin_engineer.array;

import java.util.Scanner;

public class HW03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số hàng của mảng: ");
        int rows = scanner.nextInt();
        System.out.print("Nhập số cột của mảng: ");
        int cols = scanner.nextInt();

        int[][] arr = new int[rows][cols];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int maxVal = arr[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] > maxVal) {
                    maxVal = arr[i][j];
                }
            }
        }

        System.out.println("Phần tử lớn nhất trong mảng: " + maxVal);

        scanner.close();
    }
}

/*
 * Nhập vào một mảng hai chiều, Trả về phần tử lớn nhất có trong mảng hai chiều.
 */
