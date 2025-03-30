package generics;

import java.util.List;
import java.util.Arrays;

public class Bai03 {
    // Phương thức generic để đếm số lần xuất hiện của một phần tử trong danh sách
    public static <T> int countOccurrences(List<T> list, T element) {
        int count = 0;
        for (T item : list) {
            if (item.equals(element)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Sử dụng phương thức countOccurrences
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 2, 5);
        System.out.println("Số lần xuất hiện của 2: " + countOccurrences(numbers, 2) + " lần");

        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "apple");
        System.out.println("Số lần xuất hiện của 'apple': " + countOccurrences(words, "apple") + " lần");
    }
}