package ronin_engineer.data_structure;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HW03 {
    private Scanner scanner;

    public HW03() {
        scanner = new Scanner(System.in);
    }

    // Nhập các số từ người dùng
    public int[] inputNumbers() {
        System.out.println("Nhập các số (cách nhau bởi dấu cách, nhấn Enter để kết thúc):");
        String input = scanner.nextLine();

        // Tách chuỗi nhập thành các số
        String[] numberStrings = input.trim().split("\\s+");
        int[] numbers = new int[numberStrings.length];

        // Chuyển đổi từ chuỗi sang số nguyên
        try {
            for (int i = 0; i < numberStrings.length; i++) {
                numbers[i] = Integer.parseInt(numberStrings[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Vui lòng chỉ nhập số nguyên.");
            return new int[0]; // Trả về mảng rỗng nếu có lỗi
        }

        return numbers;
    }


    // Đếm số lượng số khác nhau
    public Set<Integer> countDistinctNumbers(int[] numbers) {
        Set<Integer> distinctNumbers = new HashSet<>();

        // Thêm từng số vào HashSet
        // HashSet tự động loại bỏ các phần tử trùng lặp
        for (int number : numbers) {
            distinctNumbers.add(number);
        }

        return distinctNumbers;
    }

    // Hiển thị kết quả
    public void displayResult(int[] numbers, Set<Integer> distinctNumbers) {
        // Hiển thị tập hợp số ban đầu
        System.out.print("Tập hợp số ban đầu: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        // Hiển thị số lượng và các số khác nhau
        System.out.println("Có " + distinctNumbers.size() + " số khác nhau là: " + distinctNumbers);
    }


    // Chạy chương trình
    public void run() {
        System.out.println("CHƯƠNG TRÌNH ĐẾM SỐ KHÁC NHAU TRONG TẬP HỢP");
        System.out.println("============================================");

        int[] numbers = inputNumbers();

        if (numbers.length > 0) {
            Set<Integer> distinctNumbers = countDistinctNumbers(numbers);
            displayResult(numbers, distinctNumbers);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        HW03 counter = new HW03();
        counter.run();
    }
}

/*
 * Sử dụng Set (HashSet): Viết một chương trình đếm xem có bao nhiêu số khác
 * nhau trong một tập hợp số.
 * Ví dụ: 1, 2, 2, 3, 4, 5 4 ⇒ Có 5 số khác nhau là 1, 2, 3, 4, 5
 */