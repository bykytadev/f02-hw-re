package ronin_engineer.loop_function;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng học sinh: ");
        int n = Integer.parseInt(scanner.nextLine());

        if (n < 2) {
            System.out.println("Số lượng học sinh phải lớn hơn hoặc bằng 2.");
            scanner.close();
            return;
        }

        String[] names = new String[n];
        double[] scores = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập họ tên học sinh thứ " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
            System.out.print("Nhập điểm số của học sinh thứ " + (i + 1) + ": ");
            scores[i] = Double.parseDouble(scanner.nextLine());
        }

        int first = 0, second = 1;
        if (scores[0] < scores[1]) {
            first = 1;
            second = 0;
        }

        for (int i = 2; i < n; i++) {
            if (scores[i] > scores[first]) {
                second = first;
                first = i;
            } else if (scores[i] > scores[second]) {
                second = i;
            }
        }

        System.out.println("Sinh viên có điểm cao nhất: " + names[first]);
        System.out.println("Sinh viên có điểm cao thứ hai: " + names[second]);

        scanner.close();
    }
}

/*
 * 3. Viết một chương trình cho phép người dùng nhập vào số lượng học sinh trong
 * một lớp học (>= 2), họ tên, điểm số của từng sinh viên trong lớp. Hãy in ra
 * tên của sinh viên có điểm số cao nhất và sinh viên có điểm số cao thứ hai.
 */