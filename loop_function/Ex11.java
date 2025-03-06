package ronin_engineer.loop_function;

import java.util.Scanner;

public class Ex11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số n: ");
        int n = scanner.nextInt();

        for (int i = 1; i * i < n; i++) {
            System.out.print(i * i + " ");
        }

        scanner.close();
    }
}

/*
 * 11.Liệt kê tất cả số chính phương nhỏ hơn n ( n > 0). Input là một số n.
 * Output sẽ in ra danh sách số chính phương nhỏ hơn n. (Số chính phương là số
 * có thể biểu diễn dưới dạng bình phương của một số nguyên khác. Ví dụ 16 là số
 * chính phương vì 16 = 4^2).
 */

/*
 * Ý tưởng:
 * Duyệt từ 1 đến n, nếu i*i < n thì in ra i*i.
 * Còn nếu i*i >= n thì dừng vòng lặp.
 */