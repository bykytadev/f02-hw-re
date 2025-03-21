package ronin_engineer.exception.bai09;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    // Thêm sinh viên
    public void addStudent(Student student) throws DuplicateStudentIDException {
        // Kiểm tra ID đã tồn tại chưa
        for (Student s : students) {
            if (s.getId().equals(student.getId())) {
                throw new DuplicateStudentIDException("Sinh viên với ID " + student.getId() + " đã tồn tại!");
            }
        }

        students.add(student);
        System.out.println("Đã thêm sinh viên " + student.getName() + " thành công!");
    }

    // Xóa sinh viên theo ID
    public void removeStudentById(String id) throws EmptyStudentListException, StudentNotFoundException {
        // Kiểm tra danh sách rỗng
        if (students.isEmpty()) {
            throw new EmptyStudentListException("Danh sách sinh viên đang trống!");
        }

        boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                Student removedStudent = students.remove(i);
                System.out.println("Đã xóa sinh viên " + removedStudent.getName() + " thành công!");
                found = true;
                break;
            }
        }

        if (!found) {
            throw new StudentNotFoundException("Không tìm thấy sinh viên với ID " + id);
        }
    }

    // Hiển thị danh sách sinh viên
    public void displayStudents() throws EmptyStudentListException {
        // Kiểm tra danh sách rỗng
        if (students.isEmpty()) {
            throw new EmptyStudentListException("Danh sách sinh viên đang trống!");
        }

        System.out.println("\n--- DANH SÁCH SINH VIÊN ---");
        System.out.println("Tổng số: " + students.size() + " sinh viên");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }

        System.out.println("--------------------------------------------------");
    }

    // Tìm kiếm sinh viên theo ID
    public Student findStudentById(String id) throws EmptyStudentListException, StudentNotFoundException {
        // Kiểm tra danh sách rỗng
        if (students.isEmpty()) {
            throw new EmptyStudentListException("Danh sách sinh viên đang trống!");
        }

        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }

        throw new StudentNotFoundException("Không tìm thấy sinh viên với ID " + id);
    }

    // Kiểm tra danh sách có rỗng không
    public boolean isEmpty() {
        return students.isEmpty();
    }

    // Lấy số lượng sinh viên
    public int getSize() {
        return students.size();
    }
}