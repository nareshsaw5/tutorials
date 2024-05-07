package example.stream;

import example.data.Student;
import example.data.StudentDataBase;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamMapExample {
    public static void main(String[] args) {
    List<String> studentList = StudentDataBase.getAllStudents().stream()
            .map((student) -> student.getName())
            .collect(Collectors.toList());
        System.out.println(studentList);
    List<String> studentList_1 = StudentDataBase.getAllStudents().stream()
            .map(Student::getName)
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        System.out.println(studentList_1);

    Set<String> studentSet = StudentDataBase.getAllStudents().stream()
            .map(Student::getName)
            .map(String::toUpperCase)
            .collect(Collectors.toSet());
    System.out.println(studentSet);
    }

}
