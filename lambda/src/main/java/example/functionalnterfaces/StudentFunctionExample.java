package example.functionalnterfaces;

import example.data.Student;
import example.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class StudentFunctionExample {

    // create a map from list
    static Function<List<Student>, Map<String, Double>> function = (students) -> {
        Map<String, Double> map = new HashMap<>();
        students.forEach((student -> {
            if(PredicateExample.predicate.test(student))
            map.put(student.getName(), student.getGpa());
        }));
        return map;
    };
    public static void main(String[] args) {
        Map<String, Double> mapOfStudent = function.apply(StudentDataBase.getAllStudents());
        System.out.println(mapOfStudent);
    }
}
