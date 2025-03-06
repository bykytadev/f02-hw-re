package ronin_engineer.loop_function;

import java.util.Scanner;

public class Ex19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số: ");
        String num = scanner.nextLine();

        boolean increasing = true, decreasing = true;
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) > num.charAt(i - 1)) {
                decreasing = false;
            } else if (num.charAt(i) < num.charAt(i - 1)) {
                increasing = false;
            }
        }

        if (increasing || decreasing) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }
}

/*
 * 19. Một số được gọi là số tăng giảm nếu số đó có các chữ số thỏa mãn hoặc
 * không giảm, hoặc không tăng từ trái qua phải. Hãy kiểm tra xem một số có phải
 * số tăng giảm hay không. Ví dụ nhập vào 2345566778899 ⇒ kết quả in ra YES,
 * nhập vào 4343531987 ⇒ kết quả in ra NO.
 */
