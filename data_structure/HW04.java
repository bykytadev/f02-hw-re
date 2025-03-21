package ronin_engineer.data_structure;

import java.util.Scanner;
import java.util.Stack;

public class HW04 {
    Scanner scanner = new Scanner(System.in);

    // Nhập chuỗi từ người dùng
    public String inputString() {
        System.out.print("Nhập chuỗi cần đảo ngược: ");
        return scanner.nextLine();
    }

    // Đảo ngược chuỗi
    public String reverseString(String input) {
        // Tạo một stack để lưu các ký tự
        Stack<Character> stack = new Stack<>();

        // Đẩy từng ký tự của chuỗi vào stack
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        // Tạo StringBuilder để lưu kết quả
        StringBuilder result = new StringBuilder();

        // Lấy các ký tự ra từ stack theo thứ tự LIFO (Last In First Out)
        // để tạo thành chuỗi đảo ngược
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public void displayResult(String original, String reversed) {
        System.out.println("\nKết quả:");
        System.out.println("Chuỗi gốc: " + original);
        System.out.println("Chuỗi đảo ngược: " + reversed);
    }

    public void run() {
        System.out.println("CHƯƠNG TRÌNH ĐẢO NGƯỢC CHUỖI");
        System.out.println("============================");

        String originalString = inputString();

        if (!originalString.isEmpty()) {
            String reversedString = reverseString(originalString);
            displayResult(originalString, reversedString);
        } else {
            System.out.println("Chuỗi nhập vào trống!");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        HW04 stringReverser = new HW04();
        stringReverser.run();
    }
}
/*
 * Sử dụng Stack: Viết một chương trình đảo ngược một chuỗi nhập vào từ bàn
 * phím.
 */