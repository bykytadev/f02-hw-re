package ronin_engineer.array;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HW05 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("app\\src\\main\\java\\ronin_engineer\\array\\input05.txt");
            Scanner scanner = new Scanner(inputFile);
            int sum = 0;

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int num = scanner.nextInt();
                    sum += num;
                } else {
                    scanner.next();
                }
            }
            scanner.close();

            // Ghi kết quả ra file
            try (PrintWriter writer = new PrintWriter(new FileWriter("app\\src\\main\\java\\ronin_engineer\\array\\output05.txt"))) {
                writer.println("Tổng các số nguyên trong file: " + sum);
                System.out.println("Đã ghi tổng vào file thành công");
            } catch (IOException e) {
                System.err.println("Lỗi ghi file: " + e.getMessage());
            }

        } catch (FileNotFoundException e) {
            System.err.println("File không tồn tại: " + e.getMessage());
        }
    }
}

/*
 * Viết chương trình đọc ra tất cả các số nguyên có trong một file và tính tổng
 * tất cả các số nguyên đó, kết quả ghi ra một file text khác.
 */