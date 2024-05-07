package example.stream;

import example.data.Student;
import example.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExample {

    static Predicate<Student> predicate = student -> student.getGpa() >= 4;

    public static void main(String[] args) {
        Map<String, List<String>> studentMap = StudentDataBase.getAllStudents().stream().collect(Collectors.toMap(Student::getName, Student::getActivities));
        System.out.println(studentMap);
        System.out.println("++++++++++");
        Map<String, List<String>> studentMapWithFilter = StudentDataBase.getAllStudents().stream()
                .filter(predicate)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        System.out.println(studentMapWithFilter);
    }
}
