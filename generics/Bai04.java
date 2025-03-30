package generics;

import java.util.List;

public class Bai04 {
    // Phương thức tính tổng các số trong danh sách
    public static double sumNumbers(List<? extends Number> list) {
        double sum = 0.0;
        for (Number number : list) {
            sum += number.doubleValue(); // Chuyển đổi giá trị thành double để tính tổng
        }
        return sum;
    }

    public static void main(String[] args) {
        // Sử dụng phương thức sumNumbers
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        System.out.println("Tổng các số nguyên: " + sumNumbers(integers));

        List<Double> doubles = List.of(1.5, 2.5, 3.5);
        System.out.println("Tổng các số thực: " + sumNumbers(doubles));
    }
}