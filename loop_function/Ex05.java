package ronin_engineer.loop_function;

public class Ex05 {
    public static void main(String[] args) {
        int n = 0;
        while (Math.pow(n + 1, 3) < 12000) {
            n++;
        }
        System.out.println("Số nguyên n lớn nhất thỏa mãn n^3 < 12,000 là: " + n);
    }
}

/*
 * 5. Sử dụng vòng lặp while để tìm số nguyên n lớn nhất thỏa mãn n^3 < 12.000.
 */

// Output: 22