package ronin_engineer.array;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HW04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập kích thước x: ");
        int x = scanner.nextInt();
        System.out.print("Nhập kích thước y: ");
        int y = scanner.nextInt();
        System.out.print("Nhập kích thước z: ");
        int z = scanner.nextInt();
        int[][][] arr = new int[x][y][z];

        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    arr[i][j][k] = scanner.nextInt();
                }
            }
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter("app\\src\\main\\java\\ronin_engineer\\array\\output04.txt"))) {
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    for (int k = 0; k < z; k++) {
                        writer.print(arr[i][j][k] + " ");
                    }
                    writer.println();
                }
                writer.println();
            }
            System.out.println("Đã ghi mảng vào file thành công");
        } catch (IOException e) {
            System.err.println("Lỗi ghi file: " + e.getMessage());
        }

        scanner.close();
    }
}

/*
 * Viết một hàm nhập vào một mảng 3 chiều và in ra ra các giá trị của mảng 3
 * chiều vào file text.
 */