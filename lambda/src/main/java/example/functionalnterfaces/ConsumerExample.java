package example.functionalnterfaces;

import example.data.Student;
import example.data.StudentDataBase;

import java.util.function.Consumer;

public class ConsumerExample {

    static  Consumer<Student> c1 = (student)-> System.out.print(student.getName());
    static  Consumer<Student> c2 = (student)-> System.out.println(student.getActivities());

    static void printName() {
        Consumer<Student> c1 = (student)-> System.out.println(student);
        StudentDataBase.getAllStudents().forEach(c1);
    }
    static void printNameAndSkill() {
        StudentDataBase.getAllStudents().forEach(c1.andThen(c2));
    }

    static void printNameAndSkillWithCondition() {
        StudentDataBase.getAllStudents().forEach((student) -> {
            if(student.getGradeLevel() >= 3 && student.getGpa() > 3) {
                c1.andThen(c2).accept(student);
            }
            });
    }

    public static void main(String[] args) {
        Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());
        c1.accept("naresh");

//        printNameAndSkill();
        printNameAndSkillWithCondition();
    }
}
