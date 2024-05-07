package example.functionalnterfaces;

import example.data.Student;
import example.data.StudentDataBase;

import java.util.function.Predicate;

public class PredicateExample {

    static Predicate<Student> predicate = student -> student.getGradeLevel() >= 3;
    static Predicate<Student> predicate_2 = student -> student.getGpa() >= 3.6;

    static void filterStudentsByGrade() {
        StudentDataBase.getAllStudents().forEach( student -> {if(predicate.test(student)) {
            System.out.println(student.getName() +", "+student.getGradeLevel());
        } });
    }

    static void filterStudentsByGpa() {
        StudentDataBase.getAllStudents().forEach( student -> {if(predicate_2.test(student)) {
            System.out.println(student.getName() +", "+student.getGpa());
        } });
    }

    static void filterStudents() {
        StudentDataBase.getAllStudents().forEach( student -> {if(predicate.and(predicate_2).test(student)) {
            System.out.println("name: "+student.getName() +" grade "+student.getGradeLevel()+", gpa: "+student.getGpa());
        } });
    }
    public static void main(String[] args) {
        Predicate<Integer> predicate = (i) -> i%2 == 0;
        System.out.println("is even "+predicate.test(10));
        filterStudents();
    }
}
