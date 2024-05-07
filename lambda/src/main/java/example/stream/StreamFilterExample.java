package example.stream;

import example.data.Student;
import example.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterExample {

    static List<Student> getFemaleStudent() {
        return StudentDataBase.getAllStudents().stream()
                .filter( student -> student.getGender().equals("female"))
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        getFemaleStudent().forEach(System.out::println);
    }
}
