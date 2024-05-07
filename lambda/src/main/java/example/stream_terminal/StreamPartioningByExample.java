package example.stream_terminal;

import example.data.Student;
import example.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.stream.Collectors.partitioningBy;

public class StreamPartioningByExample {
    static Predicate<Student> gpaPredicate = student -> student.getGpa() >=3.8;
    static void partioningBy_1(){
        Map<Boolean, List<Student>> partioningMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(partitioningBy(gpaPredicate));
        System.out.println(partioningMap);
    }
    public static void main(String[] args) {
       partioningBy_1();
    }
}
