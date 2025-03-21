package ronin_engineer.data_structure;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HW02 {
    private Map<String, Integer> wordFrequency;
    private Scanner scanner;

    public HW02() {
        wordFrequency = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    // Nhập đoạn văn từ người dùng
    public String inputText() {
        System.out.println("Nhập đoạn văn của bạn (nhấn Enter hai lần để kết thúc):");
        StringBuilder text = new StringBuilder();
        String line;

        // Cho phép người dùng nhập nhiều dòng và kết thúc bằng một dòng trống
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            text.append(line).append(" ");
        }

        return text.toString().trim();
    }

    // Đếm số lần xuất hiện của từng từ trong đoạn văn
    public void countWords(String text) {
        // Xóa dữ liệu cũ (nếu có)
        wordFrequency.clear();

        // Tách đoạn văn thành các từ riêng biệt
        // Sử dụng regex để tách các từ bởi dấu cách hoặc dấu câu
        String[] words = text.toLowerCase().split("[\\s,.!?;:\"'()\\[\\]{}]+");

        // Đếm tần suất xuất hiện của từng từ
        for (String word : words) {
            // Bỏ qua chuỗi rỗng có thể xuất hiện do tách chuỗi
            if (!word.isEmpty()) {
                // Nếu từ đã tồn tại trong map, tăng số đếm lên 1
                // Nếu chưa, thêm vào map với số đếm là 1
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }
    }

    // Hiển thị kết quả đếm từ
    public void displayResult() {
        if (wordFrequency.isEmpty()) {
            System.out.println("Không có từ nào để hiển thị.");
            return;
        }

        System.out.println("\n----- KẾT QUẢ ĐẾM TỪ -----");
        System.out.println("Từ\t\tSố lần xuất hiện");
        System.out.println("-----------------------------");

        // Sắp xếp kết quả theo thứ tự từ điển của từ
        wordFrequency.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    // Căn chỉnh định dạng hiển thị
                    String word = entry.getKey();
                    int count = entry.getValue();

                    // Hiển thị tab hoặc space tùy theo độ dài của từ
                    String spacing = word.length() < 8 ? "\t\t" : "\t";
                    System.out.println(word + spacing + count);
                });
    }

    // Chạy chương trình
    public void run() {
        System.out.println("CHƯƠNG TRÌNH ĐẾM TỪ TRONG ĐOẠN VĂN");
        System.out.println("====================================");

        String text = inputText();

        if (!text.isEmpty()) {
            countWords(text);
            displayResult();
        } else {
            System.out.println("Bạn chưa nhập đoạn văn nào.");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        HW02 wordCounter = new HW02();
        wordCounter.run();
    }
}

/*
 * Sử dụng Map (HashMap): Viết một chương trình nhập vào một đoạn văn và đếm số
 * lần xuất hiện các từ có
 * trong đoạn văn và in ra màn hình kết quả.
 */