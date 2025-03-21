package ronin_engineer.exception.bai08;

import java.util.Scanner;

public class Bai08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tạo tài khoản ngân hàng
        BankAccount account = new BankAccount("123456789", "Hồ Minh Trung", 1000000);
        System.out.println("Đã tạo tài khoản: " + account);

        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- NGÂN HÀNG RONIN ---");
            System.out.println("1. Xem thông tin tài khoản");
            System.out.println("2. Nạp tiền");
            System.out.println("3. Rút tiền");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng (1-4): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Xóa bộ đệm đầu vào

                switch (choice) {
                    case 1:
                        System.out.println("Thông tin tài khoản: " + account);
                        break;

                    case 2:
                        System.out.print("Nhập số tiền cần nạp: ");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine(); // Xóa bộ đệm
                        account.deposit(depositAmount);
                        break;

                    case 3:
                        System.out.print("Nhập số tiền cần rút: ");
                        double withdrawAmount = scanner.nextDouble();
                        scanner.nextLine(); // Xóa bộ đệm

                        try {
                            // Thực hiện giao dịch rút tiền
                            account.fundout(withdrawAmount);

                        } catch (InsufficientFundsException e) {
                            System.out.println("Lỗi: " + e.getMessage());
                            System.out.println("Giao dịch thất bại!");

                            // Hoàn tác giao dịch nếu cần
                            account.rollbackTransaction();

                            // Hỏi người dùng có muốn rút hết số tiền có thể không
                            System.out.print("Bạn có muốn rút hết số tiền hiện có ("
                                    + account.getBalance() + ") không? (y/n): ");
                            String answer = scanner.nextLine();

                            if (answer.equalsIgnoreCase("y")) {
                                try {
                                    double availableAmount = account.getBalance();
                                    account.fundout(availableAmount);
                                } catch (InsufficientFundsException ex) {
                                    // Không xảy ra trường hợp này vì rút đúng số tiền hiện có
                                    System.out.println("Lỗi không xác định!");
                                }
                            }
                        }
                        break;

                    case 4:
                        exit = true;
                        System.out.println("Cảm ơn bạn đã sử dụng dịch vụ!");
                        break;

                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
                }

            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
                scanner.nextLine(); // Xóa bộ đệm đầu vào
            }
        }

        scanner.close();
    }
}

/*
 * Giả sử bạn đang viết một chương trình mô phỏng giao dịch ngân hàng. Viết
 * một lớp BankAccount với phương thức fundout(double
 * amount) để rút tiền từ tài khoản. Nếu số tiền rút lớn hơn số dư tài khoản,
 * ném ra ngoại lệ InsufficientFundsException. Sử dụng
 * try-catch để xử lý giao dịch thất bại và hoàn tác giao dịch nếu cần thiết.
 */