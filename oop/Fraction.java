package ronin_engineer.oop;

public class Fraction {
    private int numerator;
    private int denominator;

    // a. Một constructor để khởi tạo một phân số với tử số và mẫu số cho trước.
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            System.out.println("Mẫu số phải khác 0");
            return;
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    // b. Một phương thức để rút gọn phân số, chia tử số và mẫu số cho ước chung lớn
    // nhất của chúng.
    private void simplify() {
        int gcd = findGCD(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    private int findGCD(int a, int b) {
        if (b == 0)
            return a;
        return findGCD(b, a % b);
    }

    // c. Một phương thức để trả về giá trị phân số dưới dạng chuỗi (ví dụ: "1/2"
    // hoặc "3/4").
    public String toString() {
        return numerator + "/" + denominator;
    }

    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction subtract(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            System.out.println("Không thể chia cho 0");
            return null;
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(3, 7);
        Fraction f2 = new Fraction(5, 9);
        System.out.println("Cộng: " + f1.add(f2));
        System.out.println("Trừ: " + f1.subtract(f2));
        System.out.println("Nhân: " + f1.multiply(f2));
        System.out.println("Chia: " + f1.divide(f2));
    }
}