package generics;

import java.util.Arrays;

public class Bai02 {
    // Phương thức generic để hoán đổi hai phần tử trong mảng
    public static <T> void swap(T[] array, int i, int j) {
        if (i >= 0 && i < array.length && j >= 0 && j < array.length) {
            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        } else {
            System.out.println("Chỉ số không hợp lệ!");
        }
    }

    public static void main(String[] args) {
        // Sử dụng phương thức swap
        Integer[] numbers = { 1, 2, 3, 4, 5 };
        System.out.println("Mảng ban đầu: " + Arrays.toString(numbers));
        swap(numbers, 1, 3);
        System.out.println("Mảng sau khi hoán đổi: " + Arrays.toString(numbers));

        String[] words = { "A", "B", "C", "D" };
        System.out.println("Mảng ban đầu: " + Arrays.toString(words));
        swap(words, 0, 2);
        System.out.println("Mảng sau khi hoán đổi: " + Arrays.toString(words));
    }
}