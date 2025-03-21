package ronin_engineer.exception.bai09;

public class Student {
    private String id;
    private String name;
    private int age;
    private String className;

    public Student(String id, String name, int age, String className) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.className = className;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return String.format("ID: %-10s | Tên: %-20s | Tuổi: %-5d | Lớp: %-10s",
                id, name, age, className);
    }
}
