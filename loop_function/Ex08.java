package ronin_engineer.loop_function;

import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số tiền T: ");
        int T = scanner.nextInt();
        int[] denominations = { 500, 200, 100, 20, 10, 5, 2, 1 };
        int[] count = new int[denominations.length];
        int totalNotes = 0;

        for (int i = 0; i < denominations.length; i++) {
            count[i] = T / denominations[i];
            T %= denominations[i];
            totalNotes += count[i];
        }

        for (int i = 0; i < denominations.length; i++) {
            System.out.println("Số tờ " + denominations[i] + ": " + count[i]);
        }

        System.out.println("Tổng số tờ nhận được: " + totalNotes);

        scanner.close();
    }
}

/*
 * 8. Một người cần rút một số tiền T từ ngân hàng và muốn tổng số tờ ít nhất.
 * Cho biết có các loại tiền mệnh giá 500, 200, 100, 20, 10, 5, 2 và 1. Nhập từ
 * bàn phím số tiền T và in ra số tờ mỗi loại mệnh giá và tổng số tờ nhận được.
 */