package ronin_engineer.array;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW09 {
    private static File outputFile = new File("app\\src\\main\\java\\ronin_engineer\\array\\output09.txt");

    public static int[] readFromConsole() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nhập số phần tử: ");
            int n = Integer.parseInt(scanner.nextLine());
            int[] arr = new int[n];

            System.out.println("Nhập các phần tử:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            return arr;
        }
    }

    public static int[] readFromFile(String filename) throws IOException {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filename));

        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }
        scanner.close();

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    // Hiển thị các phần tử của mảng một chiều ra màn hình console
    public static void printToConsole(int[] arr) {
        System.out.print("Mảng: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Hiển thị các phần tử của mảng một chiều ra File
    public static void writeToFile(int[] arr, String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int num : arr) {
                writer.print(num + " ");
            }
        }
    }

    // Tính tổng các phần tử trong mảng một chiều
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    // Tìm số lớn nhất có trong mảng một chiều
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Tìm số nhỏ nhất có trong mảng một chiều
    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    // Tìm vị trí của phần tử nhỏ nhất trong mảng một chiều
    public static int findMinIndex(int[] arr) {
        int min = findMin(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min) {
                return i;
            }
        }
        return -1;
    }

    // Tìm vị trí của phần tử lớn nhất trong mảng một chiều
    public static int findMaxIndex(int[] arr) {
        int max = findMax(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                return i;
            }
        }
        return -1;
    }

    // Tìm vị trí của phần tử đầu tiên có giá trị bằng n
    public static int findFirstIndex(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                return i;
            }
        }
        return -1;
    }

    // Tìm vị trí của phần tử cuối cùng có giá trị bằng n
    public static int findLastIndex(int[] arr, int n) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == n) {
                return i;
            }
        }
        return -1;
    }

    // Hoán đổi giá trị của hai phần tử bất kỳ trong mảng
    public static void swap(int[] arr, int i, int j) {
        if (i >= 0 && i < arr.length && j >= 0 && j < arr.length) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = readFromConsole();
        printToConsole(arr);
        System.out.println("Tổng: " + sumArray(arr));
        System.out.println("Max: " + findMax(arr));
        System.out.println("Min: " + findMin(arr));
        System.out.println("Vị trí Min: " + findMinIndex(arr));
        System.out.println("Vị trí Max: " + findMaxIndex(arr));
        System.out.println("Vị trí phần tử đầu tiên có n = 5 : " + findFirstIndex(arr, 5));
        System.out.println("Vị trí phần tử cuối cùng có n = 5 : " + findLastIndex(arr, 5));

        try {
            writeToFile(arr, outputFile.getAbsolutePath());
            System.out.println("Ghi mảng ra file thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }
}
