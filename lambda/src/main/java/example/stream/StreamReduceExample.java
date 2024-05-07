package example.stream;

import example.data.Student;
import example.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {


    static Optional<Student> getHighestGpa() {
        return StudentDataBase.getAllStudents().stream()
                .reduce( (s1, s2) -> s1.getGpa() > s2.getGpa() ? s1 :s2);
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,3,5,7);
        int sum = numbers.stream().reduce(0, (a,b) -> a+b);
        System.out.println(sum);
        int multiple = numbers.stream().reduce(1, (a,b) -> a*b);
        System.out.println(multiple);

        System.out.println("==========");
        Optional<Integer> multipleWithoutIdentify = numbers.stream().reduce((a, b) -> a*b);
        System.out.println(multipleWithoutIdentify.get());
        System.out.println(multipleWithoutIdentify.isPresent());
        System.out.println("==========");
        Optional<Student> highestGpaStudent = getHighestGpa();
        System.out.println(highestGpaStudent.get());

    }
}
