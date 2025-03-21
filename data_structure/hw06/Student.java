package ronin_engineer.data_structure.hw06;

public class Student {
    String id;
    String name;
    int age;
    double gpa;

    public Student(String id, String name, int age, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Age: %d, GPA: %.2f", id, name, age, gpa);
    }

}
