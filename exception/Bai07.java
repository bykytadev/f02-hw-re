package ronin_engineer.exception;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Bai07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Chương trình ghi văn bản vào file sử dụng try-with-resources");
        System.out.print("Nhập tên file cần tạo: ");
        String fileName = scanner.nextLine();

        // Chỉ định trực tiếp đường dẫn
        String outputPath = "app/src/main/java/ronin_engineer/exception/" + fileName;

        System.out.println("Nhập nội dung văn bản (gõ EXIT để kết thúc):");
        StringBuilder content = new StringBuilder();
        String line;

        while (!(line = scanner.nextLine()).equalsIgnoreCase("EXIT")) {
            content.append(line).append("\n");
        }

        // Sử dụng try-with-resources để tự động đóng tài nguyên
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            writer.write(content.toString());
            System.out.println("Đã ghi thành công vào file: " + outputPath);

            // BufferedWriter sẽ tự động được đóng khi khối try kết thúc
            // ngay cả khi có ngoại lệ xảy ra

        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }

        scanner.close();
        System.out.println("Chương trình kết thúc.");
    }
}

/*
 * Sử dụng try-with-resources để minh họa tự động close, khi ghi một đoạn
 * text ra File.
 */