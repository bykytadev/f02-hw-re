package ronin_engineer.loop_function;

public class Ex02 {
    public static void main(String[] args) {
        double tuition = 10000;
        double rate = 0.05;
        int years = 10;

        System.out.println("Học phí trong 10 năm tới:");

        for (int i = 1; i <= years; i++) {
            tuition *= (1 + rate); // P_n = P * (1 + r)^n
            System.out.printf("Năm %d: %.2f đô la\n", i, tuition);
        }

        double totalCost = 0;

        for (int i = 11; i <= 14; i++) {
            tuition *= (1 + rate);
            totalCost += tuition;
        }

        System.out.printf("Tổng chi phí học phí từ năm thứ 11 đến năm thứ 14: %.2f đô la\n", totalCost);
    }
}

/*
 * 2. Giả sử học phí của một trường đại học là 10.000 đô la trong năm nay và
 * tăng 5% mỗi năm. Trong một năm, học phí sẽ là 10.500 đô la. Viết một chương
 * trình hiển thị học phí trong 10 năm tới và tổng chi phí học phí của 4 năm bắt
 * đầu từ năm thứ 11.
 */

/*
 * Output:
 * Học phí trong 10 năm tới:
 * Năm 1: 10500.00 đô la
 * Năm 2: 11025.00 đô la
 * Năm 3: 11576.25 đô la
 * Năm 4: 12155.06 đô la
 * Năm 5: 12762.82 đô la
 * Năm 6: 13400.96 đô la
 * Năm 7: 14071.00 đô la
 * Năm 8: 14774.55 đô la
 * Năm 9: 15513.28 đô la
 * Năm 10: 16288.95 đô la
 * Tổng chi phí học phí từ năm thứ 11 đến năm thứ 14: 73717.76 đô la
 */

/*
 * === CÔNG THỨC CHUNG ===
 *
 * 1. Học phí sau n năm:
 * P_n = P * (1 + r)^n
 *
 * Trong đó:
 * - P là học phí ban đầu (10.000 USD)
 * - r là tỷ lệ tăng hàng năm (5% = 0.05)
 * - n là số năm tính toán
 *
 * 2. Tổng chi phí học phí từ năm m đến năm k:
 * T = P_m + P_(m+1) + ... + P_k
 * => T = P * (1 + r)^m + P * (1 + r)^(m+1) + ... + P * (1 + r)^k
 *
 * Tổng này có thể viết lại dưới dạng công thức cấp số nhân:
 * T = P_m * (1 - (1 + r)^(k-m+1)) / (1 - (1 + r))
 *
 * Với P_m = P * (1 + r)^m là học phí tại năm m.
 *
 */
