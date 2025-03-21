package ronin_engineer.exception.bai09;

// Ngoại lệ tùy chỉnh cho ID sinh viên không tồn tại
public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}