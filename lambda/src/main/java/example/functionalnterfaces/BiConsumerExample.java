package example.functionalnterfaces;

import example.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {


    static void printNameAndActivities() {
        BiConsumer<String, List<String>>  biConsumer = (name, activities) -> {
            System.out.println(name +": "+activities);
        };
        StudentDataBase.getAllStudents().forEach( (student) -> biConsumer.accept(student.getName(), student.getActivities()));
    }
    public static void main(String[] args) {

        BiConsumer<String, String> biConsumerPrint = (s1, s2) -> {
            System.out.println("s1 "+s1 +", s2 "+s2);
        };
        biConsumerPrint.accept("Java7", "Java8");

        BiConsumer<Integer, Integer> multiply = (i1, i2) -> {
            System.out.println("multiply "+i1*i2);
        };

        BiConsumer<Integer, Integer> divide = (i1, i2) -> {
            System.out.println("division "+i1/i2);
        };
        multiply.andThen(divide).accept(10,5);

        printNameAndActivities();
    }
}


