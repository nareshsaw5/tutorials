package example.functionalnterfaces;

import example.data.Student;
import example.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerExample {

    static Predicate<Student> p1 = student -> student.getGradeLevel() >= 3;
    static Predicate<Student> p2 = student -> student.getGpa() >= 3.9;
    static BiConsumer<String, List<String>> biConsumer = (name, activities) -> System.out.printf("name "+name +", activities "+activities);
    static Consumer<Student> consumer = (student) -> {
        if(p1.and(p2).test(student)){
            biConsumer.accept(student.getName(), student.getActivities());
        }
    };
    public static void main(String[] args) {
        StudentDataBase.getAllStudents().forEach(consumer);
    }
}
