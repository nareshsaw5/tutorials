package example.stream_terminal;

import example.data.Student;
import example.data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamMappingExample {

    // get the list of names
    static List<String> getNames(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.mapping(Student::getName, Collectors.toList()));
    }

    // get the set of names
    static Set<String> getNames_1(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.mapping(Student::getName, Collectors.toSet()));
    }
    public static void main(String[] args) {
        System.out.println(getNames());
        System.out.println(getNames_1());
    }
}
