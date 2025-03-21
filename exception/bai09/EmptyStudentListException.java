package ronin_engineer.exception.bai09;

// Ngoại lệ tùy chỉnh cho danh sách sinh viên rỗng
public class EmptyStudentListException extends Exception {
    public EmptyStudentListException(String message) {
        super(message);
    }
}
