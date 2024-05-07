package example.stream_terminal;

import example.data.Student;
import example.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class StreamGroupingByExample {

    static Map<String, List<Student>> getStudentsByGender(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGender));
    }

    static Map<String, List<Student>> getStudentsByGender_custom(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(student -> student.getGpa() >=3.8 ? "outstanding": "average"));
    }

    static  Map<Integer, Map<String, List<Student>>> twoLevelGrouping() {
       return StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel, groupingBy(student -> student.getGpa() >=3.8 ? "outstanding": "average")));
    }

    static  Map<Integer, Optional<Student>> getTopGpa() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel, maxBy(Comparator.comparing(Student::getGpa))));
    }

    static Map<Integer, Student> getTopGpa_avoidOptional() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,
                        collectingAndThen(maxBy(Comparator.comparing(Student::getGpa)),Optional::get)));
    }

    static Map<Integer, Student> getMinGpa_avoidOptional() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,
                        collectingAndThen(minBy(Comparator.comparing(Student::getGpa)),Optional::get)));
    }


    public static void main(String[] args) {
        System.out.println(getStudentsByGender());
        System.out.println("==========");
        System.out.println(getStudentsByGender_custom());
        System.out.println("==========");
        System.out.println(twoLevelGrouping());
        System.out.println("==========");
        System.out.println(getTopGpa());
        System.out.println("==========");
        System.out.println(getTopGpa_avoidOptional());
        System.out.println("==========");
        System.out.println(getMinGpa_avoidOptional());
    }
}
