package ronin_engineer.loop_function;

public class Ex06 {
    public static void main(String[] args) {
        for (int i = 2; i <= 1000; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(i + " ");
            }
        }
    }
}

/*
 * 6. Viết một chương trình hiển thị tất cả các số nguyên tố trong khoảng từ [2, 1000].
 */
