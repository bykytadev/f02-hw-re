package ronin_engineer.loop_function;

import java.util.Scanner;

public class Ex16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số nguyên dương: ");
        int num = scanner.nextInt();

        String str = Integer.toString(num);

        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }
}

/*
 * 16. Viết chương trình kiểm tra một số nguyên dương bất kỳ (2 chữ số trở lên,
 * không quá 9 chữ số) có chữ số bắt đầu và kết thúc bằng nhau hay không.
 */
