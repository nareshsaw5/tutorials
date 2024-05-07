package example.stream_terminal;

import example.data.StudentDataBase;

import java.util.stream.Collectors;

public class StreamCountingExample {

    // get the count of student
    static long getCount(){
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa() > 3.9)
                .collect(Collectors.counting());
    }
    public static void main(String[] args) {
        System.out.println(getCount());
    }
}
