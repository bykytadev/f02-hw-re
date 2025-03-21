package ronin_engineer.exception.bai09;

// Ngoại lệ tùy chỉnh cho ID sinh viên đã tồn tại
public class DuplicateStudentIDException extends Exception {
    public DuplicateStudentIDException(String message) {
        super(message);
    }
}