package ronin_engineer.loop_function;

public class Ex04 {
    public static void main(String[] args) {
        for (int i = 100; i <= 200; i++) {
            if ((i % 5 == 0 || i % 6 == 0) && !(i % 5 == 0 && i % 6 == 0)) {
                System.out.print(i + " ");
            }
        }
    }
}

/*
 * Kết quả:
 * 100 102 105 108 110 114 115 125 126 130 132 135 138 140 144 145 155 156 160 162 165 168 170 174 175 185 186 190 192 195 198 200
 */

/*
 * 4. Viết chương trình liệt kê các số trong khoảng [100; 200] chia hết cho 5
 * hoặc chia hết cho 6. Số chia hết cho cả 5 và 6 là không hợp lệ.
 */

/*
 * Công thức:
 * - Số chia hết cho 5: i % 5 == 0
 * - Số chia hết cho 6: i % 6 == 0
 * - Số chia hết cho cả 5 và 6: i % 5 == 0 && i % 6 == 0
 * - Số chia hết cho 5 hoặc 6: i % 5 == 0 || i % 6 == 0
 */