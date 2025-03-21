package ronin_engineer.exception.bai08;

// Tạo lớp ngoại lệ tùy chỉnh InsufficientFundsException
public class InsufficientFundsException extends Exception {
    private double amount;

    public InsufficientFundsException(String message, double amount) {
        super(message);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}