package example.defaults;

import example.data.Student;
import example.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class DefaultMethodExample2 {

    static Consumer<Student> studentConsumer = (student) -> System.out.println(student);
    static void sortByName(List<Student> students){
        Comparator<Student> namedComparator = Comparator.comparing(Student::getName);
        students.sort(namedComparator);
        students.forEach(studentConsumer);
    }

    static void sortByGpa(List<Student> students){
        Comparator<Student> namedComparator = Comparator.comparingDouble(Student::getGpa);
        students.sort(namedComparator);
        students.forEach(studentConsumer);
    }

    // comparator chaining
    static void sortBy(List<Student> students){
        students.sort(Comparator.comparing(Student::getName).thenComparing(Student::getGpa));
        students.forEach(studentConsumer);
    }
    public static void main(String[] args) {

        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(studentConsumer);
        System.out.println("++++++++");
        //sortByName(students);

        System.out.println("++++++++");
        //sortByGpa(students);

        System.out.println("++++++++");
        sortBy(students);


    }
}
