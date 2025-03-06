package ronin_engineer.loop_function;

import java.util.Scanner;

public class Ex18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập phép toán a+b=c : ");
        String input = scanner.nextLine();

        String[] parts = input.split("[+=]");
        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[1]);
        int c = Integer.parseInt(parts[2]);

        if (a + b == c) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }
}

/*
 * 18. Cho một phép toán có dạng a+b=c với a,b,c chỉ là các số nguyên dương có
 * một chữ số. Hãy kiểm tra xem phép toán đó có đúng hay không. Ví dụ nhập vào
 * 1+2=3 ⇒ kết quả in ra YES, nhập vào 2+2=5 ⇒ kết quả in ra NO.
 */