package ronin_engineer.array;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HW08 {

    public static void main(String[] args) {
        File inputFile = new File("app\\src\\main\\java\\ronin_engineer\\array\\input08.txt");

        // Đọc số từ file và đếm tần số xuất hiện
        int[] result = countPrimeDigitNumbers(inputFile);

        // In kết quả
        for (int i = 0; i < result.length; i += 2) {
            if (result[i] != 0) { // Nếu số khác 0 (giá trị mặc định)
                System.out.println(result[i] + " " + result[i + 1]);
            }
        }
    }

    public static int[] countPrimeDigitNumbers(File inputFile) {
        // Tạo mảng để lưu các số và tần số xuất hiện của chúng
        // Mỗi cặp phần tử [i, i+1] lưu số và số lần xuất hiện
        // Kích thước 2000 cho phép lưu tối đa 1000 số khác nhau
        int[] result = new int[2000];
        int uniqueCount = 0; // Đếm số lượng số duy nhất đã thêm vào mảng kết quả

        try (Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();

                if (containsOnlyPrimeDigits(number)) {
                    // Tìm số trong mảng kết quả
                    int index = -1;
                    for (int i = 0; i < uniqueCount * 2; i += 2) {
                        if (result[i] == number) {
                            index = i;
                            break;
                        }
                    }

                    if (index == -1) { // Số chưa tồn tại trong mảng
                        result[uniqueCount * 2] = number; // Lưu số
                        result[uniqueCount * 2 + 1] = 1; // Đặt tần số = 1
                        uniqueCount++; // Tăng biến đếm
                    } else { // Số đã tồn tại, tăng tần số lên 1
                        result[index + 1]++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file: " + inputFile.getAbsolutePath());
        }

        return result;
    }

    public static boolean containsOnlyPrimeDigits(int num) {
        // Xử lý trường hợp số 0
        if (num == 0)
            return false;

        while (num > 0) {
            int digit = num % 10;
            if (digit != 2 && digit != 3 && digit != 5 && digit != 7) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}