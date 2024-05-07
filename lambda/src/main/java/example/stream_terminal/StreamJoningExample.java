package example.stream_terminal;

import example.data.StudentDataBase;

import java.util.stream.Collectors;

public class StreamJoningExample {

    // get the all the student names separated by comma
    static String jonining_1() {
        return StudentDataBase.getAllStudents().stream()
                .map(student -> student.getName())
                .collect(Collectors.joining(","));
    }

    // get the all the student names separated by comma
    static String jonining_2() {
        return StudentDataBase.getAllStudents().stream()
                .map(student -> student.getName())
                .collect(Collectors.joining(",", "(", ")"));
    }
    public static void main(String[] args) {
        System.out.println(jonining_1());
        System.out.println(jonining_2());


    }
}
