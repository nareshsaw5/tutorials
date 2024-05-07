package example.stream;

import example.data.Student;
import example.data.StudentDataBase;

import java.util.Optional;

public class StudentFindAnyFirstExample {

    static Optional<Student> findAnyStudent(double gpa){
        return StudentDataBase.getAllStudents().stream()
                .filter( student -> student.getGpa() >=gpa)
                .findAny();
    }

    static Optional<Student> findFirstStudent(double gpa){
        return StudentDataBase.getAllStudents().stream()
                .filter( student -> student.getGpa() >=gpa)
                .findFirst();
    }
    public static void main(String[] args) {
        System.out.println("Find any student with gpa 3.5 : "+findAnyStudent(3.5).get());
        System.out.println("Find first student with gpa 3.8 : "+findFirstStudent(3.8).get());

    }
}
