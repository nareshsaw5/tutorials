package example.stream_terminal;

import example.data.Student;
import example.data.StudentDataBase;

import static java.util.stream.Collectors.*;

public class StreamsSumAvgExample {

    static double sum() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(summingDouble(Student::getGpa));
    }

    static double average() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(averagingDouble(Student::getGpa));
    }
    public static void main(String[] args) {
        System.out.println(sum());
        System.out.println("=========");
        System.out.println(average());
    }
}
