package ronin_engineer.oop;

public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public void displayResults() {
        System.out.println("Chu vi: " + calculateCircumference());
        System.out.println("Diện tích: " + calculateArea());
    }

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        circle.displayResults();
    }
}