package ronin_engineer.oop;

public class Student {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phoneNumber;
    private String studentID;

    public Student() {
    }

    public Student(String firstName, String lastName, String address, String email, String phoneNumber,
            String studentID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.studentID = studentID;
    }

    public void attendClass() {
        System.out.println(firstName + " " + lastName + " đang đi học.");
    }

    public void doHomework() {
        System.out.println(firstName + " " + lastName + " đang làm bài tập.");
    }

    public void payTuition() {
        System.out.println(firstName + " " + lastName + " đang nộp học phí.");
    }

    public void takeExam() {
        System.out.println(firstName + " " + lastName + " đang làm bài kiểm tra.");
    }

    public void displayInfo() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Address: " + address);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
    }

    public static void main(String[] args) {
        Student s1 = new Student("Hồ Minh", "Trung", "Sài Gòn", "bykyta.me@gmail.com", "0123456789", "SV001");
        s1.displayInfo();
        s1.attendClass();
        s1.doHomework();
        s1.payTuition();
        s1.takeExam();
    }
}