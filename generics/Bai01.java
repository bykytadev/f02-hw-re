package generics;

import java.util.ArrayList;
import java.util.HashSet;

public class Bai01 {
    // Phương thức generic để loại bỏ các phần tử trùng lặp
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        // Sử dụng HashSet để loại bỏ các phần tử trùng lặp
        HashSet<E> set = new HashSet<>(list);
        // Tạo một ArrayList mới từ HashSet
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        // Sử dụng phương thức removeDuplicates
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(3);
        numbers.add(4);

        System.out.println("Danh sách ban đầu: " + numbers);
        ArrayList<Integer> uniqueNumbers = removeDuplicates(numbers);
        System.out.println("Danh sách sau khi loại bỏ trùng lặp: " + uniqueNumbers);
    }
}