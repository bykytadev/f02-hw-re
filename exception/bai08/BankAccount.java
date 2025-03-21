package ronin_engineer.exception.bai08;

// Lớp BankAccount
class BankAccount {
    private String accountNumber;
    private String accountName;
    private double balance;
    private double previousBalance; // Lưu số dư trước khi giao dịch

    public BankAccount(String accountNumber, String accountName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = initialBalance;
        this.previousBalance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    // Phương thức nạp tiền
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Số tiền nạp phải lớn hơn 0!");
            return;
        }

        this.previousBalance = this.balance;
        this.balance += amount;
        System.out.println("Nạp tiền thành công: +" + amount);
        System.out.println("Số dư hiện tại: " + this.balance);
    }

    // Phương thức rút tiền
    public void fundout(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            System.out.println("Số tiền rút phải lớn hơn 0!");
            return;
        }

        this.previousBalance = this.balance;

        if (amount > this.balance) {
            double shortfall = amount - this.balance;
            throw new InsufficientFundsException(
                    "Số dư không đủ để thực hiện giao dịch! Thiếu: " + shortfall, shortfall);
        }

        this.balance -= amount;
        System.out.println("Rút tiền thành công: -" + amount);
        System.out.println("Số dư hiện tại: " + this.balance);
    }

    // Phương thức hoàn tác giao dịch
    public void rollbackTransaction() {
        this.balance = this.previousBalance;
        System.out.println("Đã hoàn tác giao dịch. Số dư hiện tại: " + this.balance);
    }

    @Override
    public String toString() {
        return "Tài khoản [" + accountNumber + "] - " + accountName + " - Số dư: " + balance;
    }
}