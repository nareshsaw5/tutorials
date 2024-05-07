package example.functionalnterfaces;

import example.data.Student;
import example.data.StudentDataBase;

import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class BiPredicateExample {

    static BiPredicate<Integer, Double> biPredicate = (grade, gpa) -> grade >= 3 && gpa >= 3.9;
    static Consumer<Student> consumer = (student) -> System.out.println(student);


    public static void main(String[] args) {
        StudentDataBase.getAllStudents().forEach( (student) -> { if(biPredicate.test(student.getGradeLevel(), student.getGpa())){
            consumer.accept(student);
        }});
    }
}
