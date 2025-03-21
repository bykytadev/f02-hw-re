package ronin_engineer.data_structure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HW05 {
    private Scanner scanner = new Scanner(System.in);
    private Queue<Integer> numberQueue = new LinkedList<>();

    // Nhập dãy số từ người dùng
    public void inputNumbers() {
        System.out.println("Nhập dãy số (nhập 'end' để kết thúc):");

        while (true) {
            System.out.print("Nhập số: ");
            String input = scanner.nextLine().trim();

            // Kiểm tra điều kiện kết thúc
            if (input.equalsIgnoreCase("end")) {
                break;
            }

            try {
                int number = Integer.parseInt(input);
                numberQueue.add(number);
                System.out.println("Đã thêm " + number + " vào queue.");
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số nguyên hợp lệ hoặc 'end' để kết thúc.");
            }
        }
    }


    // Hiển thị dãy số theo thứ tự nhập vào
    public void displayQueue() {
        if (numberQueue.isEmpty()) {
            System.out.println("\nQueue rỗng. Không có số nào để hiển thị.");
            return;
        }

        System.out.println("\nDãy số theo thứ tự nhập vào:");

        // Tạo một bản sao của queue để không làm thay đổi queue gốc
        Queue<Integer> tempQueue = new LinkedList<>(numberQueue);

        int index = 0;
        while (!tempQueue.isEmpty()) {
            System.out.println(index + ": " + tempQueue.poll());
            index++;
        }
    }


    public void run() {
        System.out.println("CHƯƠNG TRÌNH QUẢN LÝ DÃY SỐ SỬ DỤNG QUEUE");
        System.out.println("==========================================");

        inputNumbers();
        displayQueue();

        scanner.close();
    }

    public static void main(String[] args) {
        HW05 queueManager = new HW05();
        queueManager.run();
    }
}

/*
 * Sử dụng Queue: Viết một chương trình nhập vào một dãy số, lưu dãy số đó vào
 * queue và in dãy số đó ra
 * màn hình theo thứ tự vừa nhập vào.
 */