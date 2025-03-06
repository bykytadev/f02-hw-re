package ronin_engineer.loop_function;

public class Ex12 {
    public static void main(String[] args) {
        for (int i = 2; i < 10000; i++) {
            int sum = 1;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    sum += j;
                    if (j != i / j) {
                        sum += i / j;
                    }
                }
            }
            if (sum == i) {
                System.out.print(i + " ");
            }
        }
    }
}

/*
 * 12. Một số nguyên dương được gọi là số hoàn hảo nếu nó bằng tổng của tất cả
 * các ước số dương của nó, không bao gồm chính nó. Ví dụ, 28 là số hoàn hảo vì
 * 28 = 14 + 7 + 4 + 2 + 1.
 * Viết một chương trình để tìm các số hoàn hảo < 10.000.
 */

// Output:
// 6 28 496 8128
